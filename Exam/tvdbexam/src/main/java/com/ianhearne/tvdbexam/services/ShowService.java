package com.ianhearne.tvdbexam.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.ianhearne.tvdbexam.models.Show;
import com.ianhearne.tvdbexam.repositories.ShowRepository;

@Service
public class ShowService {
	@Autowired
	ShowRepository showRepo;
	
	public Show add(Show newShow, BindingResult result) {
		//Validates that the show's title doesn't already exist in the database before saving it
		if(showRepo.findByTitleEquals(newShow.getTitle()) != null) {
			result.rejectValue("title", null, "Title is already in use");
			return null;
		}
		return showRepo.save(newShow);
	}
	
	public List<Show> getAll() {
		return showRepo.findAll();
	}
	
	public Show getById(Long id) {
		Optional<Show> show = showRepo.findById(id);
		if(show.isPresent()) {
			return show.get();
		}
		return null;
	}
	
	public Show updateShow(Show show, BindingResult result) {
		//Validates that the show's title doesn't already exist in the database before saving it, also checks to see that it isn't validating against itself
		if(showRepo.findByTitleEquals(show.getTitle()) != null 
				&& !show.getId().equals(showRepo.findByTitleEquals(show.getTitle()).getId())) {
			result.rejectValue("title", null, "Title is already in use");
			return null;
		}
		return showRepo.save(show);
	}
	
	public void deleteShow(Long id) {
		showRepo.deleteById(id);
	}
}
