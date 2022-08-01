package com.microservices.moviecatalogservice.model;

import java.util.List;

public class UserFav {
	List<Movie> userRatedMovies;

	public UserFav(List<Movie> userRatedMovies) {
		super();
		this.userRatedMovies = userRatedMovies;
	}
	public UserFav() {
	
	}

	public List<Movie> getUserRatedMovies() {
		return userRatedMovies;
	}

	public void setUserRatedMovies(List<Movie> userRatedMovies) {
		this.userRatedMovies = userRatedMovies;
	}
}
