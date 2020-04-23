package com.umitcelebi.service;

import java.util.List;

import com.umitcelebi.model.Movie;

public interface MovieService {
	List<Movie> allMovie();
	List<Movie> movieByName(String name);
	List<Movie> movieByActor(String actor);
	List<Movie> movieByGenre(String genre);
	List<Movie> orderByYear();
	Movie movieById(int id);
	
	Movie updateMovie(Movie movie);
	boolean addMovie(Movie movie);
	boolean deleteMovie(int id);
}
