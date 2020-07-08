package com.cpulover.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	// pointcut expression matching to any classes, only 'void' return type, no args
	@Before("execution(public void addAccount())")
	public void beforeAddAccountAdvice() {
		System.out.println("Executing @Before advice on all addAccount(), 'void' return type");
	}

	// pointcut expression matching to class MembershipDAO with fully qualified
	// classname, only 'void' return type, no args
	@Before("execution(public void com.cpulover.aop.dao.MembershipDAO.addAccount())")
	public void beforeAddAccountAdvice2() {
		System.out.println("Executing @Before advice on MembershipDAO.addAccount(), 'void' return type");
	}

	// pointcut expression matching to any classes staring with add, only 'void'
	// return type, no args
	@Before("execution(public void add*())")
	public void beforeAddAdvice() {
		System.out.println("Executing @Before advice on all add*(), 'void' return type");
	}

	// pointcut expression matching to any classes staring with add, only 'boolean'
	// return type, no args
	@Before("execution(public boolean add*())")
	public void beforeAddAdviceBoolean() {
		System.out.println("Executing @Before advice on all add*(), 'boolean' return type");
	}

	// pointcut expression matching to any classes staring with add, all
	// return type, no args
	@Before("execution(* add*())")
	public void beforeAddAdviceAny() {
		System.out.println("Executing @Before advice on all add*(), all return types");
	}

	// pointcut expression matching to any classes staring with add, all
	// return type, only Account arg
	@Before("execution(* add*(com.cpulover.aop.Account))")
	public void beforeAddAdviceAnyReturnAccountArg() {
		System.out.println("Executing @Before advice on all add*(), all return types, only Account arg");
	}

	// pointcut expression matching to any classes staring with add, all
	// return type, Account arg and one or more any args
	@Before("execution(* add*(com.cpulover.aop.Account,..))")
	public void beforeAddAdviceAnyReturnAccountArg2() {
		System.out.println("Executing @Before advice on all add*(), all return types, Account and other arg");
	}

	// pointcut expression matching to all return types, com.cpulover.aop.dao
	// package, all classes, all methods with one or more args
	@Before("execution(* com.cpulover.aop.dao.*.*(..))")
	public void beforeDAO() {
		System.out.println("Executing @Before advice on all return types, com.cpulover.aop.dao"
				+ " package, all classes, all methods with one or more args");
	}
}
