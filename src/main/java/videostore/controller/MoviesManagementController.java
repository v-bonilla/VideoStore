package com.daw.videoclub;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/MoviesManagement")
public class MoviesManagementController {

	private static final Logger logger = LoggerFactory.getLogger(MoviesManagementController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/MoviesManagement", method = RequestMethod.GET)
	public String users(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		return "moviesManagement";
	}

}
