package com.umitcelebi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.umitcelebi.model.Role;
import com.umitcelebi.service.RoleService;

@Controller
public class RoleController {


	@Autowired
	private RoleService roleService;
	
	@RequestMapping(value = "addrole",method = RequestMethod.POST)
	public ModelAndView addRole(@ModelAttribute Role role) {
		
		roleService.addRole(role);
		
		return new ModelAndView("redirect:actors");
	}
	
	@RequestMapping(value = "deleterolebymovie",method = RequestMethod.GET)
	public ModelAndView deleteRole(@RequestParam int movieId,@RequestParam int actorId,@ModelAttribute Role role) {
		
		roleService.deleteRole(movieId, actorId);
		
		return new ModelAndView("redirect:allmovies");
	}
	
	@RequestMapping(value = "searchbymovie",method = RequestMethod.GET)
	public ModelAndView searchByMovie(@RequestParam int id,@ModelAttribute Role role) {
		
		List<Role> roles=roleService.searchByMovie(id);
		
		return new ModelAndView("details","roles",roles);
	}
	
}
