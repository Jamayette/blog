package com.jamayette.controller;

import com.jamayette.model.Life;
import com.jamayette.service.ILifeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class LifeController {

	private final ILifeService lifeService;

	@RequestMapping("/life")
	public String findAll(Model model) {
		List<Life> lifeList = lifeService.findAllLife();
		model.addAttribute(lifeList);
		return "life/list";
	}

	@RequestMapping("/life/{name}")
	public String findLifeByName(Model model, @PathVariable String name) {
		Life life = lifeService.findLifeByName(name);
		if (life.getStatus() != 1) {
			return "/common/404";
		}
		model.addAttribute(life);
		return "life/detail";
	}

	@RequestMapping("/m/life/create")
	public String createLife() {
		return "life/create";
	}

	@RequestMapping(value = "/m/life/create/submit")
	public String saveLife(Life life) {
		boolean b = lifeService.saveLife(life);
		if (b) {
			return "/m";
		}
		return "/common/500";
	}

	@RequestMapping(value = "/m/life/edit/{id}")
	public String editLife(@PathVariable Integer id, Model model) {
		Life life = lifeService.findLifeById(id);
		model.addAttribute("life", life);
		return "life/edit";
	}

	@RequestMapping(value = "/m/life/edit/submit")
	public String editSubmit(Life life) {
		boolean b = lifeService.editLife(life);
		if (b) {
			return "/m";
		}
		return "/common/500";
	}

	@RequestMapping(value = "/m/life/delete/{id}")
	public String deleteLife(@PathVariable Integer id) {
		Boolean b = lifeService.deleteLife(id);
		if (b) {
			return "/m";
		}
		return "/common/500";
	}

}
