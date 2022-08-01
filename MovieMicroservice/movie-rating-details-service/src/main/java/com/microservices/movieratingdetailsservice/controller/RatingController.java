package com.microservices.movieratingdetailsservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.movieratingdetailsservice.model.Rating;

@RestController
@RequestMapping("/ratingdata")
public class RatingController {
	
	@GetMapping("/{movieId}")
	public Rating getRatingData(@PathVariable("movieId") String movieId) {
		Rating ratingDefault = new Rating("unknown",0);
		List<Rating> ratingList = new ArrayList<>();
		ratingList.add(new Rating("foo",4));
		ratingList.add(new Rating("ka",3));
		
		for(Rating rating:ratingList) {
			if(movieId==rating.getMovieId()) {
				return rating;
			}
		}
		
		return ratingDefault;

	}

}
