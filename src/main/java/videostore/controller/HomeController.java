package com.daw.videoclub;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/Home")
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/userRegister", method = RequestMethod.GET)
	public String Register(Locale locale, Model model) {
		String s = "s";
		model.addAttribute("s", s);
		
		return "register";
	}
	
	@RequestMapping(value = "/newUser", method = RequestMethod.GET)
	public String NewUser(Locale locale, Model model) {
		return "newUser";
	}
	
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public String Users(Locale locale, Model model) {
		return "users";
	}
}
