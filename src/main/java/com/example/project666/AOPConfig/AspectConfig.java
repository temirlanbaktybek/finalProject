package com.example.project666.AOPConfig;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class AspectConfig {

    @Pointcut("@annotation(Aop)")
    public void executeLogging(){}

    @Before(value = "execution(* com.example.project666.Controller.JobSeekerController.getJobSeeker())")
    public void logMethodCall(JoinPoint joinPoint){
        log.info("Method call: {}", joinPoint.getSignature().getName());
    }

    @AfterReturning(pointcut = "executeLogging()", returning = "result")
    public void logMethodReturn(JoinPoint joinPoint, Object result){
        log.info("Method return: {}", joinPoint.getSignature().getName());
    }

    @After("executeLogging()")
    public void logMethodExit(JoinPoint joinPoint){
        log.info("Method exit: {}", joinPoint.getSignature().getName());
    }

    @Around("executeLogging()")
    public void Around(JoinPoint joinPoint){
        log.info("Method around: {}", joinPoint.getSignature().getName());
    }

    @AfterThrowing("executeLogging()")
    public void Throwing(JoinPoint joinPoint){
        log.info("Method Throwing: {}", joinPoint.getSignature().getName());
    }
}


