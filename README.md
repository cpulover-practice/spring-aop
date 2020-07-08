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
5. Create Aspect class with @Aspect and @Component and add advices

## Concepts
- @Configuration 
- @EnableAspectJAutoProxy 
- @ComponentScan 
- AnnotationConfigApplicationContext
- Aspect and Advice
- @Aspect
- @Before advice
- Pointcut expression: ```execution(return_type package.class.method(params))```
  - Wildcards
[[LoggingAspect]()]
	- (): no args
    - (*): one arg, any types
    - (..): zero or more args, any types
    - (fully qualified classname)
  - Declare with @Pointcut 
[[TestingAspect]()]
  - Combine pointcut expressions using &&, ||, !
[[TestingAspect]()]

## Notes/Tips
- Quick copy fully qualified classname in that class
