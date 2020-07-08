package com.cpulover.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cpulover.aop.dao.AccountDAO;
import com.cpulover.aop.dao.MembershipDAO;

public class LoggingApp {

	public static void main(String[] args) {
		// Read Spring config Java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);

		// Get the beans from Spring container
		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
		MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);

		// Call the business method
		accountDAO.addAccount();
		accountDAO.addAccount2(new Account());
		accountDAO.addAccount3(new Account(), false);
		membershipDAO.addAccount();
		membershipDAO.addVIP();
		membershipDAO.addVIP2();

		// Close the context
		context.close();
	}

}
