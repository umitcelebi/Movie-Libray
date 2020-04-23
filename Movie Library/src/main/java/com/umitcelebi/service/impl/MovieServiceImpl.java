package com.umitcelebi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.umitcelebi.dao.MovieDao;
import com.umitcelebi.model.Movie;
import com.umitcelebi.service.MovieService;

@Service
@Transactional
public class MovieServiceImpl implements MovieService{
	
	@Autowired
	private MovieDao movieDao;

	@Override
	public List<Movie> allMovie() {
		
		return movieDao.allMovie();
	}

	@Override
	public List<Movie> movieByName(String name) {
		
		return movieDao.movieByName(name);
	}

	@Override
	public List<Movie> movieByActor(String actor) {
		
		return movieDao.movieByActor(actor);
	}

	@Override
	public List<Movie> movieByGenre(String genre) {
		
		return movieDao.movieByGenre(genre);
	}

	@Override
	public List<Movie> orderByYear() {
		
		return movieDao.orderByYear();
	}

	@Override
	public Movie movieById(int id) {
		
		return movieDao.movieById(id);
	}

	@Override
	public Movie updateMovie(Movie movie) {
		
		return movieDao.updateMovie(movie);
	}

	@Override
	public boolean addMovie(Movie movie) {
		
		return movieDao.addMovie(movie);
	}

	@Override
	public boolean deleteMovie(int id) {
		
		return movieDao.deleteMovie(id);
	}

}
