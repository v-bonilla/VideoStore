package videostore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import videostore.model.Movie;
import videostore.model.User;
import videostore.service.MovieService;
import videostore.service.UserService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by victor on 17/06/17.
 */
@RestController
@RequestMapping(value = "/management")
public class ManagementController {

    @Autowired
    private UserService userService;

    @Autowired
    private MovieService movieService;

    // Get management main page
    @RequestMapping(value = "/")
    public ModelAndView management() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        return new ModelAndView("management").addObject("username", username);
    }

    // Get management users page
    @RequestMapping(value = "/user/")
    public ModelAndView getUsers() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();

        List<User> users = userService.getUsers();
        return new ModelAndView("managementUser").addObject("username", username).addObject("users", users);
    }

    // Add new user
    @RequestMapping(value = "/user/", method = RequestMethod.POST)
    public ModelAndView newUser(@RequestParam("userName") String userName,
                                @RequestParam("userPassword") String userPassword,
                                @RequestParam("userEmail") String userEmail,
                                @RequestParam("isAdmin") String isAdmin) {
        // Define roles of new user with the param
        List<GrantedAuthority> roles = new ArrayList<>();
        roles.add(new SimpleGrantedAuthority("ROLE_USER"));
        if ("Y".equals(isAdmin)) {
            roles.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        }
        // Create new user
        User user = new User(userName, new BCryptPasswordEncoder().encode(userPassword), userEmail, roles);
        userService.newUser(user);
        // Redirect to management users page
        return getUsers();
    }

    // Modify user
    @RequestMapping(value = "/user/", method = RequestMethod.PATCH)
    public ModelAndView modifyUser(@RequestParam("userId") String userId,
                                   @RequestParam("userName") String userName,
                                   @RequestParam("userPassword") String userPassword,
                                   @RequestParam("userEmail") String userEmail,
                                   @RequestParam("isAdmin") String isAdmin) {
        // Define roles of new user with the param
        List<GrantedAuthority> roles = new ArrayList<>();
        roles.add(new SimpleGrantedAuthority("ROLE_USER"));
        if ("Y".equals(isAdmin)) {
            roles.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        }
        // Modify user
        User user = new User(userName, userPassword, userEmail, roles);
        user.setUserId(Integer.valueOf(userId));
        userService.modifyUser(user);
        // Redirect to management users page
        return getUsers();
    }

    // Delete user
    @RequestMapping(value = "/user/", method = RequestMethod.DELETE)
    public ModelAndView deleteUser(@RequestParam("userId") String userId) {
        userService.deleteUser(Integer.valueOf(userId));
        // Redirect to management users page
        return getUsers();
    }

    // Get management movies page
    @RequestMapping(value = "/movie/")
    public ModelAndView getMovies() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();

        List<Movie> movies = movieService.getMovies();
        return new ModelAndView("managementMovie").addObject("username", username).addObject("movies", movies);
    }

    // Add new movie
    @RequestMapping(value = "/movie/", method = RequestMethod.POST)
    public ModelAndView newMovie(@RequestParam String movieTitle,
                                 @RequestParam String movieUrl,
                                 @RequestParam(required = false) String movieDesc,
                                 @RequestParam(required = false) String movieYear,
                                 @RequestParam(required = false) String movieDirector,
                                 @RequestParam(required = false) String movieActors,
                                 @RequestParam(required = false) String movieUrlFront,
                                 @RequestParam(required = false) String movieRating) {
        // Create new object movie
        Movie movie = new Movie();
        movie.setMovieTitle(movieTitle);
        movie.setMovieUrl(movieUrl);
        movie.setMovieDesc(movieDesc);
        if (movieYear.equals("")){
            movie.setMovieYear(-1);
        } else {
            movie.setMovieYear(Integer.valueOf(movieYear));
        }        movie.setMovieDirector(movieDirector);
        movie.setMovieActors(movieActors);
        movie.setMovieUrlFront(movieUrlFront);
        if (movieRating.equals("")){
            movie.setMovieRating(-1.0);
        } else {
            movie.setMovieRating(Double.parseDouble(movieRating));
        }
        // Create movie
        movieService.newMovie(movie);
        // Redirect to management movies page
        return getMovies();
    }

    // Modify movie
    @RequestMapping(value = "/movie/", method = RequestMethod.PATCH)
    public ModelAndView modifyMovie(@RequestParam String movieId,
                                    @RequestParam String movieTitle,
                                    @RequestParam String movieUrl,
                                    @RequestParam(required = false) String movieDesc,
                                    @RequestParam(required = false) String movieYear,
                                    @RequestParam(required = false) String movieDirector,
                                    @RequestParam(required = false) String movieActors,
                                    @RequestParam(required = false) String movieUrlFront,
                                    @RequestParam(required = false) String movieRating) {
        // Create new object movie with the fields to modify
        Movie movie = new Movie();
        movie.setMovieId(Integer.valueOf(movieId));
        movie.setMovieTitle(movieTitle);
        movie.setMovieUrl(movieUrl);
        movie.setMovieDesc(movieDesc);
        if (movieYear.equals("")){
            movie.setMovieYear(-1);
        } else {
            movie.setMovieYear(Integer.valueOf(movieYear));
        }
        movie.setMovieDirector(movieDirector);
        movie.setMovieActors(movieActors);
        movie.setMovieUrlFront(movieUrlFront);
        if (movieRating.equals("")){
            movie.setMovieRating(-1.0);
        } else {
            movie.setMovieRating(Double.parseDouble(movieRating));
        }
        // Modify movie
        movieService.modifyMovie(movie);
        // Redirect to management movies page
        return getMovies();
    }

    // Delete movie
    @RequestMapping(value = "/movie/", method = RequestMethod.DELETE)
    public ModelAndView deleteMovie(@RequestParam String movieId) {
        movieService.deleteMovie(Integer.valueOf(movieId));
        // Redirect to management movies page
        return getMovies();
    }

}