package com.itheima.utils;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 工具类
 */
@Component
@Data
@ConfigurationProperties(prefix = "aliyun.oss")
public class TestComponent {

    private String bucketName;

    private String accessKeyId;

    private String accessKetSecret;

    public void test() {
        System.out.println("test");
    }

}
