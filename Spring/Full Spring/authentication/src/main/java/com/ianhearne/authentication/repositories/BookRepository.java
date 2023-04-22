package com.ianhearne.authentication.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ianhearne.authentication.models.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long>{
	public List<Book> findAll();
	
	public List<Book> findByBorrowerIsNull();
}
