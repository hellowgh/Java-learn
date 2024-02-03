package com.itheima.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
@Component
public class TestAspect {

    // 完整的切入点表达式
    @Pointcut("execution(public void com.itheima.service.impl.DeptServiceImpl.deleteById(java.lang.Integer))")
    private void pt() {}

    @Before("pt()")
    public void before() {
        log.info("TestAspect: before");
    }
}
