package videostore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import videostore.model.Movie;
import videostore.service.MovieService;

/**
 * Created by victor on 17/06/17.
 */
@RestController
@RequestMapping(value = "/movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    // Get page with all the info of the movie required
    @RequestMapping(value = "/{movieId}", method = RequestMethod.GET)
    public ModelAndView movieDetail(@PathVariable(value="movieId") String movieId){
        // Check if user is already logged in
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = null;
        boolean isAdmin = false;
        if (!auth.getName().equals("anonymousUser")){
            username = auth.getName();
            SimpleGrantedAuthority roleAdmin = new SimpleGrantedAuthority("ROLE_ADMIN");
            if (auth.getAuthorities().contains(roleAdmin)){
                isAdmin = true;
            }
        }
        // Search movie required
        Movie movie = movieService.detailById(Integer.valueOf(movieId));
        return new ModelAndView("movieDetail").addObject("usuername", username).addObject("isAdmin", isAdmin).addObject("movie", movie);
    }

    // Search a movie using the nav bar
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public ModelAndView searchMovie(@RequestParam(required=true,value="movieTitle") String movieTitle){
        Movie movie = movieService.detailByTitle(movieTitle);
        // Redirect to the page with all the info of the movie required
        return movieDetail(String.valueOf(movie.getMovieId()));
    }

    // Get the page with the content of the movie required
    @RequestMapping(value = "/watch/{movieId}", method = RequestMethod.GET)
    public ModelAndView watchMovie(@PathVariable(value="movieId") String movieId){
        // Check if user is already logged in
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = null;
        boolean isAdmin = false;
        if (!auth.getName().equals("anonymousUser")){
            username = auth.getName();
            SimpleGrantedAuthority roleAdmin = new SimpleGrantedAuthority("ROLE_ADMIN");
            if (auth.getAuthorities().contains(roleAdmin)){
                isAdmin = true;
            }
        }
        // Search movie required
        Movie movie = movieService.detailById(Integer.valueOf(movieId));
        return new ModelAndView("watchMovie").addObject("usuername", username).addObject("isAdmin", isAdmin).addObject("movie", movie);
    }


}