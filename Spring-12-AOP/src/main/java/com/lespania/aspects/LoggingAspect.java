package com.lespania.aspects;

import com.lespania.controller.ProductController;
import com.lespania.entity.Product;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Aspect
@Configuration
public class LoggingAspect {
    Logger logger = LoggerFactory.getLogger(ProductController.class);

    //this is pointcut (WHERE will this happen)
    // this pointcut method will happen every method in the ProductController
    @Pointcut("execution(* com.lespania.controller.ProductController.*(..))")
    public void pointcut(){}

    //this is advice:
    //WHEN will this happen: Before methods
    @Before("pointcut()")
    public void log(){
        logger.info("-------------");
    }

    @Before("execution(* com.lespania.controller.ProductController.*(..))")
    public void beforeAdvice(){
        logger.info("-----------");
    }

    //    execution
//    @Pointcut("execution(* com.lespania.controller.ProductController.up*(..))")
//    private void anyUpdateOperation(){}
//
//    @Before("anyUpdateOperation()")
//    public void beforeControllerAdvice(JoinPoint joinPoint){
//        logger.info("Before -> Method {} - Arguments : {} - Target : {}",
//                joinPoint, joinPoint.getArgs(), joinPoint.getTarget());
//    }

    @Pointcut("execution(* com.lespania.repository.ProductRepository.findById(Long))")
    private void anyProductRepositoryFindById(){}

    @Before("anyProductRepositoryFindById()")
    public void beforeProductRepoAdvice(){
        logger.info("......findById.......");
    }

//    @Before("anyProductRepositoryFindById()")
//    public void beforeProductRepoAdvice(JoinPoint joinPoint){
//        logger.info("Before(findById) -> Method {} - Arguments : {} - Target : {}",joinPoint,joinPoint.getArgs(),joinPoint.getTarget());
//    }

    //within
    //all the classes inside the controller package (including all subpackages)
    @Pointcut("within(com.lespania.controller..*)")
    private void anyControllerOperation(){}

    //all classes with @Service annotation
    @Pointcut("@within(org.springframework.stereotype.Service)")
    private void anyServiceAnnotatedOperation(){}

    //this advice's target is anyServiceAnnotatedOperation() pointcut or
    // anyControllerOperation() pointcut
    @Before("anyServiceAnnotatedOperation() || anyControllerOperation() ")
    public void beforeControllerAdvice2(JoinPoint joinPoint){
        logger.info("Before -> Method : {} - Arguments : {} - Target : {}",
                joinPoint, joinPoint.getArgs(), joinPoint.getTarget());
    }

    //annotation
    //any method with @DeleteMapping annotation
    @Pointcut("@annotation(org.springframework.web.bind.annotation.DeleteMapping)")
    private void anyDeleteProductOperation(){}

    @Before("anyDeleteProductOperation()")
    public void beforeControllerAdvice(JoinPoint joinPoint){
        logger.info("Before -> Method : {} - Arguments : {} - Target : {}",
                joinPoint, joinPoint.getArgs(), joinPoint.getTarget());
    }

    //after returning
    @Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    private void anyGetProductOperation(){}

    //returning part will process the returning type
    @AfterReturning(pointcut = "anyGetProductOperation()", returning = "product")
    public void afterReturningControllerAdvice(JoinPoint joinPoint, Product product){
        logger.info("After Returning(Mono Result) -> Method : {} - results :{}",
                joinPoint.getSignature().toShortString(), product);
    }

    //returning part will process the returning type
    @AfterReturning(pointcut = "anyGetProductOperation()", returning = "results")
    public void afterReturningControllerAdvice2(JoinPoint joinPoint, List<Product> results){
        logger.info("After Returning(List Result) -> Method : {} - results :{}",
                joinPoint.getSignature().toShortString(), results);
    }

    //after throwing
    @Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    private void anyGetPutProductOperation(){}

    @AfterThrowing(pointcut = "anyGetPutProductOperation()", throwing = "exception")
    public void afterThrowingControllerAdvice(JoinPoint joinPoint,RuntimeException exception){
        logger.info("After Throwing(Send Email to L2 Team) -> Method: {} - Exception : {}",
                joinPoint.getSignature().toShortString(),exception.getMessage());
    }
}
