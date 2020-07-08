package com.cpulover.aop.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

import com.cpulover.aop.entity.Account;

@Component
public class AccountDAO {
	private String name;
	private String code;

	// for @AfterReturning
	public List<Account> findAccounts() {
		List<Account> list = new ArrayList<Account>();
		// add sample data
		list.add(new Account("Hieu1", 1));
		list.add(new Account("Hieu2", 2));
		list.add(new Account("Hieu3", 3));
		System.out.println("In findAccounts()...");
		return list;
	}

	// for @AfterThrowing
	public void sillyMethod() {
		System.out.println("In sillyMethod()...");
		throw new RuntimeException("Bad day, huh?");
	}
	
	//for @Around
	public String readBook() {
		//simulate a delay
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Reading book...");
		return "Knowledge +1";
	}
	
	//for @Around handle and re-throw exception
	public void stupidMethod() {
		System.out.println("In stupidMethod()...");
		throw new RuntimeException("Bad day again, huh?");
	}

	public void addAccount() {
		System.out.println(getClass() + ": DOING DATABASE WORK - ADDING AN ACCOUNT\n");
	}

	public void addAccount(Account account) {
		System.out.println(getClass() + ": DOING DATABASE WORK - ADDING AN ACCOUNT WITH INFO\n");
	}

	public void addAccount(Account account, boolean isVIP) {
		System.out.println(getClass() + ": DOING DATABASE WORK - ADDING AN ACCOUNT WITH INFO, BOOLEAN\n");
	}

	public String getName() {
		System.out.println("in getName()\n");
		return name;
	}

	public void setName(String name) {
		System.out.println("in setName()\n");
		this.name = name;
	}

	public String getCode() {
		System.out.println("in getCode()\n");
		return code;
	}

	public void setCode(String code) {
		System.out.println("in setName()\n");
		this.code = code;
	}

}
