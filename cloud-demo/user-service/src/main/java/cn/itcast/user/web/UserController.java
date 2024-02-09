package cn.itcast.user.web;

import cn.itcast.user.config.PatternProperties;
import cn.itcast.user.pojo.User;
import cn.itcast.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Slf4j
@RestController
@RequestMapping("/user")
//@RefreshScope
public class UserController {
//    @Value("${pattern.dateformat}")
//    private String dateformat;

    @Autowired
    private PatternProperties patternProperties;


    @GetMapping("now")
    public String now() {
        System.out.println(patternProperties.getEnvShareValue());
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(patternProperties.getDateformat(), Locale.CHINA));
    }

    @Autowired
    private UserService userService;

    /**
     * 路径： /user/110
     *
     * @param id 用户id
     * @return 用户
     */
    @GetMapping("/{id}")
    public User queryById(@PathVariable("id") Long id,
                          @RequestHeader(value = "X-Request-red", required = false) String color) {
        System.out.println(color);
        return userService.queryById(id);
    }
}
