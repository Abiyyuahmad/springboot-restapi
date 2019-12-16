package com.digimaster;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class AuditLog {


    private Logger logger = LoggerFactory.getLogger(AuditLog.class);

    // Pointcut definition to display all the available methods i.e. the advice will be called for all the methods.
    @Pointcut(value= "execution(* com.digimaster.services.UserServiceImpl.*(..))")
    private void logDisplaying() {
    }

    // @Around annotation declares the around advice which is applied before and after the method matching with a pointcut expression.
    @Around(value= "logDisplaying()")
    public void aroundAdvice(ProceedingJoinPoint pjp) throws Throwable {
        logger.info("Inside aroundAdvice() method...." + " Inserted before= " + pjp.getSignature().getName() + " method");

        try {
            pjp.proceed();
        } finally {
            // Do something useful.
        }

        logger.info("Inside aroundAdvice() method...." + " Inserted after= " + pjp.getSignature().getName() + " method");
    }
}
