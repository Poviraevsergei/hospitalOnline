package com.tms.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Aspect
@Component
public class LogAspect {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Before("within(com.tms.service.UserService)")
    public void logBeforeMethod(JoinPoint joinPoint) {
        log.info("Start doing method " + joinPoint.getSignature());
    }

    @After("within(com.tms.service.UserService)")
    public void logAfterMethod(JoinPoint joinPoint) {
        log.info("Finish doing method ");
    }

    @AfterReturning("within(com.tms.service.UserService)")
    public void logAfterReturningMethod() {

    }

    @AfterThrowing(throwing = "error", value = "within(com.tms.service.UserService)")
    public void logAfterThrowingMethod(Throwable error) {
        log.info("We have error: " + error);
    }

    @Around("@annotation(com.tms.annotations.CheckTimeAnnotation)")
    public void logAfterAroundMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        LocalTime start = LocalTime.now();
        System.out.println("Timer start...");
        joinPoint.proceed();
        LocalTime end = LocalTime.now();
        System.out.println("Timer end...");
        log.info(String.valueOf(end.getNano() - start.getNano()));
    }
}