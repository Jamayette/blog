package com.jamayette;

import com.jamayette.mapper.UserMapper;
import com.jamayette.model.User;
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

//		User user = userMapper.selectUser(1);
//		System.err.println(user);
//
//		userMapper.updateUser();

	}

}
