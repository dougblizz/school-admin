package com.dougblizz.schooladmin.controllers;

import com.dougblizz.schooladmin.constants.ViewConstant;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/welcome")
public class WelcomeController {

    @GetMapping()
    public ModelAndView welcome(){
        return new ModelAndView(ViewConstant.WELCOME_VIEW);
    }

}
