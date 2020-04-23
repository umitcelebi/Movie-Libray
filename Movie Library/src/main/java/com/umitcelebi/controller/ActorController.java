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
import com.umitcelebi.model.Role;
import com.umitcelebi.service.ActorService;
import com.umitcelebi.service.MovieService;
import com.umitcelebi.service.RoleService;

@Controller
public class ActorController {
	
	@Autowired
	private ActorService actorService;
	
	@Autowired
	private MovieService movieService;
	
	@Autowired
	private RoleService roleService;
	
	@RequestMapping(value = "actors",method = RequestMethod.GET)
	public ModelAndView addActorPage(@ModelAttribute Actor actor,@ModelAttribute Movie movie,Role value) {
		ModelAndView modelAndView=new ModelAndView("addActorPage");
		List<Actor> actors=actorService.allActors();
		List<Movie> movies =movieService.allMovie();
		
		modelAndView.addObject("actors", actors);
		modelAndView.addObject("movies", movies);
		return modelAndView;
	}
	
	@RequestMapping(value = "actorsbyname",method = RequestMethod.GET)
	public ModelAndView actorsByName(@RequestParam String name) {
		List<Actor> actor=actorService.actorsByName(name);
		
		return new ModelAndView("mainPage","actors",actor);
	}
	
	@RequestMapping(value = "actorsbyid",method = RequestMethod.GET)
	public ModelAndView actorById(@RequestParam int id) {
		
		Actor actor=actorService.actorById(id);
		
		return new ModelAndView("mainPage","actors",actor);
	}
	
	@RequestMapping(value = "addactor",method = RequestMethod.POST)
	public ModelAndView addActor(@ModelAttribute Actor actor) {
		
		if(actor.getId()==0) {
			actorService.addActor(actor);
		}else {
			actorService.updateActor(actor);
		}
		
		return new ModelAndView("redirect:actors");
	}
	
	@RequestMapping(value = "deleteactor",method = RequestMethod.GET)
	public ModelAndView deleteActor(@RequestParam int id) {
		
		actorService.deleteActor(id);
		roleService.deleteRActor(id);
		
		return new ModelAndView("redirect:actors");
	}
	
	@RequestMapping(value = "updateactor",method = RequestMethod.GET)
	public ModelAndView updateActor(@RequestParam int id,@ModelAttribute Actor actor2,@ModelAttribute Role role) {
		
		ModelAndView modelAndView=new ModelAndView("addActorPage");
		Actor actor=actorService.actorById(id);
		List<Actor> actors=actorService.allActors();
		List<Movie> movies=movieService.allMovie();
		
		modelAndView.addObject("upActor",actor);
		modelAndView.addObject("actors",actors);
		modelAndView.addObject("movies",movies);
		return modelAndView;
	}
	
	
}
