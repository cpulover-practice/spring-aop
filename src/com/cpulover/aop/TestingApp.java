package com.cpulover.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cpulover.aop.dao.AccountDAO;

public class TestingApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		accountDAO.addAccount();
		accountDAO.setName("cpulover");
		
		context.close();
	}

}
