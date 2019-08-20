package com.jamayette.controller;

import com.jamayette.model.Subject;
import com.jamayette.service.ISubjectService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class SubjectController {

	private final ISubjectService subjectService;

	@RequestMapping("/subject")
	public String findAllSubjects(Model model) {
		List<Subject> subjectList = subjectService.findAllSubjects();
		model.addAttribute("subjectList", subjectList);
		return "subject/list";
	}

	@RequestMapping("/m/subject/create")
	public String createSubject() {
		return "subject/create";
	}

	@RequestMapping(value = "/m/subject/create/submit")
	public String saveSubject(Subject subject) {
		boolean b = subjectService.saveSubject(subject);
		if (b) {
			return "/m";
		}
		return "/common/500";
	}

	@RequestMapping(value = "/m/subject/edit/{id}")
	public String editSubject(@PathVariable Integer id, Model model) {
		Subject subject = subjectService.findSubjectById(id);
		model.addAttribute("subject", subject);
		return "subject/edit";
	}

	@RequestMapping(value = "/m/subject/edit/submit")
	public String editSubmit(Subject subject) {
		boolean b = subjectService.editSubject(subject);
		if (b) {
			return "/m";
		}
		return "/common/500";
	}

	@RequestMapping(value = "/m/subject/delete/{id}")
	public String deleteSubject(@PathVariable Integer id) {
		Boolean b = subjectService.deleteSubject(id);
		if (b) {
			return "/m";
		}
		return "/common/500";
	}

}
