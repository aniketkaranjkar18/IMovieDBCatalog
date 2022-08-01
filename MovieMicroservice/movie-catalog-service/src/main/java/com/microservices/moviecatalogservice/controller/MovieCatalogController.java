package com.microservices.moviecatalogservice.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.microservices.moviecatalogservice.model.CataLogList;
import com.microservices.moviecatalogservice.model.CatalogItem;
import com.microservices.moviecatalogservice.model.Movie;
import com.microservices.moviecatalogservice.model.Rating;
import com.microservices.moviecatalogservice.model.UserFav;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogController {

	@Autowired
	RestTemplate restTemplate;

	@GetMapping("/{userId}")
	public CataLogList getCatalog(@PathVariable("userId") String userId) {
		UserFav userfav = restTemplate.getForObject("http://MOVIE-INFO-SERVICE/movies/"+userId,UserFav.class);
		
		List<CatalogItem> list = new ArrayList<>();
		CataLogList catalogList = new CataLogList();
		for(Movie movie:userfav.getUserRatedMovies()) {
			Rating rating = restTemplate.getForObject("http://MOVIE-RATING-SERVICE/ratingdata/"+movie.getMovieId(),Rating.class);
			CatalogItem catalog = new CatalogItem(movie.getName(), movie.getDesc(), rating.getRating());
			list.add(catalog);
		}				
		catalogList.setCatalogList(list);
		return catalogList ;
	}
}
