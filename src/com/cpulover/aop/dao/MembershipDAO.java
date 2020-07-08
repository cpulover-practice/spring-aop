package com.cpulover.aop.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
	public void addAccount() {
		System.out.println(getClass() + ": DOING DATABASE WORK - ADDING AN ACCOUNT\n");
	}
	
	public void addVIP() {
		System.out.println(getClass() + ": DOING DATABASE WORK - ADDING A VIP\n");
	}
	
	public boolean addVIP2() {
		System.out.println(getClass() + ": DOING DATABASE WORK - ADDING A VIP, RETURN TRUE\n");
		return true;
	}
}
