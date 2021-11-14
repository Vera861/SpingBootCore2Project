package com.geekbrains.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.Period;

@Aspect
@Component
public class Profiling {

    @Around("@annotation(profiler)")
    Object creatMethodProfiling(ProceedingJoinPoint joinPoint, Profiler profiler) throws Throwable {
        long startTime = System.nanoTime();
        Object o = joinPoint.proceed();
        long endTime = System.nanoTime();


        System.out.println("Method " + joinPoint.getSignature().getName()
                + " of " + joinPoint.getSignature().getDeclaringType()
                + " execution time is: " + (endTime - startTime) / 1_000_000L
                + "ms");
        return o;
    }
}
