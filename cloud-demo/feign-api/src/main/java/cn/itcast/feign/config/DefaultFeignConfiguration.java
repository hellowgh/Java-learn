package cn.itcast.feign.config;

import feign.Logger;

public class DefaultFeignConfiguration {
    public Logger.Level logLevel(){

        // 测试
        // 在 orderApplication 上的 @EnableFeignClients 注解会开启这里的扫描
        System.out.println("=================");
        return Logger.Level.BASIC;
    }
}
