package com.jamayette.controller;

import com.jamayette.mapper.UserMapper;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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

	@RequestMapping(value = "/imageUpload", method = RequestMethod.POST)
	@ResponseBody
	public String upload(@RequestParam(name = "upload") MultipartFile file, HttpServletRequest request, HttpServletResponse response) {
		if (file.isEmpty()) {
			return "文件为空";
		}
		String fileName = UploadUtil.upload(file);
		try {
			response.setContentType("text/html;charset=UTF-8");
			String callback = request.getParameter("CKEditorFuncNum");
			ServletOutputStream out = response.getOutputStream();
			out.println("<script type=\"text/javascript\">");
			out.println("window.parent.CKEDITOR.tools.callFunction(" + callback + ",'" + " URL " + fileName + "',''" + ")");
			out.println("</script>");
			out.flush();
			out.close();
			return "SUCCESS";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "FAIL";
	}

}
