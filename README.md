# List of practiced topics

## Configuaration
1. Add to build path:
   - Spring jars 
[[URL]()].
   - AspectJ Weaver jar to use AOP (avoid Beta version)
[[URL](https://mvnrepository.com/artifact/org.aspectj/aspectjweaver)].
2. Create Spring Java configuaration class with *__@Configuration__*, *__@EnableAspectJAutoProxy__*, *__@ComponentScan__* 
[[JavaConfig](https://github.com/cpulover-practice/spring-aop/blob/master/src/com/cpulover/aop/JavaConfig.java)].
3. Create DAO class with *__@Component__* 
[[AccountDAO](https://github.com/cpulover-practice/spring-aop/blob/master/src/com/cpulover/aop/dao/AccountDAO.java)].
4. Create Main class 
[[LoggingApp](https://github.com/cpulover-practice/spring-aop/blob/master/src/com/cpulover/aop/LoggingApp.java)]
   - Read Spring config Java class to get the context
   - Get the bean (class) from Spring container
   - Call the business method of the bean
   - Close the context
5. Create Aspect class with *__@Aspect__* and *__@Component__* 
[[LoggingAspect](https://github.com/cpulover-practice/spring-aop/blob/master/src/com/cpulover/aop/aspect/LoggingAspect.java)] 
   - Setup logger [java.util.logging.Logger]
   - Setup pointcut declarations with *__@Pointcut__*
   - Add advices

## Concepts
- *__@Configuration__* 
- *__@EnableAspectJAutoProxy__*
- *__@ComponentScan__* 
- AnnotationConfigApplicationContext
- Aspect with *__@Aspect__*
- Advice 
[[LoggingAspect](https://github.com/cpulover-practice/spring-aop/blob/master/src/com/cpulover/aop/aspect/LoggingAspect.java)]
  - *__@Before__*
  - *__@AfterReturning:__* run after the method (success execution), use *```returning```* to get return result 
  - *__@AfterThrowing:__* run after the method (if exception thrown), use *```throwing```* and Throwable the capture the exception.
  - *__@After:__* run after the method (regardless of outcome)
  - *__@Around:__* run before and after the method, use ```ProceedingJoinPoint.proceed()``` to execute target method when desired.
- Pointcut expression: ```execution(return_type package.class.method(params))```
  - Wildcards
[[LoggingAspect](https://github.com/cpulover-practice/spring-aop/blob/master/src/com/cpulover/aop/aspect/LoggingAspect.java)]
	- (): no args
    - (*): one arg, any types
    - (..): zero or more args, any types
    - (fully qualified classname)
  - Declare with *__@Pointcut__* 
[[CommonExpress](https://github.com/cpulover-practice/spring-aop/blob/master/src/com/cpulover/aop/aspect/CommonExpress.java)]
  - Combine pointcut expressions using &&, ||, !
[[CommonExpress](https://github.com/cpulover-practice/spring-aop/blob/master/src/com/cpulover/aop/aspect/CommonExpress.java)]
- *__@Order__* 
  - Lower numbers have higher predence.
  - Negative numbers are allowed.
  - Does not have to be consecutive.
- JoinPoint: contains metadata of the method
[[TestingAspect](https://github.com/cpulover-practice/spring-aop/blob/master/src/com/cpulover/aop/aspect/TestingAspect.java)]
  - MethodSignature and getSignature()
  - Objec[] and getArgs()

## Notes/Tips
- Quick copy fully qualified classname from that class
- Group related advices into seperate Aspects to order with *__@Order__*.
- Declare public pointcut expressions in a common class to share with other Aspects 
[[CommonExpress](https://github.com/cpulover-practice/spring-aop/blob/master/src/com/cpulover/aop/aspect/CommonExpress.java)].
- Returning result could be modified in *__@AfterReturning__*
- Order execution: *__@Before__* -> *__@Around__* (before) -> Method -> *__@Around__* (after) -> *__@After__* -> *__@AfterThrowing__*
- *__@AfterThrowing__* can not handle exception.
- *__@Advice__* can handle/rethrow exception using ```try catch``` block 
[[LoggingAspect](https://github.com/cpulover-practice/spring-aop/blob/master/src/com/cpulover/aop/aspect/LoggingAspect.java)].












