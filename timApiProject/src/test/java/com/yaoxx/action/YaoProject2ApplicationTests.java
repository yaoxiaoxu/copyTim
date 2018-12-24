package com.yaoxx.action;

import org.apache.shiro.web.servlet.ShiroHttpServletRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.yaoxx.entity.sys.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class YaoProject2ApplicationTests {

	@Test
	public void contextLoads() {
		String name = ShiroHttpServletRequest.class.getName();
		System.out.println(name);
	}

}
