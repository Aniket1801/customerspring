package org.cap.app.dao;

import org.cap.app.entities.*;

public interface ICustomerRepository {

	Customer add(Customer customer);

	Customer update(Customer customer);

	Customer findById(Long id);
}
