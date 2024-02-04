package com.itheima.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 测试切入点的相关逻辑
 */

@Component
@Aspect
@Slf4j
public class TestAspectJoinPoint {
    @Pointcut("execution(* com.itheima.service.DeptService.* (..))")
    private void pt() {}

    @Before("pt()")
    public void before(JoinPoint joinPoint) {
        log.info("TestAspectJoinPoint before");
    }

    @Around("pt()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {

        log.info("TestAspectJoinPoint around before");

        // 1. 获取目标对象类名；
        String className = joinPoint.getTarget().getClass().getName();
        log.info("className: {}", className);

        // 2. 获取目标方法的方法名；
        String methodName = joinPoint.getSignature().getName();
        log.info("methodName: {}", methodName);

        // 3. 获取目标方法运行时传入的参数；
        Object[] args = joinPoint.getArgs();
        log.info("args is : {}", Arrays.toString(args));

        // 4. 放行目标方法执行；
        Object ret = joinPoint.proceed();
        log.info("目标方法返回值是：{}", ret);

        log.info("TestAspectJoinPoint around after");

        return ret;
    }

}
