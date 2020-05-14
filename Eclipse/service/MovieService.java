package com.example.simplerestapis.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.simplerestapis.dao.MovieDao;
import com.example.simplerestapis.models.Movie;

@Service
public class MovieService {
	
	private final MovieDao movieDao;
	
	@Autowired
	public MovieService(@Qualifier("fakeDao") MovieDao movieDao) {
		this.movieDao = movieDao;
	}
	
	public int addMovie(Movie movie) {
		return movieDao.insertMovie(movie);
	}
	
	public List<Movie> getAllMovie() {
		return movieDao.selectAllMovie();
	}
	
	public Optional<Movie> getMovieById(UUID id){
		return movieDao.selectMovieById(id);
	}
}
