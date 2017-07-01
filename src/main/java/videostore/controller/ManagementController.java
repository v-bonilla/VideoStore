package videostore.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import videostore.model.Movie;
import videostore.model.User;
import videostore.service.MovieService;
import videostore.service.UserService;

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

    @RequestMapping(value = "/")
    public ModelAndView management() {
        return new ModelAndView("management");
    }

    @RequestMapping(value = "/user/{userId}")
    public ModelAndView getUser(@PathVariable Integer userId) {

        return new ModelAndView("management", "managementModel", userService.getUser(userId));
    }

    @RequestMapping(value = "/user/{userName}/{userPassword}/{userEmail}/", method = RequestMethod.POST)
    public ModelAndView newUser(@PathVariable("userName") String userName,
                                @PathVariable("userPassword") String userPassword, @PathVariable("userEmail") String userEmail,
                                @PathVariable("admin") String admin) {

        List<GrantedAuthority> roles = new ArrayList<>();
        roles.add(new SimpleGrantedAuthority("ROLE_USER"));
        if ("S".equals(admin)) {
            roles.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        }
        User user = new User(0, userName, userPassword, userEmail, roles);
        return new ModelAndView("management", "managementModel", userService.newUser(user));
    }

    @RequestMapping(value = "/user/{userId}/", method = RequestMethod.PATCH)
    public ModelAndView modifyUser(@PathVariable("userId") Integer userId, @RequestParam("userName") String userName,
                                   @RequestParam("userPassword") String userPassword, @RequestParam("userEmail") String userEmail,
                                   @RequestParam("admin") String admin) {

        List<GrantedAuthority> roles = new ArrayList<>();
        roles.add(new SimpleGrantedAuthority("ROLE_USER"));
        if ("S".equals(admin)) {
            roles.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        }
        User user = new User(userId, userName, userPassword, userEmail, roles);
        return new ModelAndView("management", "managementModel", userService.modifyUser(user));
    }

    @RequestMapping(value = "/user/{userId}", method = RequestMethod.DELETE)
    public ModelAndView deleteUser(@PathVariable("userId") Integer userId) {

        return new ModelAndView("management", "managementModel", userService.deleteUser(userId));
    }

    @RequestMapping(value = "/movie/", method = RequestMethod.POST)
    public ModelAndView newMovie(@RequestParam String movieTitle, @RequestParam String movieUrl,
                                 @RequestParam(required = false) String movieDesc, @RequestParam(required = false) Integer movieYear,
                                 @RequestParam(required = false) String movieDirector, @RequestParam(required = false) String movieActors,
                                 @RequestParam(required = false) String movieUrlFront, @RequestParam(required = false) Double movieRating) {
        Movie movie = new Movie();
        movie.setMovieActors(movieActors);
        movie.setMovieDesc(movieDesc);
        movie.setMovieDirector(movieDirector);
        movie.setMovieRating(movieRating);
        movie.setMovieTitle(movieTitle);
        movie.setMovieUrl(movieUrlFront);
        movie.setMovieUrlFront(movieUrlFront);
        movie.setMovieYear(movieYear);
        return new ModelAndView("management", "managementModel", movieService.newMovie(movie));
    }

    @RequestMapping(value = "/movie/{movieId}", method = RequestMethod.PATCH)
    public ModelAndView modifyMovie(@PathVariable("movieId") Integer movieId, @RequestParam String movieTitle,
                                    @RequestParam String movieUrl, @RequestParam(required = false) String movieDesc,
                                    @RequestParam(required = false) Integer movieYear, @RequestParam(required = false) String movieDirector,
                                    @RequestParam(required = false) String movieActors, @RequestParam(required = false) String movieUrlFront,
                                    @RequestParam(required = false) Double movieRating) {

        return new ModelAndView("management");
    }

    @RequestMapping(value = "/movie/{movieId}")
    public ModelAndView deleteMovie(@RequestParam int id) {

        return new ModelAndView("management");
    }

}