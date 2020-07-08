package com.cpulover.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TestingAspect {

	// declare pointcut for DAO package
	@Pointcut("execution(* com.cpulover.aop.dao.*.*())")
	private void forDAOpackage() {
	}

	// declare pointcut for DAO package, getter methods
	@Pointcut("execution(* com.cpulover.aop.dao.*.get*())")
	private void getter() {
	}

	// declare pointcut for DAO package, setter methods
	@Pointcut("execution(* com.cpulover.aop.dao.*.set*())")
	private void setter() {
	}

	// combine poincut: include DAO package, except getters and setters
	@Pointcut("forDAOpackage() && !(getter() || setter())")
	private void forDAOpackageNoGetterSetter() {
	}

	@Before("forDAOpackage()")
	public void beforeTestAdvice() {
		System.out.println(">>> Testing 1 before DAO package");
	}

	@Before("forDAOpackage()")
	public void beforeTestAdvice2() {
		System.out.println(">>> Testing 2 before DAO package");
	}
	
	@Before("forDAOpackageNoGetterSetter()")
	public void beforeTestAdvice3() {
		System.out.println(">>> Testing before DAO package except getters, setters");
	}
}
