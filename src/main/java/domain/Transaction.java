package domain;

import java.util.Date;

public class Transaction {
	private int cpt;
	private Date date;
	private Customer customer;
	private Car car;

	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Transaction(int cpt, Date date, Customer customer, Car car) {
		super();
		this.cpt = cpt;
		this.date = date;
		this.customer = customer;
		this.car = car;
	}

	public int getCpt() {
		return cpt;
	}

	public void setCpt(int cpt) {
		this.cpt = cpt;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	@Override
	public String toString() {
		return "Transaction numero = " + cpt + "\n date = " + date + "\n customer = " + customer + "\n car = " + car;
	}

}
