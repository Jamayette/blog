package com.jamayette.controller;

import com.jamayette.mapper.UserMapper;
import com.jamayette.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class CentralController {

	@Autowired
	UserMapper userMapper;

	@RequestMapping("")
	public String index() {
		return "/article";
	}

	@RequestMapping("/auth")
	public String goAuth() {
		return "/manage/auth";
	}

	@RequestMapping(value = "/doAuth")
	public void auth(String auth, HttpServletRequest request, HttpServletResponse response) throws IOException {
		User user = new User();
		user.setPassword(auth);
		User checkUser = userMapper.selectOne(user);
		if (checkUser != null) {
			request.getSession().setAttribute("token", "jamayette");
			response.sendRedirect("/m");
		} else {
			response.sendRedirect("/");
		}

	}

}
