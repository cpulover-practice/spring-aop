# List of practiced topics

## Configuaration
1. Add to build path:
   - Spring jars 
[[URL]()].
   - AspectJ Weaver jar to use AOP (avoid Beta version)
[[URL](https://mvnrepository.com/artifact/org.aspectj/aspectjweaver)].
2. Create Spring Java configuaration class with @Configuration, @EnableAspectJAutoProxy, @ComponentScan 
[[JavaConfig]()].
3. Create DAO class with @Component 
[[AccountDAO]()].
4. Create Main class 
[[LoggingApp]()]
   - Read Spring config Java class to get the context
   - Get the bean (class) from Spring container
   - Call the business method of the bean
   - Close the context
5. Create Aspect class with @Aspect and @Component 
[[LoggingAspect]()] 
[[References]()]
   - Setup logger [java.util.logging.Logger]
   - Setup pointcut declarations with @Pointcut
   - Add advices

## Concepts
- @Configuration 
- @EnableAspectJAutoProxy 
- @ComponentScan 
- AnnotationConfigApplicationContext
- Aspect with @Aspect 
- Advice 
[[LoggingAspect]()]
  - @Before
  - @AfterReturning: run after the method (success execution), use ```returning``` to get return result 
  - @AfterThrowing: run after the method (if exception thrown), use ``throwing`` and Throwable the capture the exception.
  - @After: run after the method (regardless of outcome)
  - @Around: run before and after the method, use ProceedingJoinPoint.proceed() to execute target method when desired.
- Pointcut expression: ```execution(return_type package.class.method(params))```
  - Wildcards
[[LoggingAspect]()]
	- (): no args
    - (*): one arg, any types
    - (..): zero or more args, any types
    - (fully qualified classname)
  - Declare with @Pointcut 
[[CommonExpress]()]
  - Combine pointcut expressions using &&, ||, !
[[CommonExpress]()]
- @Order 
  - Lower numbers have higher predence.
  - Negative numbers are allowed.
  - Does not have to be consecutive.
- JoinPoint: contains metadata of the method
[[TestingAspect]()]
  - MethodSignature and getSignature()
  - Objec[] and getArgs()

## Notes/Tips
- Quick copy fully qualified classname in that class
- Group related advices into seperate Aspects to order with @Order.
- Declare public pointcut expressions in a common class to share with other Aspects 
[[CommonExpress]()].
- Returnning result could be modified in @AfterReturning
- Order execution: @Before -> @Around (before) -> Method -> @Around (after) -> @After -> @AfterThrowing
- @AfterThrowing can not handle exception.
- @Advice can handle/rethrow exception using try catch block 
[[LoggingAspect]()].












