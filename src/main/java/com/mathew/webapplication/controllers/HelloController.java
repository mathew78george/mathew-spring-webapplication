package com.mathew.webapplication.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public ModelAndView welcomePage() {
		System.out.println("111111111111");
		ModelAndView view = new ModelAndView();
		view.addObject("title", "Spring Security Hello World");
		view.addObject("message", "This is welcome page!");
		view.setViewName("hello");
		System.out.println("2222222222222");
		return view;

	}

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public ModelAndView getAdminPage() {
		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Hello World");
		model.addObject("message", "This is protected page!");
		model.setViewName("admin");
		return model;
	}

}
