package domain;

import java.io.Serializable;

public class Car implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int plateNumber;
	private String brand;
	private String model;
	private String color;

	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Car(int plateNumber, String brand, String model, String color) {
		super();
		this.plateNumber = plateNumber;
		this.brand = brand;
		this.model = model;
		this.color = color;
	}

	public int getPlateNumber() {
		return plateNumber;
	}

	public void setPlateNumber(int plateNumber) {
		this.plateNumber = plateNumber;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Car : " + brand + " " + model + "\n color :" + color + "\n plateNumber : " + plateNumber;
	}

}
