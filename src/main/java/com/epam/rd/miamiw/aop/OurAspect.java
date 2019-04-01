package com.epam.rd.miamiw.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@Aspect
@Slf4j
public class OurAspect {

    @Around("execution(* com.epam.rd.miamiw.service.WeatherServiceImpl.getMiamiTemperature())")
    public Object adviceAnother(ProceedingJoinPoint pjp) throws Throwable {
        BigDecimal value = (BigDecimal) pjp.proceed();
        log.info("TWO");
        return value.multiply(BigDecimal.valueOf(-10));
    }

    @Around("execution(public * com.epam.rd.miamiw.service.WeatherServiceImpl.*())")
    public Object advice(ProceedingJoinPoint pjp) throws Throwable {
        //create stopwatch
        BigDecimal value = (BigDecimal) pjp.proceed();
        log.info("ONE");
        //stop stopwatch
        return value.multiply(BigDecimal.valueOf(-1));
    }


    @Around("@annotation(com.epam.rd.miamiw.service.Loggable)")
    public Object anotherAdvice(ProceedingJoinPoint pjp) throws Throwable {
        log.info(pjp.toString());
        return pjp.proceed();
    }
}
