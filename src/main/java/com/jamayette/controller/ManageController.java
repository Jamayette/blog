package com.jamayette.controller;

import com.jamayette.service.IArticleService;
import com.jamayette.service.IBookService;
import com.jamayette.service.IMovieService;
import com.jamayette.service.IThoughtsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/m")
public class ManageController {

	@Autowired
	private IArticleService articleService;
	@Autowired
	private IBookService bookService;
	@Autowired
	private IThoughtsService thoughtsService;
	@Autowired
	private IMovieService movieService;

	@RequestMapping("")
	public String mangePanel(Model model) {
		model.addAttribute(articleService.findAllArticles());
		model.addAttribute(bookService.findAllBooks());
		model.addAttribute(thoughtsService.findAllThoughts());
		model.addAttribute(movieService.findAllMovies());
		return "/manage/panel";
	}

}
