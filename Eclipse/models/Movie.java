package com.example.simplerestapis.models;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Movie {
	private final UUID id;
	private final String title;

	public Movie(@JsonProperty("id") UUID id, @JsonProperty("title")String title) {
		this.id = id;
		this.title = title;
	}
	
	public UUID getId() {
		return id;
	}
	
	public String getTitle() {
		return title;
	}

}
