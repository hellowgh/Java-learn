package com.itheima.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.itheima.pojo.Result;
import com.itheima.utils.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
@Slf4j
public class LoginCheckInterceptor implements HandlerInterceptor {
    @Override // 目标controller运行前执行；返回true：放行。
    public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler) throws Exception {
        System.out.println("prehandler...");

        // 1. 获取请求url
        String url = req.getRequestURL().toString();
        log.info("拦截url：{}", url);

        // 2. 获取请求头中的令牌
        String jwt = req.getHeader("token");

        // 3. 判断令牌是否合法
        if (!StringUtils.hasLength(jwt)) {
            Result error = Result.error("NOT_LOGIN");

            // 手动转换json对象
            String notLogin = JSONObject.toJSONString(error);

            // 手动响应结果
            res.getWriter().write(notLogin);

            return false;
        }

        // 4. 解析token，如果解析失败，返回错误结果
        try {
            JwtUtils.parseJWT(jwt);
        } catch (Exception e) {
            e.printStackTrace();

            Result error = Result.error("NOT_LOGIN");

            // 手动转换json对象
            String notLogin = JSONObject.toJSONString(error);

            // 手动响应结果
            res.getWriter().write(notLogin);

            return false;
        }

        // 5. 一切正常，放行
        return true;
    }

    @Override // 目标controller运行后执行
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandler");
    }

    @Override // 视图渲染完毕后运行
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion");
    }
}
