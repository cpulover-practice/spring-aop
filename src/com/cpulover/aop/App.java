package com.cpulover.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cpulover.aop.dao.AccountDAO;

public class App {

	public static void main(String[] args) {
		// Read Spring config Java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);

		// Get the bean from Spring container
		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

		// Call the business method
		accountDAO.addAccount();

		// Close the context
		context.close();
	}

}
