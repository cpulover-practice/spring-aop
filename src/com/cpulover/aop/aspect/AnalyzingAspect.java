package com.cpulover.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(-1)
public class AnalyzingAspect {
	@Before("com.cpulover.aop.aspect.CommonAspect.forDAOpackageNoGetterSetter()")
	public void beforeAnalyze() {
		System.out.println(">>> Analyzing before DAO");
	}
}
