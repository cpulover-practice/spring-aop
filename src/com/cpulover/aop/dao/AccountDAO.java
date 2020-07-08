package com.cpulover.aop.dao;

import org.springframework.stereotype.Component;

import com.cpulover.aop.Account;

@Component
public class AccountDAO {
	public void addAccount() {
		System.out.println(getClass() + ": DOING DATABASE WORK - ADDING AN ACCOUNT\n");
	}
	
	public void addAccount2(Account account) {
		System.out.println(getClass() + ": DOING DATABASE WORK - ADDING AN ACCOUNT WITH INFO\n");
	}
	
	public void addAccount3(Account account, boolean isVIP) {
		System.out.println(getClass() + ": DOING DATABASE WORK - ADDING AN ACCOUNT WITH INFO, BOOLEAN\n");
	}
}
