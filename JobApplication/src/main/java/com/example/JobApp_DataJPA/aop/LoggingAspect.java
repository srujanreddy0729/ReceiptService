package com.example.JobApp_DataJPA.aop;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class LoggingAspect {

    public static final Logger LOGGER=LoggerFactory.getLogger(LoggingAspect.class);

    //return-type class-name.method-name(arguments)
    @Before("execution (* com.example.JobApp_DataJPA.service.JobService.*(..))")
    public void logMethodCall(JoinPoint jp) {
        LOGGER.info("Method Called "+ jp.getSignature().getName());
    }
    //    @Before("execution (* com.example.JobApp_DataJPA.service.JobService.getAllJobs(..)) || execution (* com.example.JobApp_DataJPA.service.JobService.getJob(..))")
//    public void logMethodCall(JoinPoint jp) {
//        LOGGER.info("Method Called "+ jp.getSignature().getName());
//    }

    @After("execution (* com.example.JobApp_DataJPA.service.JobService.*(..))")
    public void logMethodExecuted(JoinPoint jp) {
        LOGGER.info("Method Executed "+ jp.getSignature().getName());
    }

    @AfterThrowing("execution (* com.example.JobApp_DataJPA.service.JobService.*(..))")
    public void logMethodThrowing(JoinPoint jp) {
        LOGGER.info("Method throwing "+ jp.getSignature().getName());
    }

    @AfterReturning("execution (* com.example.JobApp_DataJPA.service.JobService.*(..))")
    public void logMethodReturn(JoinPoint jp) {
        LOGGER.info("Method executed returning "+ jp.getSignature().getName());
    }




}