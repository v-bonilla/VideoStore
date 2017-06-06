package videostore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by victor on 7/3/17.
 */

@Controller
public class ApplicationController {

    @RequestMapping("/index")
    public ModelAndView index (){
        return new ModelAndView("index");
    }
}
