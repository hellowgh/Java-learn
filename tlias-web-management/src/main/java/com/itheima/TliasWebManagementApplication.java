package com.itheima;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan // 开启对JavaWeb三大组件的支持
@SpringBootApplication
public class TliasWebManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(TliasWebManagementApplication.class, args);
	}

}
