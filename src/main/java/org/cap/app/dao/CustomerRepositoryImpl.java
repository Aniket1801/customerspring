package org.cap.app.dao;

import java.util.*;

import org.cap.app.entities.*;
import org.cap.app.exceptions.*;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepositoryImpl implements ICustomerRepository {

	private Map<Long, Customer> store = new HashMap<Long, Customer>();

	private Long generatedId=0L;

	Long generateId() {
		++generatedId;
		return generatedId;
	}


	@Override
	public Customer add(Customer customer) {
		Long id = generateId();
		customer.setId(id);
		store.put(id, customer);
		return customer;
	}

	@Override
	public Customer update(Customer customer) {
		checkCustomerExist(customer.getId());
		store.put(customer.getId(), customer);
		return customer;
	}

	@Override
	public Customer findById(Long id) {
		checkCustomerExist(id);
		Customer customer = store.get(id);
		return customer;
	}

	public void checkCustomerExist(Long id) {
		Customer customer = store.get(id);
		if (customer == null) {
			throw new CustomerNotFoundException("No Customer found for Id - " + id);
		}
	}

}
