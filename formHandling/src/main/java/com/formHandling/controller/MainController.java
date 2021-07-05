package com.formHandling.controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.formHandling.entities.Data;
import com.formHandling.services.UserService;


@Controller
public class MainController{
	@Autowired
	private UserService userService;
	private static String imageDir = System.getProperty("user.dir") + "\\images";
	
	@GetMapping("/data")
	public String listUsers(Model model) {
		model.addAttribute("data", userService.getAllDatas());
		return "data";
	}
	
	@GetMapping("/data/new")
	public String registrationform(Model model) {
		Data data = new Data();
		model.addAttribute("data",data);
		return "registrationform";
	}

	@PostMapping("/data")
	public String saveData(@Valid @ModelAttribute("data") Data data,BindingResult bindingResult, @RequestParam("image") MultipartFile file, Model model) {
		if (bindingResult.hasErrors()) { 
			System.out.println("Errors \n" + bindingResult);
			return "registrationform";
			}
		System.out.println("Inside post data");
		Path fileNameAndPath = Paths.get(imageDir, data.getId() + file.getOriginalFilename());
		try {
			Files.write(fileNameAndPath, file.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Image uploaded");
		data.setProfileImage(data.getId() + file.getOriginalFilename());
		userService.saveData(data);
		System.out.println("Data saved in db" + data);
		return "redirect:/data";
	}

	@GetMapping("/data/edit/{id}")
	public String editForm(@PathVariable int id,Model model) {
		model.addAttribute("data",userService.getDataById(id));
		return "editform";
	}
	@PostMapping("/data/{id}")
	public String updateData(@PathVariable int id,
			@ModelAttribute("data") Data data, @RequestParam("image") MultipartFile file,
			Model model) {
		Data previousData=userService.getDataById(id);
		previousData.setId(id);
		previousData.setName(data.getName());
		previousData.setEmail(data.getEmail());
		previousData.setMobilenumber(data.getMobilenumber());
		previousData.setState(data.getState());
		previousData.setGender(data.getGender());
		previousData.setSkills(data.getSkills());
		Path fileNameAndPath = Paths.get(imageDir, data.getId() + file.getOriginalFilename());
		try {
			Files.write(fileNameAndPath, file.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		previousData.setProfileImage(data.getId() + file.getOriginalFilename());
		userService.updateData(previousData);
		return "redirect:/data";
	}
}

