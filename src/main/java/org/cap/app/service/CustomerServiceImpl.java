package org.cap.app.service;

import org.cap.app.dao.ICustomerRepository;
import org.cap.app.entities.Customer;
import org.cap.app.util.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	private ICustomerRepository customerRepository;

	@Override
	public Customer register(Customer customer) {
		ValidationUtil.checkName(customer.getName());
		customer = customerRepository.add(customer);
		return customer;
	}

	@Override
	public Customer updateName(Long id, String name) {
		Customer customer = customerRepository.findById(id);
		customer.setId(id);
		customer.setName(name);
		customer = customerRepository.update(customer);
		return customer;
	}

	@Override
	public Customer findById(Long id) {
		Customer customer = customerRepository.findById(id);
		return customer;
	}

}
