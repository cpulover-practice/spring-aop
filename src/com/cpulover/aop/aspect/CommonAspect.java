package com.cpulover.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CommonAspect {
	// declare pointcut for DAO package
	@Pointcut("execution(* com.cpulover.aop.dao.*.*(..))")
	public void forDAOpackage() {
	}
	

	// declare pointcut for DAO package, getter methods
	@Pointcut("execution(* com.cpulover.aop.dao.*.get*(*))")
	public void getterDAO() {
	}

	// declare pointcut for DAO package, setter methods
	@Pointcut("execution(* com.cpulover.aop.dao.*.set*(*))")
	public void setterDAO() {
	}

	// combine poincut: include DAO package, except getters and setters
	@Pointcut("forDAOpackage() && !(getterDAO() || setterDAO())")
	public void forDAOpackageNoGetterSetter() {
	}
}
