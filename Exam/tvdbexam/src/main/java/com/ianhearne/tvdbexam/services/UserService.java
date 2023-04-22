package com.ianhearne.tvdbexam.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.ianhearne.tvdbexam.models.LoginUser;
import com.ianhearne.tvdbexam.models.User;
import com.ianhearne.tvdbexam.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepo;
	
	public User register(User newUser, BindingResult result) {
		////REGISTRATION VALIDATION////
		boolean isValid = true;
		Optional<User> checkUser = userRepo.findByEmail(newUser.getEmail());
		if(checkUser.isPresent()) { //Check if email is already in use
			result.rejectValue("email", "emailInUse", "That email is already in use");
			isValid = false;
		}
		if(!newUser.getUserName().matches("[a-zA-Z]+")) { //Username must be letters only
			result.rejectValue("userName", "usernameError", "Username must only have letters");
			isValid = false;
		}
		if(!newUser.getPassword().equals(newUser.getConfirm())) {
			result.rejectValue("confirm", "passwordsMatch", "Passwords must match!");
			isValid = false;
		}
		if(isValid) {
			String pwHash = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
			newUser.setPassword(pwHash);
			return userRepo.save(newUser);
		} else {
			return null;
		}
	}

	public User login(LoginUser newLoginObject, BindingResult result) {
		Optional<User> checkUser = userRepo.findByEmail(newLoginObject.getEmail());
		if(!checkUser.isPresent()) {
			result.rejectValue("email", "", "Invalid Login");
			return null;
		}
		User user = checkUser.get();
		if(!BCrypt.checkpw(newLoginObject.getPassword(), user.getPassword())) {
			result.rejectValue("email", "", "Invalid Login");
			return null;
		}
		return user;
	}
	
	public User findById(Long id) {
		Optional<User> optionalUser = userRepo.findById(id);
		if(optionalUser.isPresent()) {
			return optionalUser.get();
		}
		return null;
	}
}
