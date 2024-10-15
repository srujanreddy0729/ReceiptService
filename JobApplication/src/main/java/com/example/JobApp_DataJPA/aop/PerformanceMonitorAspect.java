package com.example.JobApp_DataJPA.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerformanceMonitorAspect {

    public static final Logger LOGGER= LoggerFactory.getLogger(PerformanceMonitorAspect.class);

    //return-type class-name.method-name(arguments)
    @Around("execution (* com.example.JobApp_DataJPA.service.JobService.*(..))")
    public Object monitorTime(ProceedingJoinPoint jp) throws Throwable {
        long start=System.currentTimeMillis();

        Object ob=jp.proceed();
        long end=System.currentTimeMillis();

        LOGGER.info("Method Called "+ jp.getSignature().getName()+" : "+ (end-start)+"ms");

        return ob;
    }
}
