package com.ianhearne.hoppersreceipt.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ReceiptController {
	@RequestMapping("/")
	public String index(Model model) {
		String name = "Ian Hearne";
		String itemName = "Pipe Tobacco";
		double price = 12.75;
		String description ="Some of the tobaccy every produced.";
		String vendor = "B&M Store";
		
		model.addAttribute("name", name);
		model.addAttribute("itemName", itemName);
		model.addAttribute("price", price);
		model.addAttribute("description", description);
		model.addAttribute("vendor", vendor);
		
		
		return "index.jsp";
	}
}
