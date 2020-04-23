package com.umitcelebi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.umitcelebi.model.Actor;
import com.umitcelebi.model.Movie;
import com.umitcelebi.service.ActorService;
import com.umitcelebi.service.MovieService;
import com.umitcelebi.service.RoleService;

@Controller
public class MovieAddController {
	
	@Autowired
	private MovieService movieService;
	
	@Autowired
	private ActorService actorService;
	
	@Autowired
	private RoleService roleService;
	
	@RequestMapping(value = "moviepage",method = RequestMethod.GET)
	public ModelAndView moviePage(@ModelAttribute Movie movie) {
		
		return new ModelAndView("addMovie");
	}
	
	@RequestMapping(value = "addmoviepage",method = RequestMethod.GET)
	public ModelAndView addMoviePage(@ModelAttribute Movie movie,@ModelAttribute Actor actor) {
		ModelAndView modelAndView=new ModelAndView("addMoviePage");
		
		List<Actor> actors=actorService.allActors();
		modelAndView.addObject("actor", actors);
		
		return modelAndView;
	}
	
	@RequestMapping(value = "allmovies",method = RequestMethod.GET)
	public ModelAndView allMovie(@ModelAttribute Movie movie) {
		List<Movie> movies=movieService.allMovie();
		return new ModelAndView("mainPage","movies",movies);
	}
	
	@RequestMapping(value = "addmovie",method = RequestMethod.POST)
	public ModelAndView addMovie(@ModelAttribute Movie movie) {
		if(movie.getMovieId()==0) {
			movieService.addMovie(movie);
		}else {
			movieService.updateMovie(movie);
		}
		return new ModelAndView("redirect:allmovies");
	}
	
	@RequestMapping(value = "moviebyname",method = RequestMethod.GET)
	public ModelAndView movieByName(@RequestParam("movieName") String name,@ModelAttribute Movie movie) {
		List<Movie> movies=movieService.movieByName(name);
		return new ModelAndView("mainPage","movies",movies);
	}
	
	@RequestMapping(value = "moviebygenre",method = RequestMethod.GET)
	public ModelAndView movieByGenre(@RequestParam String genre,@ModelAttribute Movie movie) {
		List<Movie> movies=movieService.movieByGenre(genre);
		return new ModelAndView("mainPage","movies",movies);
	}
	
	@RequestMapping(value = "orderbyyear",method = RequestMethod.GET)
	public ModelAndView orderByYear(@ModelAttribute Movie movie) {
		List<Movie> movies=movieService.orderByYear();
		return new ModelAndView("mainPage","movies",movies);
	}
	
	@RequestMapping(value = "moviebyid",method = RequestMethod.GET)
	public ModelAndView movieById(@RequestParam int id) {
		Movie movie=movieService.movieById(id);
		return new ModelAndView("mainPage","movies",movie);
	}
	
	@RequestMapping(value = "deletemovie",method = RequestMethod.GET)
	public ModelAndView deleteMovie(@RequestParam int id) {
		
		movieService.deleteMovie(id);
		roleService.deleteRMovie(id);
		
		return new ModelAndView("redirect:allmovies");
	}
	
	@RequestMapping(value = "updatemovie",method = RequestMethod.GET)
	public ModelAndView updateMovie(@RequestParam int id,@ModelAttribute Movie movie) {
		
		Movie movie2=movieService.movieById(id);
		
		return new ModelAndView("addMoviePage","upMovie",movie2);
	}
}
