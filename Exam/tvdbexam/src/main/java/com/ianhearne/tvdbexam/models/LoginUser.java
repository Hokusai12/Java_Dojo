package com.ianhearne.tvdbexam.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class LoginUser {
	@NotEmpty(message="Invalid Login")
	@Email(message="Invalid Login")
	private String email;
	
	@NotEmpty(message="Invalid Login")
	@Size(message="Invalid Login")
	private String password;
	
	public LoginUser() {}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
