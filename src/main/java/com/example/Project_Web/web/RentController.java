package com.example.Project_Web.web;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import domain.Admin;
import domain.Car;
import domain.Customer;
import service.CarService;
import service.CustomerService;

@Controller
public class RentController {

	CarService carService = new CarService();
	CustomerService customerService = new CustomerService();

	@RequestMapping("/")
	public String getHomePage() {
		return "home.html";
	}

	@RequestMapping(value = "/user_inscription", method = RequestMethod.GET)
	public String getUserInscriptionPage() {
		return "redirect:/User_inscription.html";
	}

	@RequestMapping(value = "/adminpass", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Admin passwords() {
		Admin admin = new Admin("drissou", "drissou");
		return admin;
	}

	@RequestMapping(value = "/cars", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<Car> listOfCars() {
		return carService.getAllCars();
	}

	@RequestMapping(value = "/gestion_admin/customers", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<Customer> listOfCustomers() {
		return customerService.getAllCustomers();
	}

	@RequestMapping(value = "/geston_admin/customers/{id}", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Customer aCustomer(@PathVariable("id") int id) throws Exception {
		return customerService.getCustomer(id);
	}

	@RequestMapping(value = "/cars/{plateNumber}", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Car aCar(@PathVariable("plateNumber") int plateNumber) throws Exception {
		return carService.getCar(plateNumber);

	}

	@RequestMapping(value = "/cars/{plateNumber}", method = RequestMethod.DELETE, produces = "application/json; charset=UTF-8")
	@ResponseStatus(HttpStatus.OK)
	public void getBack(@PathVariable("plateNumber") int plateNumber) throws Exception {
		carService.deleteCar(plateNumber);

	}

	@RequestMapping(value = "/cars/{plateNumber}", method = RequestMethod.PUT, produces = "application/json; charset=UTF-8")
	@ResponseStatus(HttpStatus.OK)
	public void rent(@PathVariable("plateNumber") int plateNumber, @PathVariable("brand") String brand,
			@PathVariable("model") String model, @PathVariable("color") String color) throws Exception {
		Car car = new Car(plateNumber, brand, model, color);
		carService.addCar(car);
	}

	@RequestMapping(value = "/gestion_admin/customers/{id}", method = RequestMethod.PUT, produces = "application/json; charset=UTF-8")
	@ResponseStatus(HttpStatus.OK)
	public void rent(@PathVariable("id") int id, @PathVariable("name") String name, @PathVariable("email") String email,
			@PathVariable("age") int age, @PathVariable("haveLicence") boolean haveLicence) throws Exception {
		Customer customer = new Customer(id, name, email, age, haveLicence);
		customerService.addCustomer(customer);
	}

}
