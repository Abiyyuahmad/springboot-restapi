package com.digimaster;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class AuditLog {


    private Logger logger = LoggerFactory.getLogger(AuditLog.class);

    //What kind of method calls I would intercept
    //execution(* PACKAGE.*.*(..))
    //Weaving & Weaver
    @Before("execution(* com.digimaster.services.UserServiceImpl.*(..))")
    public void before(JoinPoint joinPoint){
        //Advice
        logger.info(" Check for user access ");
        logger.info(" Allowed execution for {}", joinPoint);
    }

    @AfterReturning(value = "execution(* com.digimaster.services.UserServiceImpl.*(..))",
            returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        logger.info("{} returned with value {}", joinPoint, result);
    }

    @After(value = "execution(* com.digimaster.services.UserServiceImpl.*(..))")
    public void after(JoinPoint joinPoint) {
        logger.info("after execution of {}", joinPoint);
    }

}
