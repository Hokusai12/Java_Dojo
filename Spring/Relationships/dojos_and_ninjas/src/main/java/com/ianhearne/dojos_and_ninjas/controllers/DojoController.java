package com.ianhearne.dojos_and_ninjas.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ianhearne.dojos_and_ninjas.models.Dojo;
import com.ianhearne.dojos_and_ninjas.services.DojoService;

@Controller
@RequestMapping("/dojos")
public class DojoController {
	@Autowired
	private DojoService dojoService;

	////GET ROUTES////
	@GetMapping("/new")
	public String newDojo(@ModelAttribute("dojo") Dojo dojo) {
		return "dojo_form.jsp";
	}
	
	@GetMapping("/{dojoId}")
	public String showDojo(@PathVariable(name="dojoId") Long dojoId, Model model) {
		model.addAttribute("dojo", dojoService.findDojo(dojoId));
		return "show_dojo.jsp";
	}
	
	////POST ROUTES////
	@PostMapping("/create")
	public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if(result.hasErrors()) {
			return "/dojo_form.jsp";
		} else {
			dojoService.create(dojo);
			return "redirect:/dojos/new";
		}
	}
	
}
