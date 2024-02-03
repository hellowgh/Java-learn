package com.itheima.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Aspect
public class TimeAspect {
    @Pointcut("execution(* com.itheima.service.*.*(..))")
    private void pt() {}

    // 切入点表达式
    @Around("pt()")
    public Object recordTime(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("around before...");

        // 1. 记录开始时间
        long begin = System.currentTimeMillis();

        // 2. 执行原始方法
        Object ret = joinPoint.proceed();

        // 3. 记录结束时间，输出日志
        long end = System.currentTimeMillis();
        long time = end - begin;
        log.info(joinPoint.getSignature() + "方法执行时间是：{}", time);

        log.info("around after...");

        return ret;
    }

    @Before("pt()")
    public void before() {
        log.info("before...");
    }

    @After("pt()")
    public void after() {
        log.info("after...");
    }
}
