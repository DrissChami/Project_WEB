package service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import domain.Transaction;

public class TransactionService {

	private Transaction transaction;

	public void saveTransactions() {
		List<Transaction> transactionList = null;
		try {
			File file = new File("Transactions.txt");
			if (!file.exists()) {
				// Transaction transac = new Transaction(1, "Driss", 23, true);
				transactionList = new ArrayList<Transaction>();
				transactionList.add(transaction);
				// saveCustomerList(customerList);
			} else {
				FileInputStream fis = new FileInputStream(file);
				ObjectInputStream ois = new ObjectInputStream(fis);
				transactionList = (List<Transaction>) ois.readObject();
				ois.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
