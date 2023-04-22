package com.ianhearne.tvdbexam.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ianhearne.tvdbexam.models.Show;

@Repository
public interface ShowRepository extends CrudRepository<Show, Long>{
	public List<Show> findAll();
	
	public Show findByTitleEquals(String title);
}
