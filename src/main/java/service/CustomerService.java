package service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import domain.Customer;

public class CustomerService {

	public List<Customer> getAllCustomers() {
		List<Customer> customerList = null;
		try {
			File file = new File("Customers.dat");
			if (!file.exists()) {
				Customer customer = new Customer(1, "Driss", "driss@mail.com", 23, true);
				Customer customer2 = new Customer(2, "Ayoub", "ayoub@mail.com", 22, false);
				customerList = new ArrayList<Customer>();
				customerList.add(customer);
				customerList.add(customer2);
				saveCustomerList(customerList);
			} else {
				FileInputStream fis = new FileInputStream(file);
				ObjectInputStream ois = new ObjectInputStream(fis);
				customerList = (List<Customer>) ois.readObject();
				ois.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return customerList;
	}

	public Customer getCustomer(int id) {
		List<Customer> customers = getAllCustomers();
		for (Customer customer : customers) {
			if (customer.getId() == id) {
				return customer;
			}
		}
		return null;
	}

	public int addCustomer(Customer pCustomer) {
		List<Customer> customerList = getAllCustomers();
		boolean customerExists = false;
		for (Customer customer : customerList) {
			if (customer.getId() == pCustomer.getId()) {
				customerExists = true;
				break;
			}
		}
		if (!customerExists) {
			customerList.add(pCustomer);
			saveCustomerList(customerList);
			return 1;
		}
		return 0;
	}

	// public void updateCar(Car pCar) {
	// List<Car> carList = getAllCars();
	// for (Car car : carList) {
	// if (car.getPlateNumber() == pCar.getPlateNumber()) {
	// int index = carList.indexOf(car);
	// carList.set(index, pCar);
	// saveCarList(carList);
	//
	// }
	// }

	// }

	public void deleteUser(int id) {
		List<Customer> customerList = getAllCustomers();
		for (Customer customer : customerList) {
			if (customer.getId() == id) {
				int index = customerList.indexOf(customer);
				customerList.remove(index);
				saveCustomerList(customerList);

			}
		}

	}

	private void saveCustomerList(List<Customer> customerList) {
		try {
			File file = new File("Customers.dat");
			FileOutputStream fos;
			fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(customerList);
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
