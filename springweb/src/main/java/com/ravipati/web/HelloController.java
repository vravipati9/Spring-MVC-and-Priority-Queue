package com.ravipati.web;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {

		model.addAttribute("message", "Spring 3 MVC Hello World");
		return "hello";
	}

	@RequestMapping(value = "/hello/{name:.+}", method = RequestMethod.GET)
	public ModelAndView hello(@PathVariable("name") String name) {

		ModelAndView model = new ModelAndView();
		model.setViewName("hello");
		model.addObject("msg", name);

		return model;
	}

	@RequestMapping("/welcome/{countryName}/{userName}")
	//public ModelAndView helloWorld(@PathVariable("countryName") String countryName, @PathVariable("userName") String name) {
	public ModelAndView helloWorld(@PathVariable Map<String, String> pathVars) {
		ModelAndView model = new ModelAndView("HelloPage");
		model.addObject("msg", "Welcome to Spring MVC Introduction by.. "+pathVars.get("userName") + " from "+pathVars.get("countryName"));
		return model;
	}
}