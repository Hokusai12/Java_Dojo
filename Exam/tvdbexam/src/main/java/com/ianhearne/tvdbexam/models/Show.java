package com.ianhearne.tvdbexam.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="shows")
public class Show {
	
	////	ATTRIBUTES	  ////
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message="Title required")
	private String title;
	
	@NotEmpty(message="Description Required")
	private String description;
	
	@NotEmpty(message="Network required")
	private String network;
	
	@Transient
	@Min(0)
	@Max(5)
	private Double avgRating;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="poster_id")
	private User poster;
	
	@OneToMany(mappedBy="show", fetch=FetchType.LAZY)
	private List<Rating> ratings;
	
	////	CONSTRUCTORS    ////
	
	public Show() {}
	
	////	GETTERS AND SETTERS    ////

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNetwork() {
		return network;
	}

	public void setNetwork(String network) {
		this.network = network;
	}

	public User getPoster() {
		return poster;
	}

	public void setPoster(User poster) {
		this.poster = poster;
	}

	public Double getAvgRating() {
		double sum = 0.0;
		for(Rating rating: ratings) {
			sum += rating.getRating();
		}
		return sum / ratings.size();
	}

	public void setAvgRating(Double avgRating) {
		this.avgRating = avgRating;
	}

	public List<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}

}
