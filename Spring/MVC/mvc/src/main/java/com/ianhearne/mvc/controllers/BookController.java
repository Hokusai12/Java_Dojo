package com.ianhearne.mvc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ianhearne.mvc.models.Book;
import com.ianhearne.mvc.services.BookService;

@Controller
public class BookController {
	@Autowired
	BookService bookService;
	
	@GetMapping("/books/{id}")
	public String show(Model model, @PathVariable(value="id") Long id) {
		Book book = bookService.findBook(id);
		
		model.addAttribute("book", book);
		
		return "show.jsp";
	}
	
	@GetMapping("/books")
	public String index(Model model) {
		List<Book> bookList = bookService.allBooks();
		
		model.addAttribute("books", bookList);
		
		return "index.jsp";
	}
}
