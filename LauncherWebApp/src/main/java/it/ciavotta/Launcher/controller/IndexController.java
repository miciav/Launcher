package it.ciavotta.Launcher.controller;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {

	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String login(Locale locale, Model model) {

		return "index";
	}	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String red(Locale locale, Model model) {

		return "index";
	}	
}
