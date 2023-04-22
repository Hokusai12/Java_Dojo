package com.ianhearne.tvdbexam.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ianhearne.tvdbexam.models.Rating;
import com.ianhearne.tvdbexam.models.Show;
import com.ianhearne.tvdbexam.models.User;
import com.ianhearne.tvdbexam.services.RatingService;
import com.ianhearne.tvdbexam.services.ShowService;
import com.ianhearne.tvdbexam.services.UserService;

@Controller
public class ShowController {
	@Autowired
	UserService userService;
	
	@Autowired
	ShowService showService;
	
	@Autowired
	RatingService ratingService;
	
	////	GET MAPPINGS    ////
	
	@GetMapping("/shows")
	public String homepage(Model model, HttpSession session) {
		
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		
		User user = userService.findById((Long) session.getAttribute("userId"));
		
		model.addAttribute("showList", showService.getAll());
		model.addAttribute("user", user);
		return "homepage.jsp";
	}
	
	@GetMapping("/shows/new")
	public String addShowForm(@ModelAttribute("newShow") Show newShow, Model model, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		model.addAttribute("userId", session.getAttribute("userId"));
		return "new-show.jsp";
	}
	
	@GetMapping("/shows/{id}")
	public String displayShow(@PathVariable Long id, Model model, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		
		Show show = showService.getById(id);
		Rating rating = new Rating();
		
		model.addAttribute("newRating", rating);		
		model.addAttribute("show", show);
		model.addAttribute("userId", session.getAttribute("userId"));
		return "display-show.jsp";
	}
	
	@GetMapping("/shows/{id}/edit")
	public String editShow(@PathVariable Long id, HttpSession session, Model model) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		
		Show show = showService.getById(id);
		
		//Checks that the show was posted by the user in session
		//Otherwise people could enter the URL and edit other people's data
		if(!show.getPoster().getId().equals((Long) session.getAttribute("userId"))) {
			return "redirect:/shows";
		}
		
		model.addAttribute("show", show);
		return "edit-show.jsp";
	}
	
	////	POST MAPPINGS    ////
	
	@PostMapping("/shows/new")
	public String saveShowToDB(@Valid @ModelAttribute("newShow") Show newShow, BindingResult result) {
		if(result.hasErrors()) {
			return "/new-show.jsp";
		}
		showService.add(newShow, result);
		if(result.hasErrors()) {
			return "/new-show.jsp";
		}
		return "redirect:/shows";
	}
	
	@PostMapping("/ratings/new")
	public String saveRating(@Valid @ModelAttribute("newRating") Rating rating, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("show", rating.getShow());
			return "/display-show.jsp";
		}
		ratingService.save(rating);
		return "redirect:/shows";
	}
		
	////	PUT MAPPINGS    ////
	
	@PutMapping("/shows/{id}/update")
	public String updateShow(@PathVariable Long id, @Valid @ModelAttribute("show") Show show, BindingResult result) {
		if(result.hasErrors()) {
			return "/edit-show.jsp";
		}
		showService.updateShow(show, result);
		if(result.hasErrors()) {
			return "/edit-show.jsp";
		}
		return "redirect:/shows";
	}
	
	////	DELETE MAPPINGS    ////
	
	@DeleteMapping("/shows/{id}/delete")
	public String deleteShow(@PathVariable Long id, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		showService.deleteShow(id);
		return "redirect:/shows";
	}
}
