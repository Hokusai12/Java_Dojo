package com.ianhearne.daikichi.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/omikuji")
public class OmikujiController {

	@GetMapping("/")
	public String displayForm() {
		return "omikuji-form.jsp";
	}
	
	@PostMapping("/process-form")
	public String processForm(
			@RequestParam("num") Integer number,
			@RequestParam("city") String city,
			@RequestParam("person") String person,
			@RequestParam("hobby") String hobby,
			@RequestParam("living-thing") String livingThing,
			@RequestParam("note") String note,
			HttpSession session) {
		session.setAttribute("number", number);
		session.setAttribute("city", city);
		session.setAttribute("person", person);
		session.setAttribute("hobby", hobby);
		session.setAttribute("livingThing", livingThing);
		session.setAttribute("note", note);
		
		return "redirect:/omikuji/show";
	}
	
	@GetMapping("/show")
	public String showFortune(Model model, HttpSession session) {
		if(session.getAttribute("number") == null)
			session.setAttribute("number", 0);
		if(session.getAttribute("city") == null)
			session.setAttribute("city", "");
		if(session.getAttribute("person") == null)
			session.setAttribute("person", "");
		if(session.getAttribute("hobby") == null)
			session.setAttribute("hobby", "");
		if(session.getAttribute("livingThing") == null)
			session.setAttribute("livingThing", "");
		if(session.getAttribute("note") == null)
			session.setAttribute("note", "");
		model.addAttribute("number", (Integer) session.getAttribute("number"));
		model.addAttribute("city", (String) session.getAttribute("city"));
		model.addAttribute("person", (String) session.getAttribute("person"));
		model.addAttribute("hobby", (String) session.getAttribute("hobby"));
		model.addAttribute("livingThing", (String) session.getAttribute("livingThing"));
		model.addAttribute("note", (String) session.getAttribute("note"));
		
		return "fortune.jsp";
	}
}
