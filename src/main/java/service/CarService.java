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

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import domain.Car;

public class CarService {

	public CarService() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("manager1");
		EntityManager entityManager = emf.createEntityManager();
	}

	public List<Car> getAllCars() {
		List<Car> carList = null;
		try {
			File file = new File("Cars.dat");
			if (!file.exists()) {
				Car car = new Car(120000, "Peugeot", "206", "grey");
				Car car2 = new Car(120000, "Opel", "Corsa", "grey");

				carList = new ArrayList<Car>();
				carList.add(car);
				carList.add(car2);
				saveCarList(carList);
			} else {
				FileInputStream fis = new FileInputStream(file);
				ObjectInputStream ois = new ObjectInputStream(fis);
				carList = (List<Car>) ois.readObject();
				ois.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return carList;
	}

	public Car getCar(int platenumber) {
		List<Car> cars = getAllCars();
		for (Car car : cars) {
			if (car.getPlateNumber() == platenumber) {
				return car;
			}
		}
		return null;
	}

	public int addCar(Car pCar) {
		List<Car> carList = getAllCars();
		boolean carExists = false;
		for (Car car : carList) {
			if (car.getPlateNumber() == pCar.getPlateNumber()) {
				carExists = true;
				break;
			}
		}
		if (!carExists) {
			carList.add(pCar);
			saveCarList(carList);
			return 1;
		}
		return 0;
	}

	public void updateCar(Car pCar) {
		List<Car> carList = getAllCars();
		for (Car car : carList) {
			if (car.getPlateNumber() == pCar.getPlateNumber()) {
				int index = carList.indexOf(car);
				carList.set(index, pCar);
				saveCarList(carList);

			}
		}

	}

	public void deleteCar(int platenumber) {
		List<Car> carList = getAllCars();
		for (Car car : carList) {
			if (car.getPlateNumber() == platenumber) {
				int index = carList.indexOf(car);
				carList.remove(index);
				saveCarList(carList);

			}
		}

	}

	private void saveCarList(List<Car> carList) {
		try {
			File file = new File("Cars.dat");
			FileOutputStream fos;
			fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(carList);
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}