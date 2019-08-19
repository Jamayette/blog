package com.jamayette.controller;

import com.jamayette.model.Tech;
import com.jamayette.service.ITechService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class TechController {

	private final ITechService techService;

	@RequestMapping("/tech")
	public String findAll(Model model) {
		List<Tech> techList = techService.findAllTechs();
		model.addAttribute(techList);
		return "tech/list";
	}

	@RequestMapping("/tech/{name}")
	public String findByName(@PathVariable String name, Model model) {
		Tech tech = techService.findTechByName(name);
		if (tech.getStatus() != 1) {
			return "/common/404";
		}
		model.addAttribute(tech);
		return "tech/detail";
	}

	@RequestMapping("/m/tech/create")
	public String createTech() {
		return "tech/create";
	}

	@RequestMapping(value = "/m/tech/create/submit")
	public String saveTech(Tech tech) {
		boolean b = techService.saveTech(tech);
		if (b) {
			return "/m";
		}
		return "/common/500";
	}

	@RequestMapping(value = "/m/tech/edit/{id}")
	public String editTech(@PathVariable Integer id, Model model) {
		Tech tech = techService.findTechById(id);
		model.addAttribute("tech", tech);
		return "tech/edit";
	}

	@RequestMapping(value = "/m/tech/edit/submit")
	public String editSubmit(Tech tech) {
		boolean b = techService.editTech(tech);
		if (b) {
			return "/m";
		}
		return "/common/500";
	}

	@RequestMapping(value = "/m/tech/delete/{id}")
	public String deleteTech(@PathVariable Integer id) {
		Boolean b = techService.deleteTech(id);
		if (b) {
			return "/m";
		}
		return "/common/500";
	}

}
