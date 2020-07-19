# Practiced Topics

## Configuaration
1. Add dependencies:
   - Spring framework jars 
[[URL]()]
   - AspectJ Weaver jar: supports AOP (avoid Beta version)
[[URL](https://mvnrepository.com/artifact/org.aspectj/aspectjweaver)]
2. Create Spring AOP Java configuaration class with *__@Configuration__*, *__@EnableAspectJAutoProxy__*, *__@ComponentScan__* 
[[JavaConfig](https://github.com/cpulover-practice/spring-aop/blob/master/src/com/cpulover/aop/JavaConfig.java)].
3. Create DAO class with *__@Component__* 
[[AccountDAO](https://github.com/cpulover-practice/spring-aop/blob/master/src/com/cpulover/aop/dao/AccountDAO.java)].
4. Create Main class 
[[LoggingApp](https://github.com/cpulover-practice/spring-aop/blob/master/src/com/cpulover/aop/LoggingApp.java)]
   1. Read Spring config Java class to get the context
   2. Get the bean (class) from Spring container
   3. Call the business method of the bean
   4. Close the context
5. Create Aspect class with *__@Aspect__* and *__@Component__* 
[[LoggingAspect](https://github.com/cpulover-practice/spring-aop/blob/master/src/com/cpulover/aop/aspect/LoggingAspect.java)] 
   1. Setup logger [java.util.logging.Logger] or use *__Logger__* with Lombok
   2. Setup pointcut declarations with *__@Pointcut__*
   3. Add advices

## Concepts
- *__@Configuration__* 
- *__@EnableAspectJAutoProxy__*
- *__@ComponentScan__* 
- AnnotationConfigApplicationContext
- Aspect with *__@Aspect__*
- Advice 
[[LoggingAspect](https://github.com/cpulover-practice/spring-aop/blob/master/src/com/cpulover/aop/aspect/LoggingAspect.java)]
  - *__@Before:__* run before the method
  - *__@AfterReturning:__* run after the method (success execution), use *```returning```* to get returning result 
  - *__@AfterThrowing:__* run after the method (if exception thrown), use *```throwing```* and ```Throwable``` the capture the exception, can not handle exception
  - *__@After:__* run after the method (regardless of outcome)
  - *__@Around:__* run before and after the method, use ```ProceedingJoinPoint.proceed()``` to execute target method when desired,  can handle/rethrow exception using ```try catch``` block 
- Pointcut expression: ```execution(return_type package.class.method(params))```
  - Wildcards
[[LoggingAspect](https://github.com/cpulover-practice/spring-aop/blob/master/src/com/cpulover/aop/aspect/LoggingAspect.java)]
    - (): no args
    - (*): one arg, any types
    - (..): zero or more args, any types
    - (fully qualified classname)
  - Declare with *__@Pointcut__* 
[[CommonAspect](https://github.com/cpulover-practice/spring-aop/blob/master/src/com/cpulover/aop/aspect/CommonExpress.java)]
  - Combine pointcut expressions using &&, ||, !
[[CommonAspect](https://github.com/cpulover-practice/spring-aop/blob/master/src/com/cpulover/aop/aspect/CommonExpress.java)]
- *__@Order:__* Decide the execution order of all Advices in a Aspect
  - Lower numbers have higher predence
  - Negative numbers are allowed
  - Does not have to be consecutive
- JoinPoint: contains metadata of the method
[[TestingAspect](https://github.com/cpulover-practice/spring-aop/blob/master/src/com/cpulover/aop/aspect/TestingAspect.java)]
  - Get method signature by ```MethodSignature``` and ```JoinPoint.getSignature()```
  - Get method parameters by ```Objec[]``` and ```JoinPoint.getArgs()```

## Notes - Tips
- 📌 Quick copy fully qualified classname from that class
- 📌 Group related advices into one Aspect to order with *__@Order__* (i.e., logging aspect, testing aspect)
- 📌 Declare public pointcut expressions in a common Aspect to share with other Aspects 
[[CommonAspect](https://github.com/cpulover-practice/spring-aop/blob/master/src/com/cpulover/aop/aspect/CommonExpress.java)].
- ℹ️ Order execution: *__@Before__* -> *__@Around__* (before) -> Method -> *__@Around__* (after) -> *__@After__* -> *__@AfterThrowing__*













