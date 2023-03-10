package com.ianhearne.burgertracker.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ianhearne.burgertracker.models.Burger;
import com.ianhearne.burgertracker.services.BurgerService;

@Controller
@RequestMapping("/burgers")
public class BurgerController {
	BurgerService service;
	
	public BurgerController(BurgerService burgerService) {
		this.service = burgerService;
	}
	
	@GetMapping("/")
	public String index(Model model, @ModelAttribute("burger") Burger burger) {
		List<Burger> burgerList = service.allBurgers();
		model.addAttribute("burgers", burgerList);
		return "index.jsp";
	}
	
	@PostMapping("/")
	public String createBurger(Model model, @Valid @ModelAttribute("burger") Burger burger, BindingResult result) {
		if(result.hasErrors()) {
			List<Burger> burgerList = service.allBurgers();
			model.addAttribute("burgers", burgerList);
			return "/index.jsp";
		} else {
			service.createBurger(burger);
			return "redirect:/burgers/";
		}
	}
	
	@GetMapping("/edit/{id}")
	public String editBurger(@PathVariable("id") Long id, Model model) {
		Burger burger = service.findBurger(id);
		model.addAttribute("burger", burger);
		return "edit.jsp";
	}
	
	@PutMapping("/{id}")
	public String saveBurger(@Valid @ModelAttribute("burger") Burger burger, BindingResult result, @PathVariable("id") Long id) {
		if(result.hasErrors()) {
			return "/edit.jsp";
		} else {
			service.updateBurger(burger);
			return "redirect:/burgers/";
		}
	}
}
