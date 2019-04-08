package com.jamayette;

import com.jamayette.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BlogApplicationTests {

	@Autowired
	UserMapper userMapper;

	@Test
	public void myBlogTest() {

		String str1 = "hello world";
		int length = str1.length();
		System.out.println(length);

		System.err.println("hello test");
	}

}
