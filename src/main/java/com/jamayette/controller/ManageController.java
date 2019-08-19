package com.jamayette.controller;

import com.jamayette.service.ITechService;
import com.jamayette.service.IBookService;
import com.jamayette.service.ILifeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
public class ManageController {

	private final ITechService techService;
	private final IBookService bookService;
	private final ILifeService lifeService;

	@RequestMapping("/m")
	public String mangePanel(Model model) {
		model.addAttribute(techService.findAllTechs());
		model.addAttribute(bookService.findAllBooks());
		model.addAttribute(lifeService.findAllLife());
		return "/manage/panel";
	}

}
