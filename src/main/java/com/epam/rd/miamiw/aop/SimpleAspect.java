package com.epam.rd.miamiw.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Aspect
@Component
public class SimpleAspect {

    @Around("execution(* com.epam.rd.miamiw.service.WeatherServiceImpl.getMiamiTemperature())")
    public Object evilAdvice(ProceedingJoinPoint pjp) throws Throwable {
        BigDecimal returnValue = (BigDecimal) pjp.proceed();
        return returnValue.abs().multiply(BigDecimal.valueOf(-1));
    }

}
