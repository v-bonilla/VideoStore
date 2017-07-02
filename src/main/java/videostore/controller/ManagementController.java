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

    @RequestMapping(value = "/")
    public ModelAndView management() {
        String username = "admin";
        return new ModelAndView("management").addObject("username", username);
    }

    @RequestMapping(value = "/user/")
    public ModelAndView getUsers() {
        List<User> users = userService.getUsers();
        return new ModelAndView("managementUser").addObject("users", users);
    }

    @RequestMapping(value = "/user/", method = RequestMethod.POST)
    public ModelAndView newUser(@RequestParam("userName") String userName,
                                @RequestParam("userPassword") String userPassword,
                                @RequestParam("userEmail") String userEmail,
                                @RequestParam("isAdmin") String isAdmin) {

        List<GrantedAuthority> roles = new ArrayList<>();
        roles.add(new SimpleGrantedAuthority("ROLE_USER"));
        if ("Y".equals(isAdmin)) {
            roles.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        }
        User user = new User(userName, new BCryptPasswordEncoder().encode(userPassword), userEmail, roles);
        userService.newUser(user);
        return getUsers();
    }

    @RequestMapping(value = "/user/", method = RequestMethod.PATCH)
    public ModelAndView modifyUser(@RequestParam("userId") String userId,
                                   @RequestParam("userName") String userName,
                                   @RequestParam("userPassword") String userPassword,
                                   @RequestParam("userEmail") String userEmail,
                                   @RequestParam("isAdmin") String isAdmin) {

        List<GrantedAuthority> roles = new ArrayList<>();
        roles.add(new SimpleGrantedAuthority("ROLE_USER"));
        if ("Y".equals(isAdmin)) {
            roles.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        }
        User user = new User(userName, userPassword, userEmail, roles);
        user.setUserId(Integer.valueOf(userId));
        userService.modifyUser(user);
        return getUsers();
    }

    @RequestMapping(value = "/user/", method = RequestMethod.DELETE)
    public ModelAndView deleteUser(@RequestParam("userId") String userId) {
        userService.deleteUser(Integer.valueOf(userId));
        return getUsers();
    }

    @RequestMapping(value = "/movie/")
    public ModelAndView getMovies() {
        return new ModelAndView("management");
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