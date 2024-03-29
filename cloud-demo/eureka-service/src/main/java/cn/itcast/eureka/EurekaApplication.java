package cn.itcast.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

// mistake 这里我生成module时，默认选择了java17版本，导致编译失败。在pom中更改了java版本后成功。

@SpringBootApplication
@EnableEurekaServer // 自动装配 eureka 开关
public class EurekaApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaApplication.class, args);
    }
}