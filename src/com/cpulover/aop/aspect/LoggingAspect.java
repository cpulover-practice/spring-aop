package com.cpulover.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	@Before("execution(public void addAccount())") // pointcut expression
	public void beforeAddAccountAdvice() {
		System.out.println("Executing @Before advice on addAccount()");
	}
}
