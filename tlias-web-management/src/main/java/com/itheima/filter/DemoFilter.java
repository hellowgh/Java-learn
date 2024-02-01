package com.itheima.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

@WebFilter(urlPatterns = "/*")
public class DemoFilter implements Filter {
    @Override // 初始化方法，只调用1次
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init");
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("放行前...");

        // 放行请求
        filterChain.doFilter(servletRequest, servletResponse);

        // 放行之后的逻辑
        System.out.println("放行后...");
    }

    @Override // 销毁，调用1次
    public void destroy() {
        System.out.println("destroy");
        Filter.super.destroy();
    }
}
