package com.cpulover.aop.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.cpulover.aop.entity.Account;

@Aspect
@Component
@Order(2)
public class LoggingAspect {

	// pointcut expression matching to any classes, only 'void' return type, no args
	@Before("execution(public void addAccount())")
	public void beforeAddAccountAdvice() {
		System.out.println(">>> Logging before all addAccount(), 'void' return type");
	}

	// advice after successful findAccounts()
	@AfterReturning(pointcut = "execution(* com.cpulover.aop.dao.AccountDAO.findAccounts(..))", returning = "result")
	public void afterReturnFindAccounts(JoinPoint joinPoint, List<Account> result) {
		System.out.println(">>> Logging after findAccounts()");
		System.out.println("    " + result + "\n");
	}

	// advice after throw exception sillyMethod()
	@AfterThrowing(pointcut = "execution(* com.cpulover.aop.dao.AccountDAO.sillyMethod(..))", throwing = "exp")
	public void afterThrowingSillyMethod(JoinPoint joinPoint, Throwable exp) {
		System.out.println(">>> Logging affter exception sillyMethod()");
		System.out.println("    " + exp);
	}

	// advice after DAO regardless of outcome
	@After("com.cpulover.aop.aspect.CommonExpress.forDAOpackage()")
	public void afterDAOFinally() {
		System.out.println(">>> Logging after DAO regardless of outcome");
	}

	// advice around readBook()
	@Around("execution(* com.cpulover.aop.dao.AccountDAO.readBook())")
	public Object aroundReadBook(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		System.out.println("Wearing glasses...");

		long begin = System.currentTimeMillis();
		Object result = proceedingJoinPoint.proceed();
		long end = System.currentTimeMillis();

		System.out.println("Throwing glasses...");
		System.out.println("Time spent: " + (end - begin));

		return result;
	}

	// advice around stupidMethod()
	@Around("execution(* com.cpulover.aop.dao.AccountDAO.stupidMethod())")
	public Object aroundStupidMethod(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		Object result = null;
		try {
			result = proceedingJoinPoint.proceed();
		} catch (Exception e) {
			// log the exception
			System.out.println("@Around catch exeption: " + e);

			// we can handle exception
			result = "Fixed";

			// or re-throw exception
			// throw e;
		}
		return result;
	}

	// pointcut expression matching to class MembershipDAO with fully qualified
	// classname, only 'void' return type, no args
//	@Before("execution(public void com.cpulover.aop.dao.MembershipDAO.addAccount())")
//	public void beforeAddAccountAdvice2() {
//		System.out.println(">>> Logging before MembershipDAO.addAccount(), 'void' return type");
//	}

	// pointcut expression matching to any classes staring with add, only 'void'
	// return type, no args
//	@Before("execution(public void add*())")
//	public void beforeAddAdvice() {
//		System.out.println(">>> Logging before all add*(), 'void' return type");
//	}

	// pointcut expression matching to any classes staring with add, only 'boolean'
	// return type, no args
//	@Before("execution(public boolean add*())")
//	public void beforeAddAdviceBoolean() {
//		System.out.println(">>> Logging before all add*(), 'boolean' return type");
//	}

	// pointcut expression matching to any classes staring with add, all
	// return type, no args
//	@Before("execution(* add*())")
//	public void beforeAddAdviceAny() {
//		System.out.println(">>> Logging before all add*(), all return types");
//	}

	// pointcut expression matching to any classes staring with add, all
	// return type, only Account arg
//	@Before("execution(* add*(com.cpulover.aop.entity.Account))")
//	public void beforeAddAdviceAnyReturnAccountArg() {
//		System.out.println(">>> Logging before all add*(), all return types, only Account arg");
//	}

	// pointcut expression matching to any classes staring with add, all
	// return type, Account arg and one or more any args
//	@Before("execution(* add*(com.cpulover.aop.entity.Account,..))")
//	public void beforeAddAdviceAnyReturnAccountArg2() {
//		System.out.println(">>> Logging before all add*(), all return types, Account and other arg");
//	}

	// pointcut expression matching to all return types, com.cpulover.aop.dao
	// package, all classes, all methods with one or more args
//	@Before("execution(* com.cpulover.aop.dao.*.*(..))")
//	public void beforeDAO() {
//		System.out.println(">>> Logging before all return types, com.cpulover.aop.dao"
//				+ " package, all classes, all methods with one or more args");
//	}
}
