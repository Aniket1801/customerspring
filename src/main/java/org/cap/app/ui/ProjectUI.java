package org.cap.app.ui;

import org.cap.app.entities.*;
import org.cap.app.exceptions.*;
import org.cap.app.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProjectUI {

	@Autowired
	private ICustomerService customerService;

	public void runUi() {

		Customer customer1 = add("Aniket");
		Long id1 = customer1.getId();
		Customer customer2 = add("Aman");
		Long id2 = customer2.getId();
		Customer customer3 = add("Rohit");
		Long id3 = customer3.getId();
		System.out.println("****Added Customers****");
		displayCustomerById(id1);
		displayCustomerById(id2);
		displayCustomerById(id3);
		updateCustomer(2L, "Arpit");
		System.out.println("****After Updating****");
		displayCustomerById(id2);

	}

	public Customer add(String name) {

		Customer customer = new Customer(name);
		customer = customerService.register(customer);
		System.out.println("Customer added with details, Id- " + customer.getId() + ", Name- " + customer.getName());
		return customer;
	}

	public void displayCustomerById(Long id) {
		Customer customer = customerService.findById(id);
		System.out.println("Customer fetched with details, Id- " + customer.getId() + ", Name- " + customer.getName());
	}

	public Customer updateCustomer(Long id, String name) {
		Customer customer = customerService.findById(id);
		customer = customerService.updateName(id, name);
		return customer;
	}

}
