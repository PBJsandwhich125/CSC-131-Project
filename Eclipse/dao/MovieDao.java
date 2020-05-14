package com.example.simplerestapis.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.simplerestapis.models.Movie;

public interface MovieDao {
	
	int insertMovie(UUID id, Movie movie);
	
	default int insertMovie(Movie movie) {
		UUID id = UUID.randomUUID();
		return insertMovie(id, movie);
	}
	
	List<Movie> selectAllMovie();
	
	/*
	int deleteMovieById(UUID id);
	
	int updateMovieById(UUID id, Movie movie);
	*/

	Optional<Movie> selectMovieById(UUID id);
	
}
