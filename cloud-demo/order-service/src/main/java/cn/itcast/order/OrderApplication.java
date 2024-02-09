package cn.itcast.order;

import cn.itcast.feign.clients.UserClient;
import cn.itcast.feign.config.DefaultFeignConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * mistake 没有加 EnableFeignClients 注解，导致无法扫描 Feign 客户端：因为Feign module就是不在 SpringBootApplication 的扫描范围之内
 * 其中clients = UserClient.class就是指定要扫描的包
 */

@MapperScan("cn.itcast.order.mapper")
@SpringBootApplication
// 启用feign客户端功能，并指定扫描Feign客户端所在路径；并指定默认配置类
@EnableFeignClients(clients = UserClient.class, defaultConfiguration = DefaultFeignConfiguration.class)
public class OrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}