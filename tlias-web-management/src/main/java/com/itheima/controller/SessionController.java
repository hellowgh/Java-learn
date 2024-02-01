package com.itheima.controller;

import com.itheima.pojo.Result;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

/**
 * 演示cookie技术
 */

@RestController
@Slf4j
public class SessionController {

    // 设置cookie
    @GetMapping("/c1")
    public Result cookie1(HttpServletResponse response) {
        response.addCookie(new Cookie("login_username", "hellowgh"));
        return Result.success();
    }

    // 获取cookie
    @GetMapping("/c2")
    public Result cookie2(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        for(Cookie cookie : cookies) {
            if (Objects.equals(cookie.getName(), "login_username")) {
                log.info("cookie user: {}", cookie);
                System.out.println("login_username:" + cookie.getValue());
            }
        }

        return Result.success();
    }

    @GetMapping("/s1")
    public Result session1(HttpSession session) {
        session.setAttribute("loginUser", "tom");
        return Result.success();
    }

    @GetMapping("/s2")
    public Result session2(HttpServletRequest request) {
        HttpSession session = request.getSession();

        Object loginUser = session.getAttribute("loginUser");

        log.info("session, user: {}", loginUser); // tom

        return Result.success();
    }

}
