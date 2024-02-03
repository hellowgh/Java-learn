package com.itheima.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Aspect
public class TimeAspect {

    // 切入点表达式
    @Around("execution(* com.itheima.service.*.*(..))")
    public Object recordTime(ProceedingJoinPoint joinPoint) throws Throwable {
        // 1. 记录开始时间
        long begin = System.currentTimeMillis();

        // 2. 执行原始方法
        Object ret = joinPoint.proceed();

        // 3. 记录结束时间，输出日志
        long end = System.currentTimeMillis();
        long time = end - begin;
        log.info(joinPoint.getSignature() + "方法执行时间是：{}", time);

        return ret;
    }
}
