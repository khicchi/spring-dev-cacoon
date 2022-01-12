package com.lespania.aspects;

import com.lespania.controller.ProductController;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

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
    //
    @Pointcut("@annotation(org.springframework.web.bind.annotation.DeleteMapping)")
    private void anyDeleteProductOperation(){}

    @Before("anyDeleteProductOperation()")
    public void beforeControllerAdvice(JoinPoint joinPoint){
        logger.info("Before -> Method : {} - Arguments : {} - Target : {}",
                joinPoint, joinPoint.getArgs(), joinPoint.getTarget());
    }
}
