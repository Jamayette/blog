package com.jamayette.controller;

import com.jamayette.model.Thoughts;
import com.jamayette.service.IThoughtsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ThoughtsController {

	@Autowired
	private IThoughtsService thoughtsService;

	@RequestMapping("/thoughts")
	public String findAll(Model model) {
		List<Thoughts> thoughtsList = thoughtsService.findAllThoughts();
		model.addAttribute(thoughtsList);
		return "thoughts/list";
	}

	@RequestMapping("/thoughts/{name}")
	public String findThoughtsByName(Model model, @PathVariable String name) {
		Thoughts thoughts = thoughtsService.findThoughtsByName(name);
		if (thoughts.getStatus() != 1) {
			return "/error/404";
		}
		model.addAttribute(thoughts);
		return "thoughts/detail";
	}

	@RequestMapping("/m/thoughts/create")
	public String createThoughts() {
		return "thoughts/create";
	}

	@RequestMapping(value = "/m/thoughts/create/submit")
	public String saveThoughts(Thoughts thoughts) {
		boolean b = thoughtsService.saveThoughts(thoughts);
		if (b) {
			return "/m";
		}
		return "/error/500";
	}

	@RequestMapping(value = "/m/thoughts/edit/{id}")
	public String editThoughts(@PathVariable Integer id, Model model) {
		Thoughts thoughts = thoughtsService.findThoughtsById(id);
		model.addAttribute("thoughts", thoughts);
		return "thoughts/edit";
	}

	@RequestMapping(value = "/m/thoughts/edit/submit")
	public String editSubmit(Thoughts thoughts) {
		boolean b = thoughtsService.editThoughts(thoughts);
		if (b) {
			return "/m";
		}
		return "/error/500";
	}

	@RequestMapping(value = "/m/thoughts/delete/{id}")
	public String deleteThoughts(@PathVariable Integer id) {
		Boolean b = thoughtsService.deleteThoughts(id);
		if (b) {
			return "/m";
		}
		return "/error/500";
	}

}
