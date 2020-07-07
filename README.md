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
[[Main]()]
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
- Aspect
- @Aspect
- @Before advice
- Pointcut expression

## Notes
