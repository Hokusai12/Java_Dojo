package com.ianhearne.savetravels.controllers;

import java.util.List;

import javax.validation.Valid;

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

import com.ianhearne.savetravels.models.Expense;
import com.ianhearne.savetravels.services.ExpenseService;

@Controller
@RequestMapping("/expenses")
public class ExpenseController {
	
	ExpenseService service;
	
	public ExpenseController(ExpenseService expenseService) {
		service = expenseService;
	}
	
	@GetMapping("/")
	public String index(Model model, @ModelAttribute("expense") Expense expense) {
		List<Expense> expenseList = service.getAll();
		model.addAttribute("expenses", expenseList);
		return "index.jsp";
	}
	
	@PostMapping("/")
	public String addExpense(Model model, @Valid @ModelAttribute("expense") Expense expense, BindingResult result) {
		if(result.hasErrors()) {
			List<Expense> expenseList = service.getAll();
			model.addAttribute("expenses", expenseList);
			return "/index.jsp";
		} else {
			service.addExpense(expense);
			return "redirect:/expenses/";
		}
	}
	
	@GetMapping("/edit/{id}")
	public String editExpense(Model model, @PathVariable(name="id") Long id) {
		Expense expense = service.findExpense(id);
		model.addAttribute("expense", expense);
		return "edit.jsp";
	}
	
	@PutMapping("/update/{id}")
	public String updateExpense(@Valid @ModelAttribute("expense") Expense expense, BindingResult result, @PathVariable(name="id") Long id) {
		if(result.hasErrors()) {
			return "/edit.jsp";
		} else {
			service.updateExpense(expense);
			return "redirect:/expenses/";
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteExpense(@PathVariable(name="id") Long id) {
		service.deleteExpense(id);
		return "redirect:/expenses/";
	}
	
	@GetMapping("/{id}")
	public String viewExpense(Model model, @PathVariable(name="id") Long id) {
		Expense expense = service.findExpense(id);
		model.addAttribute("expense", expense);
		return "view.jsp";
	}
}
