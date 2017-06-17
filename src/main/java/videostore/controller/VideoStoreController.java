package videostore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import videostore.service.MovieService;
import videostore.service.UserService;

/**
 * Created by victor on 17/06/17.
 */
@Controller
@RequestMapping(value = "/")
public class VideoStoreController {

    @Autowired
    private UserService userService;

    @Autowired
    private MovieService movieService;

    @RequestMapping(value = "/login")
    public ModelAndView login() {
        String template = userService.login();
        return new ModelAndView(template);
    }

    @RequestMapping(value = "/movie/search")
    public ModelAndView searchMovie(@RequestParam String movie_title){
        String template = movieService.search(movie_title);
        return new ModelAndView(template);
    }

    @RequestMapping(value = "/movie/watch")
    public ModelAndView watchMovie(@RequestParam int movie_id){
        String template = movieService.watch(movie_id);
        return new ModelAndView(template);
    }

    @RequestMapping(value = "/management")
    public ModelAndView management() {
        return new ModelAndView("management");
    }

    @RequestMapping(value = "/management/user/new")
    public ModelAndView newUser(@RequestParam String user_name,
                                @RequestParam String user_password,
                                @RequestParam String user_email) {
        String template = userService.newUser(user_name, user_password, user_email);
        return new ModelAndView(template);
    }

    @RequestMapping(value = "/management/user/modify")
    public ModelAndView modifyUser(@RequestParam int id,
                                   @RequestParam String user_name,
                                   @RequestParam String user_password,
                                   @RequestParam String user_email) {
        String template = userService.modifyUser(id, user_name, user_password, user_email);
        return new ModelAndView(template);
    }

    @RequestMapping(value = "/management/user/delete")
    public ModelAndView deleteUser(@RequestParam int id) {
        String template = userService.deleteUser(id);
        return new ModelAndView(template);
    }

    @RequestMapping(value = "/management/movie/new")
    public ModelAndView newMovie(@RequestParam String movie_title,
                                 @RequestParam String movie_url,
                                 @RequestParam(required = false) String movie_desc,
                                 @RequestParam(required = false) int movie_year,
                                 @RequestParam(required = false) String movie_director,
                                 @RequestParam(required = false) String movie_actors,
                                 @RequestParam(required = false) String movie_url_front,
                                 @RequestParam(required = false) double movie_rating) {
        String template = movieService.newMovie(movie_title, movie_url, movie_desc, movie_year, movie_director, movie_actors, movie_url_front, movie_rating);
        return new ModelAndView(template);
    }

    @RequestMapping(value = "/management/movie/modify")
    public ModelAndView modifyMovie(@RequestParam int movie_id,
                                    @RequestParam String movie_title,
                                    @RequestParam String movie_url,
                                    @RequestParam String movie_desc,
                                    @RequestParam int movie_year,
                                    @RequestParam String movie_director,
                                    @RequestParam String movie_actors,
                                    @RequestParam String movie_url_front,
                                    @RequestParam double movie_rating) {
        String template = movieService.modifyMovie(movie_id, movie_title, movie_url, movie_desc, movie_year, movie_director, movie_actors, movie_url_front, movie_rating);
        return new ModelAndView(template);
    }

    @RequestMapping(value = "/management/movie/delete")
    public ModelAndView deleteMovie(@RequestParam int id) {
        String template = movieService.deleteMovie(id);
        return new ModelAndView(template);
    }

}
