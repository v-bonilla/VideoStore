package videostore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import videostore.service.MovieService;

/**
 * Created by victor on 17/06/17.
 */
@RestController
@RequestMapping(value = "/movie")
public class MovieController {

    @Autowired
    private MovieService movieService;


    @RequestMapping(value = "/{movieId}",method=RequestMethod.GET)
    public ModelAndView movieDetail( @PathVariable(value="movieId") Integer movieId){

        return new ModelAndView("movieDetail","movieModel",movieService.detail(movieId));
    }

    @RequestMapping(value = "/search",method=RequestMethod.GET)
    public ModelAndView searchMovie(@RequestParam(required=true,value="movieTitle") String movieTitle){

        return new ModelAndView("movieDetail","movieModel",movieService.search(movieTitle));
    }

    @RequestMapping(value = "/watch/{movieId}",method=RequestMethod.GET)
    public ModelAndView watchMovie(@PathVariable(value="movieId") Integer movieId){

        return new ModelAndView("movieDetail","movieModel",movieService.watch(movieId));
    }


}