package com.ianhearne.dojos_and_ninjas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ianhearne.dojos_and_ninjas.models.Ninja;
import com.ianhearne.dojos_and_ninjas.repositories.NinjaRepository;

@Service
public class NinjaService {
	@Autowired
	private NinjaRepository ninjaRepo;
	
	public Ninja create(Ninja ninja) {
		return ninjaRepo.save(ninja);
	}
	
}
