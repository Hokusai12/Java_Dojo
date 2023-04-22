package com.ianhearne.authentication.controllers;

import java.util.ArrayList;
import java.util.List;

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

import com.ianhearne.authentication.models.Book;
import com.ianhearne.authentication.models.User;
import com.ianhearne.authentication.services.BookService;
import com.ianhearne.authentication.services.UserService;

@Controller
@RequestMapping("/books")
public class BookController {
	@Autowired
	BookService bookService;
	@Autowired
	UserService userService;

	////	GET MAPPINGS	////
	
	@GetMapping("")
	public String welcome(Model model, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		Long userId = (Long) session.getAttribute("userId");
		User user = userService.findById(userId);
		
		List<Book> allBooksUnborrowed = bookService.getAllUnborrowed();
		List<Book> booksBorrowedByUser = user.getBooksBorrowed();
		
		allBooksUnborrowed.addAll(userService.getBooksBorrowedFromUser(user));
		
		model.addAttribute("user", user);
		model.addAttribute("unborrowedBooks", allBooksUnborrowed);
		model.addAttribute("borrowedBooks", booksBorrowedByUser);
		return "homepage.jsp";
	}
	
	@GetMapping("/new")
	public String addBook(@ModelAttribute("newBook") Book newBook, Model model, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		Long userId = (Long) session.getAttribute("userId");
		model.addAttribute("userId", userId);
		return "new-book.jsp";
	}
	
	@GetMapping("/{bookId}")
	public String showBook(@PathVariable(name="bookId") Long bookId, Model model, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		Long userId = (Long) session.getAttribute("userId");
		Book book = bookService.findById(bookId);
		
		model.addAttribute("userId", userId);
		model.addAttribute("book", book);
		return "show-book.jsp";
	}
	
	@GetMapping("/{bookId}/edit")
	public String editBook(@PathVariable Long bookId, Model model, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		Long userId = (Long) session.getAttribute("userId");
		Book book = bookService.findById(bookId);
		if(!session.getAttribute("userId").equals(book.getPoster().getId())) { 
			return "redirect:/books/" + book.getId().toString();
		}
		model.addAttribute("userId", userId);
		model.addAttribute("book", book);
		return "edit-book.jsp";
	}
	
	@GetMapping("/{bookId}/borrow")
	public String borrowBook(@PathVariable Long bookId, HttpSession session) {		
		
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		
		Book book = bookService.findById(bookId);
		
		if(book.getBorrower() == null) {
			//Sets the user associated with the ID in session to the borrower attribute of the Book
			book.setBorrower(userService.findById((Long) session.getAttribute("userId")));
			bookService.updateBook(book);
		}

		return "redirect:/books";
	}
	
	@GetMapping("/{bookId}/return")
	public String returnBook(@PathVariable Long bookId, HttpSession session) {
		
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		
		Book book = bookService.findById(bookId);
		Long userId = (Long) session.getAttribute("userId");
		
		if(book.getBorrower().getId().equals(userId)) {
			book.setBorrower(null);
			bookService.updateBook(book);
		}
		
		return "redirect:/books";
	}
	
	////	PUT MAPPINGS	////
	
	@PutMapping("/{id}/update")
	public String updateBook(@PathVariable("id") Long bookId, @Valid @ModelAttribute("book") Book book, BindingResult result, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		if(result.hasErrors()) {
			return "/edit-book.jsp";
		}
		bookService.updateBook(book);
		return "redirect:/books";
		
	}
	
	////	POST MAPPINGS    ////
	
	@PostMapping("/add-book")
	public String saveBook(@Valid @ModelAttribute("newBook") Book newBook, BindingResult result, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		if(result.hasErrors()) {
			return "/new-book.jsp";
		}
		bookService.addBook(newBook);
		return "redirect:/books";
	}
	
	//// DELETE MAPPINGS ////
	@DeleteMapping("{id}/delete")
	public String deleteBook(@PathVariable Long id) {
		bookService.delete(id);
		return "redirect:/books";
	}
}
