package com.webmvc.smarthousemanagementsystem.app.controllers;

import com.webmvc.smarthousemanagementsystem.domain.entities.UserEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserInfoController {

    @GetMapping(value = {"/user/info"})
    public ModelAndView registerGet(@AuthenticationPrincipal UserEntity user, ModelMap model) {
        model.addAttribute("userInfo", user);

        return new ModelAndView("pages/auth/user-info", model);
    }

}
