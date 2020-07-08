package com.cpulover.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class TestingAspect {

	@Before("com.cpulover.aop.aspect.CommonAspect.forDAOpackage()")
	public void beforeTestAdvice(JoinPoint joinPoint) {
		System.out.println(">>> Testing 1 before DAO package");

		// get method signature
		MethodSignature methodSig = (MethodSignature) joinPoint.getSignature();
		System.out.println("[!] Method: " + methodSig);
		
		// get method parameters
		Object[] args=joinPoint.getArgs();
		for(Object arg : args) {
			System.out.println("[!] Params: "+ arg);
		}
	}

	@Before("com.cpulover.aop.aspect.CommonAspect.forDAOpackage()")
	public void beforeTestAdvice2() {
		System.out.println(">>> Testing 2 before DAO package");
	}

	@Before("com.cpulover.aop.aspect.CommonAspect.forDAOpackageNoGetterSetter()")
	public void beforeTestAdvice3() {
		System.out.println(">>> Testing before DAO package except getters, setters");
	}
}
