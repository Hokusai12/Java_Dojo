package com.ianhearne.authentication.controllers;

import java.util.Enumeration;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ianhearne.authentication.models.LoginUser;
import com.ianhearne.authentication.models.User;
import com.ianhearne.authentication.services.UserService;

@Controller
public class HomeController {
	@Autowired
	UserService userService;
	
	
	@GetMapping("/")
	public String loginAndRegistration(Model model) {
		model.addAttribute("newUser", new User());
		model.addAttribute("newLogin", new LoginUser());
		return "login.jsp";
	}
	
	@PostMapping("/register")
	public String registerNewUser(
			@Valid @ModelAttribute("newUser") User newUser,
			BindingResult result,
			Model model,
			HttpSession session) {
		
		if(result.hasErrors()) {
			model.addAttribute("newLogin", new LoginUser());
			return "/login.jsp";
		} else {
			User registeredUser = userService.register(newUser,  result);//Register user, returns null if any exceptions are met
			if(result.hasErrors()) {
				model.addAttribute("newLogin", new LoginUser());
				return "/login.jsp";
			}
			session.setAttribute("userId", registeredUser.getId());
			return "redirect:/welcome";
		}
	}
	
	@PostMapping("/login")
	public String loginUser(
			@Valid @ModelAttribute("newLogin") LoginUser newLogin,
			BindingResult result,
			Model model,
			HttpSession session) {
		if(result.hasErrors()) {
			model.addAttribute("newUser", new User());
			
			return "/login.jsp";
		} else {
			User currentUser = userService.login(newLogin, result);
			
			if(result.hasErrors()) {
				model.addAttribute("newUser", new User());
				return "/login.jsp";
			}
			session.setAttribute("userId", currentUser.getId());
			return "redirect:/welcome";
		}
	}
	
	@GetMapping("/welcome")
	public String welcome(Model model, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		Long userId = Long.parseLong(session.getAttribute("userId").toString());
		model.addAttribute("user", userService.findById(userId));
		return "welcome.jsp";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
