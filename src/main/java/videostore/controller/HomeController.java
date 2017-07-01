package videostore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by victor on 17/06/17.
 */
@Controller
@RequestMapping(value = "/")
public class HomeController {



    @RequestMapping(value = "/")
    public ModelAndView home() {
        return new ModelAndView("home");
    }

    @RequestMapping(value = "/login")
    public ModelAndView login() {
//        String template = userService.login();
        return new ModelAndView("login");
    }


}