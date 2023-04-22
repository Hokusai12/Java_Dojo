package com.ianhearne.tvdbexam.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


/*
	I don't know if this is the correct way of implementing this
	Not sure if it is meant to just be a normal n:m relationship,
	but I couldn't think of how to implement a basic n:m that holds data like the rating score
 */
@Entity
@Table(name="ratings")
public class Rating {
	
	////	ATTRIBUTES    ////
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message="User must not be null")
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User user;
	
	@Min(value=1, message="Rating can't be less than 1")
	@Max(value=5, message="Rating can't be more than 5")
	private Double rating;
	
	@NotNull
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="show_id")
	private Show show;
	
	////	CONSTRUCTORS    ////
	
	public Rating() {}
	
	////	GETTERS AND SETTERS    ////

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public Show getShow() {
		return show;
	}

	public void setShow(Show show) {
		this.show = show;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
