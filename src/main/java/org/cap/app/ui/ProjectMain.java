package org.cap.app.ui;

import org.cap.app.JavaConfiguration;
import org.cap.app.entities.Customer;
import org.cap.app.exceptions.CustomerNotFoundException;
import org.cap.app.exceptions.InvalidNameException;
import org.cap.app.ui.ProjectUI;
import org.cap.app.service.ICustomerService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ProjectMain {

	public static void main(String[] args) {
		try {
			AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
			context.register(JavaConfiguration.class);
			context.refresh();
			ProjectUI projectUi = context.getBean(ProjectUI.class);
			projectUi.runUi();
			context.close();
		} catch (InvalidNameException e) {
			System.out.println(e.getMessage());
		} catch (CustomerNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println("something went wrong.");
		}
	}
}
