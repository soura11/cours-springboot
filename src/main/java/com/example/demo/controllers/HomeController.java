package com.example.demo.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.services.IPersonService;

@Controller
@RequestMapping("/home")
public class HomeController {

	@Autowired
	private IPersonService personService;

	// http://localhost:8080/home
	@GetMapping(value = "/index")
	public String goHome() {
		return "home";
	}

	@GetMapping(value = "/showAll")
	public ModelAndView showAll() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");
		mv.addObject("persons", personService.findAll());
		return mv;
	}

	// http://localhost:8080/home/showSome?firstName=..
	@GetMapping(value = "/showSome")
	public ModelAndView showSome(
			@RequestParam(value = "firstName", required = false, defaultValue = "manso") String firstName) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");
		mv.addObject("persons", personService.findByFirstName(firstName));
		return mv;
	}

	// http://localhost:8080/home/showAny
	// http://localhost:8080/home/showAny/...
	@GetMapping(value = { "/showAny/{firstName}", "/showAny" })
	public ModelAndView showSome(@PathVariable Optional<String> firstName, ModelAndView modelAndView) {
		if (firstName.isPresent()) {
			modelAndView.addObject("firstName", firstName.get());
		} else {
			modelAndView.addObject("firstName", "sou");
		}
		modelAndView.setViewName("home");

		return modelAndView;
	}

	// http://localhost:8080/home/showAny2
	// http://localhost:8080/home/showAny2/...
	@GetMapping(value = { "/showAny2/{nom}", "/showAny2" })
	public String showAny2(@PathVariable(value = "firstName", required = false) String firstName,
			ModelAndView modelAndView) {
		modelAndView.addObject("firstName", firstName);
		return "home";
	}

}
