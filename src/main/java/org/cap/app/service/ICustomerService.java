package org.cap.app.service;

import org.cap.app.entities.*;

public interface ICustomerService {

	Customer register(Customer customer);

	Customer updateName(Long id, String name);

	Customer findById(Long id);

}
