package com.itheima.aop;

import com.alibaba.fastjson.JSONObject;
import com.itheima.mapper.OperateLogMapper;
import com.itheima.pojo.OperateLog;
import com.itheima.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

@Component
@Aspect
@Slf4j
public class LogAspect {
    @Autowired
    private HttpServletRequest request;

    @Autowired
    private OperateLogMapper operateLogMapper;

    @Around("@annotation(com.itheima.anno.Log)")
    public Object recordLog(ProceedingJoinPoint joinPoint) throws Throwable {
        // 获取当前登录员工id（从请求头的JWT中获取）
        String jwt = request.getHeader("token");
        Claims claims = JwtUtils.parseJWT(jwt);
        Integer operateUser = (Integer) claims.get("id");

        // 获取类名
        String className = joinPoint.getTarget().getClass().getName();

        // 获取方法名
        String methodName = joinPoint.getSignature().getName();

        // 操作时间
        LocalDateTime operateTime = LocalDateTime.now();

        // 获取参数
        Object[] args = joinPoint.getArgs();
        String methodParams = Arrays.toString(args);

        // 获取返回值
        long begin = System.currentTimeMillis();
        Object ret = joinPoint.proceed();
        String returnValue = JSONObject.toJSONString(ret);


        long end = System.currentTimeMillis();
        long costTime = end - begin;

        log.info("cost time: {}", costTime);
        log.info("className：{}, methodName：{}, args: {}, returnValue: {}", className, methodName, methodParams, returnValue);

        OperateLog log = new OperateLog(null, operateUser, operateTime, className, methodName, methodParams, returnValue, costTime);
        operateLogMapper.insert(log);

        return ret;
    }
}
