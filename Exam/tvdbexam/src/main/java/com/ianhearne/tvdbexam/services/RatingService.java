package com.ianhearne.tvdbexam.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ianhearne.tvdbexam.models.Rating;
import com.ianhearne.tvdbexam.repositories.RatingRepository;

@Service
public class RatingService {
	@Autowired
	RatingRepository ratingRepo;
	
	public Rating save(Rating rating) {
		return ratingRepo.save(rating);
	}
}
