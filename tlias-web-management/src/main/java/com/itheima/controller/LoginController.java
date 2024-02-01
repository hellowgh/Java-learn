package com.itheima.controller;

import com.itheima.pojo.Emp;
import com.itheima.pojo.Result;
import com.itheima.service.EmpService;
import com.itheima.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/login")
@Slf4j
public class LoginController {
    @Autowired
    private EmpService empService;

    @PostMapping
    public Result login(@RequestBody Emp emp) {
        log.info("login, emp = {}", emp);

        Emp emp1 = empService.login(emp);

        if (emp1 != null) {
            // 登录成功，返回jwt
            Map<String, Object> claims = new HashMap<>();
            claims.put("id", "userId");
            claims.put("username", "username");

            String jwt = JwtUtils.generateJwt(claims);

            return Result.success(jwt);
        }

        // 登录失败
        return Result.error("用户名或密码错误");
    }
}
