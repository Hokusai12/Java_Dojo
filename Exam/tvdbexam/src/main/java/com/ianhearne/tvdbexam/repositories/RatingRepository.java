package com.ianhearne.tvdbexam.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ianhearne.tvdbexam.models.Rating;

@Repository
public interface RatingRepository extends CrudRepository<Rating, Long>{
	public List<Rating> findAll();
}
