package com.example.simplerestapis.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.simplerestapis.models.Movie;
import com.example.simplerestapis.models.PostRequest;
import com.example.simplerestapis.models.PostResponse;

import com.example.simplerestapis.models.SampleResponse;
import com.example.simplerestapis.service.MovieService;

@RestController
public class WebController {

	private final MovieService movieService;
	
	@Autowired
	public WebController(MovieService movieService) {
		this.movieService = movieService;
	}
	
	@RequestMapping(value = "/movie", method = RequestMethod.POST)
	public void addMovie(@RequestBody Movie movie) {
		movieService.addMovie(movie);
	}
	
	@RequestMapping(value = "/movies")
	public List<Movie> getAllMovie(){
		return movieService.getAllMovie();
	}
	
	@RequestMapping(value = "/movies/{id}")
	public Movie getMovieById(@PathVariable("id") UUID id) {
		return movieService.getMovieById(id)
				.orElse(null); 
	}
	
	@RequestMapping("/sample")
	public SampleResponse Sample(@RequestParam(value = "name",
	defaultValue = "Robot") String name) {
		SampleResponse response = new SampleResponse();
		response.setId(1);
		response.setMessage("Your name is "+name);
		return response;

	}
	
	@RequestMapping(value = "/test", method = RequestMethod.POST)
	public PostResponse Test(@RequestBody PostRequest inputPayload) {
		PostResponse response = new PostResponse();
		response.setId(inputPayload.getId()*100);
		response.setMessage("Hello " + inputPayload.getName());
		response.setExtra("Some text");
		return response;
	}
}

