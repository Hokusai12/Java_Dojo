package com.ianhearne.counter.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CounterController {
	@GetMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@GetMapping("/counter")
	public String counter(Model model, HttpSession session) {
		if(session.getAttribute("counter") == null) 
			session.setAttribute("counter", 0);
		
		
		int counter = (int) session.getAttribute("counter");
		
		model.addAttribute("counter", counter);
		
		counter++;
		
		session.setAttribute("counter", counter);
		
		return "counter.jsp";
	}
	
	@GetMapping("/counterby2")
	public String counter2(Model model, HttpSession session) {
		if(session.getAttribute("counter") == null) 
			session.setAttribute("counter", 0);
		
		
		int counter = (int) session.getAttribute("counter");
		
		model.addAttribute("counter", counter);
		
		counter+=2;
		
		session.setAttribute("counter", counter);
		
		return "counter.jsp";
	}
}
