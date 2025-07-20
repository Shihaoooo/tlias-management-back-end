package com.itheima;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

@SpringBootTest
class TliasWebManagementApplicationTests {

	@Autowired
	private JwtUtils jwtUtils;

	@Test
	void TestJwtUtils(){
		String jwt = jwtUtils.createJWT(Map.of("username","itheima"));

		System.out.println(jwt);

		Map<String,Object> map = jwtUtils.parseJWT(jwt);

		System.out.println(map);


	}
}
