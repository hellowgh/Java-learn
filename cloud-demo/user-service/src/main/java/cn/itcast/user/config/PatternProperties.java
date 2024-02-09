package cn.itcast.user.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "pattern") // 约定大于配置：前缀名+属性名跟配置文件中一致
public class PatternProperties {
    private String dateformat;
    private String envShareValue;
}
