package com.cpulover.aop.dao;

import org.springframework.stereotype.Component;

@Component
public class AccountDAO {
	public void addAccount() {
		System.out.println(getClass() + ": DOING DATABASE WORK - ADDING AN ACCOUNT");
	}
}
