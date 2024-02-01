package com.itheima.filter;

import com.alibaba.fastjson.JSONObject;
import com.itheima.pojo.Result;
import com.itheima.utils.JwtUtils;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.io.IOException;

@WebFilter(urlPatterns = "/*")
@Slf4j
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;

        // 1. 获取请求url
        String url = req.getRequestURL().toString();
        log.info("请求url：{}", url);

        // 2. 判断请求url中是否包含login
        if(url.contains("login")) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        // 3. 获取请求头中的令牌
        String jwt = req.getHeader("token");

        // 4. 判断令牌是否合法
        if (!StringUtils.hasLength(jwt)) {
            Result error = Result.error("NOT_LOGIN");

            // 手动转换json对象
            String notLogin = JSONObject.toJSONString(error);

            // 手动响应结果
            res.getWriter().write(notLogin);

            return;
        }

        // 5. 解析token，如果解析失败，返回错误结果
        try {
            JwtUtils.parseJWT(jwt);
        } catch (Exception e) {
            e.printStackTrace();
            log.info("解析令牌失败，{}", jwt);

            Result error = Result.error("NOT_LOGIN");

            // 手动转换json对象
            String notLogin = JSONObject.toJSONString(error);

            // 手动响应结果
            res.getWriter().write(notLogin);

            return;
        }

        // 6. 一切正常，放行
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
