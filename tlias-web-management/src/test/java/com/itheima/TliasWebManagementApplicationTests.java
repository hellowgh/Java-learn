package com.itheima;

import com.itheima.controller.DeptController;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class TliasWebManagementApplicationTests {
	@Autowired
	 private ApplicationContext applicationContext;


	@Test
	public void testGetBean() {
		DeptController bean1 = (DeptController) applicationContext.getBean("deptController");
		DeptController bean2 = applicationContext.getBean(DeptController.class);
		DeptController bean3 = applicationContext.getBean("deptController", DeptController.class);

		System.out.println("----------");
		System.out.println(bean1);
		System.out.println(bean2);
		System.out.println(bean3);
	}

	@Test
	void contextLoads() {
	}

	/**
	 * 生成JWT
	 */
	@Test
	public void testGenJwt() {
		Map<String, Object> claims = new HashMap<>();
		claims.put("id", 1);
		claims.put("name", "tom");

		String secretKey = "mySecret";

		String jwt = Jwts.builder()
				.signWith(SignatureAlgorithm.HS256, secretKey) // 签名算法部分
				.setClaims(claims) // 载荷部分（自定义内容）
				.setExpiration(new Date(System.currentTimeMillis() + 3600 * 1000)) // 超期时间
				.compact();

		System.out.println("===============");
		System.out.println(jwt);
		System.out.println("===============");

	}

	@Test
	public void testParseJwt() {
		String token = "eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoidG9tIiwiaWQiOjEsImV4cCI6MTcwNjc5NDA2NH0.ubW2H9Lu5w5txHUiJRjqiDD4MyPiRN3RvwdFtLVggxM";

		Claims claims = Jwts.parser()
				.setSigningKey("mySecret")
				.parseClaimsJws(token)
				.getBody();

		System.out.println("============");
		System.out.println(claims);
		System.out.println("============");
	}
}
