package com.example.login.controllers;

import com.example.login.models.Login;
import com.example.login.models.User;
import com.example.login.models.UserDAO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @GetMapping("/home")
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("login", new Login());
        return modelAndView;
    }

    @PostMapping("/login")
    public ModelAndView login (@ModelAttribute("login")Login login){
        User user = UserDAO.checkLogin(login);
        ModelAndView modelAndView;
        if(user==null){
            modelAndView = new ModelAndView("error");
        } else {
            modelAndView = new ModelAndView("user");
            modelAndView.addObject("user",user);
        }
        return modelAndView;
    }

}
