package com.itheima.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

/**
 * 测试Filter链
 */

@WebFilter
public class SecondFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        System.out.println("第二个Filter拦截...");

        filterChain.doFilter(servletRequest, servletResponse);

//        System.out.println("第二个Filter放行后...");
    }
}
