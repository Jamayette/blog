package com.jamayette.controller;

import com.jamayette.model.Article;
import com.jamayette.service.IArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ArticleController {

	@Autowired
	private IArticleService articleService;

	@RequestMapping(value = {"/article", "/"})
	public String findAll(Model model) {
		List<Article> articleList = articleService.findAllArticles();
		model.addAttribute(articleList);
		return "article/list";
	}

	@RequestMapping("/article/{name}")
	public String findById(Model model, @PathVariable String name) {
		Article article = articleService.findArticleByName(name);
		if (article.getStatus() != 1) {
			return "/error/404";
		}
		model.addAttribute(article);
		return "article/detail";
	}

	@RequestMapping("/m/article/create")
	public String createArticle() {
		return "article/create";
	}

	@RequestMapping(value = "/m/article/create/submit")
	public String saveArticle(Article article) {
		boolean b = articleService.saveArticle(article);
		if (b) {
			return "/m";
		}
		return "/error/500";
	}

	@RequestMapping(value = "/m/article/edit/{id}")
	public String editArticle(@PathVariable Integer id, Model model) {
		Article article = articleService.findArticleById(id);
		model.addAttribute("article", article);
		return "article/edit";
	}

	@RequestMapping(value = "/m/article/edit/submit")
	public String editSubmit(Article article) {
		boolean b = articleService.editArticle(article);
		if (b) {
			return "/m";
		}
		return "/error/500";
	}

	@RequestMapping(value = "/m/article/delete/{id}")
	public String deleteArticle(@PathVariable Integer id) {
		Boolean b = articleService.deleteArticle(id);
		if (b) {
			return "/m";
		}
		return "/error/500";
	}

}
