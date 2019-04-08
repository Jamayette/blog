package com.jamayette.controller;

import com.jamayette.util.QiniuUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class UploadController {

	@RequestMapping(value = "/imageUpload", method = RequestMethod.POST)
	@ResponseBody
	public String upload(@RequestParam(name = "upload") MultipartFile file, HttpServletRequest request, HttpServletResponse response) {

		if (file.isEmpty()) {
			return "文件为空";
		}

		String fileName = QiniuUtil.upload(file);

		try {

			response.setContentType("text/html;charset=UTF-8");
			String callback = request.getParameter("CKEditorFuncNum");
			ServletOutputStream out = response.getOutputStream();
			out.println("<script type=\"text/javascript\">");
			out.println("window.parent.CKEDITOR.tools.callFunction(" + callback + ",'" + QiniuUtil.QINIU_URL + fileName + "',''" + ")");
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
