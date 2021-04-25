package com.webmvc.smarthousemanagementsystem.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @GetMapping(value = {"/"})
    public ModelAndView homeRedirect() {
        return new ModelAndView("redirect:/home");
    }

    @GetMapping(value = {"/home"})
    public ModelAndView home(ModelMap model) {



        return new ModelAndView("pages/home/index", model);
    }


}
