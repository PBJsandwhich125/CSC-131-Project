package com.example.simplerestapis.dao;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.example.simplerestapis.models.Movie;

@Repository("fakeDao")
public class FakeMovieDataAccessService implements MovieDao{
	
	private static List<Movie> DB = new ArrayList<>();
	
	@Override
	public int insertMovie(UUID id, Movie movie) {
		DB.add(new Movie(id, movie.getTitle()));
		return 1;
	}
	
	@Override
	public List<Movie> selectAllMovie(){
		return DB;
	}
	
	@Override 
	public Optional<Movie> selectMovieById(UUID id){
		return DB.stream()
				.filter(movie -> movie.getTitle().equals(id))
				.findFirst(); 
	}
	
	/*
	@Override
	public int deleteMovieByID(UUID id) {
		return 0;
	}
	
	@Override
	public int updateMovieById(UUID id, Movie movie) {
		return 0;
	}
	*/
}
