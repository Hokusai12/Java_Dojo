package com.ianhearne.daikichi.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/daikichi")
public class DaikichiController {
	
	@RequestMapping("/")
	public String welcome() {
		return "Welcome!";
	}
	
	@RequestMapping("/today")
	public String todayFortune() {
		return "Today you will find luck in all of your endeavors!";
	}
	
	@RequestMapping("/tomorrow")
	public String tomorrowFortune() {
		return "Tomorrow, an opportunity will arise, so be sure to be open to new ideas!";
	}
	
	@RequestMapping("/travel/{location}")
	public String travelFortune(@PathVariable("location") String location) {
		return "You will have safe travels to " + location;
	}
	
	@RequestMapping("/lotto/{number}")
	public String lottoFortune(@PathVariable("number") Integer number) {
		if(number % 2 == 0)
			return "You will take a grand journey in the near future, but be wary of tempting offers.";
		else
			return "You have enjoyed the fruits of your labor but now is a great time to spend time with family and friends.";
	}
}
