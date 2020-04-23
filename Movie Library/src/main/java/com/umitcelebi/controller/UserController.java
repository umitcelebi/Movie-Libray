package com.umitcelebi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.umitcelebi.model.User;
import com.umitcelebi.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "loginpage",method = RequestMethod.GET)
	public ModelAndView loginPage(@ModelAttribute User user) {
		
		return new ModelAndView("loginPage");
	}
	
	@RequestMapping(value = "registerpage",method = RequestMethod.GET)
	public ModelAndView registerPage(@ModelAttribute User user) {
		
		return new ModelAndView("registerPage");
	}
	
	@RequestMapping(value = "login",method = RequestMethod.POST)
	public ModelAndView login(@ModelAttribute User user) {
		
		User user2=userService.login(user.getUserName(), user.getPassword());
		if(!(user2==null)) {
			return new ModelAndView("redirect:allmovies");
		}
		return new ModelAndView("redirect:registerpage");
	}
	
	@RequestMapping(value = "register",method = RequestMethod.POST)
	public ModelAndView register(@ModelAttribute User user) {

		if(userService.register(user)) {
			return new ModelAndView("loginPage");
		}
		String mesaj="this username has already been used.";
		return new ModelAndView("registerPage","mesaj",mesaj);
	}
}
