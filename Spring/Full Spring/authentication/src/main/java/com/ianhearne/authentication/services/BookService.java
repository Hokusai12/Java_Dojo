package com.ianhearne.authentication.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ianhearne.authentication.models.Book;
import com.ianhearne.authentication.models.User;
import com.ianhearne.authentication.repositories.BookRepository;

@Service
public class BookService {
	@Autowired
	BookRepository bookRepo;
	
	public List<Book> getAll() {
		return bookRepo.findAll();
	}
	
	public Book findById(Long id) {
		Optional<Book> optionalBook = bookRepo.findById(id);
		if(optionalBook.isPresent()) {
			return optionalBook.get();
		} else {
			return null;
		}
	}
	
	public Book addBook(Book newBook) {
		
		return bookRepo.save(newBook);
	}
	
	public Book updateBook(Book book) {
		return bookRepo.save(book);
	}
	
	public void delete(Long id) {
		bookRepo.deleteById(id);
	}
	
	public List<Book> getAllUnborrowed() {
		return bookRepo.findByBorrowerIsNull();
	}
	
	
}
