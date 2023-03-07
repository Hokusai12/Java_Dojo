package com.ianhearne.savetravels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ianhearne.savetravels.models.Expense;
import com.ianhearne.savetravels.repositories.ExpenseRepository;

@Service
public class ExpenseService {
	ExpenseRepository expenseRepo;
	
	//Constructor with dependency injection for the repository
	public ExpenseService(ExpenseRepository expenseRepository) {
		expenseRepo = expenseRepository;
	}
	
	public List<Expense> getAll() {
		return expenseRepo.findAll();
	}
	
	public Expense addExpense(Expense expense) {
		return expenseRepo.save(expense);
	}
	
	public Expense findExpense(Long id) {
		Optional<Expense> optionalExpense = expenseRepo.findById(id);
		if(optionalExpense.isPresent()) {
			return optionalExpense.get();
		} else {
			return null;
		}
	}
	
	public Expense updateExpense(Expense expense) {
		return expenseRepo.save(expense);
	}
	
	public void deleteExpense(Long id) {
		expenseRepo.deleteById(id);
	}
}
