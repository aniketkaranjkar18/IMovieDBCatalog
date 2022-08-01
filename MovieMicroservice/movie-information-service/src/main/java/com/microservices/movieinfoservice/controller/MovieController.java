package com.microservices.movieinfoservice.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.movieinfoservice.model.Movie;
import com.microservices.movieinfoservice.model.UserFav;

@RestController
@RequestMapping("/movies")
public class MovieController {

	

	@GetMapping("/{userId}")
	public UserFav getMovieInfoForUser(@PathVariable("userId") String userId) {
		List<Movie> userFavouriteMovies = new ArrayList<>();
		userFavouriteMovies.add(new Movie("foo","foobaifoo","Comedy Movie"));
		userFavouriteMovies.add(new Movie("ka","kaksparsha","Emotional Movie"));
		UserFav userFav = new UserFav();
		userFav.setUserRatedMovies(userFavouriteMovies);
		return userFav;
		
	}
}
