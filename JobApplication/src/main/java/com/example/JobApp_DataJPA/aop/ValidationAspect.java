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
public class ValidationAspect {
    public static final Logger LOGGER= LoggerFactory.getLogger(ValidationAspect.class);

    //return-type class-name.method-name(arguments)
    @Around("execution (* com.example.JobApp_DataJPA.service.JobService.getJob(..)) && args(postId)")
    public Object validatingId(ProceedingJoinPoint jp, int postId) throws Throwable {
        if(postId<0){
            LOGGER.info("Id is negative, it will be updated ");
            postId=-postId;
        }
        Object ob=jp.proceed(new Object[]{postId});
        LOGGER.info("Method Called "+ jp.getSignature().getName());
        return ob;

    }
}
