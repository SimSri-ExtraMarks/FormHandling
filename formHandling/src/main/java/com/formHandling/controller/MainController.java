package com.formHandling.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.formHandling.dao.Repository;
import com.formHandling.entities.Data;

@Controller

public class MainController {
	@Autowired
	private Repository repository;

	@GetMapping("/form")
	public String registrationform(Model model) {

		model.addAttribute("object", new Data());
		return "form";
	}

	@PostMapping("/submit")
	public String checkInfo(@Valid Data object, BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			return "form";
		}
		Data data = repository.save(object);
		model.addAttribute("object", data);
		//System.out.println(data);
		return "success";
	}
}