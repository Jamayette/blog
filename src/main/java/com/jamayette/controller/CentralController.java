package com.jamayette.controller;

import com.jamayette.mapper.UserMapper;
import com.jamayette.model.UploadResponse;
import com.jamayette.model.User;
import com.jamayette.service.ISubjectService;
import com.jamayette.service.ILifeService;
import com.jamayette.service.ITechService;
import com.jamayette.util.UploadUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@AllArgsConstructor
public class CentralController {

	private final UserMapper userMapper;
	private final ITechService techService;
	private final ISubjectService subjectService;
	private final ILifeService lifeService;

	@RequestMapping("")
	public String index() {
		return "/tech";
	}

	@RequestMapping("/about")
	public String findAll() {
		return "about/about";
	}

	@RequestMapping("/m")
	public String mangePanel(Model model) {
		model.addAttribute(techService.findAllTechs());
		model.addAttribute(subjectService.findAllSubjects());
		model.addAttribute(lifeService.findAllLife());
		return "/manage/panel";
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

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	@ResponseBody
	public UploadResponse upload(HttpServletRequest request, HttpServletResponse response) throws Exception {
		UploadResponse uploadResponse = new UploadResponse();

		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		List<MultipartFile> files = multipartRequest.getFiles("file");
		if (files.isEmpty()){
			uploadResponse.setErrno(1);
		} else {
			uploadResponse.setErrno(0);
			List<String> dataList = new ArrayList<>();
			for (MultipartFile file : files) {
				String url = UploadUtil.upload(file);
				dataList.add(url);
			}
			uploadResponse.setData(dataList);
		}
		return uploadResponse;
	}

}
