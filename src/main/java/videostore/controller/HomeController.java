package videostore.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
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
        // Check if user is already logged in
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        boolean isLogged = false;
        String username = null;
        boolean isAdmin = false;
        if (!auth.getName().equals("anonymousUser")){
            username = auth.getName();
            isLogged = true;
            SimpleGrantedAuthority roleAdmin = new SimpleGrantedAuthority("ROLE_ADMIN");
            if (auth.getAuthorities().contains(roleAdmin)){
                isAdmin = true;
            }
        }
        return new ModelAndView("home").addObject("username", username).addObject("isAdmin", isAdmin).addObject("isLogged", isLogged);
    }

    @RequestMapping(value = "/login")
    public ModelAndView login() {
        return new ModelAndView("login");
    }


}