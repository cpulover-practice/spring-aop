package com.cpulover.aop.dao;

import org.springframework.stereotype.Component;

import com.cpulover.aop.entity.Account;

@Component
public class AccountDAO {
	private String name;
	private String code;

	public void addAccount() {
		System.out.println(getClass() + ": DOING DATABASE WORK - ADDING AN ACCOUNT\n");
	}

	public void addAccount2(Account account) {
		System.out.println(getClass() + ": DOING DATABASE WORK - ADDING AN ACCOUNT WITH INFO\n");
	}

	public void addAccount3(Account account, boolean isVIP) {
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
