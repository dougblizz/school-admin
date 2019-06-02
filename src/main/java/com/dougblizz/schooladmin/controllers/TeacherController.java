package com.dougblizz.schooladmin.controllers;

import com.dougblizz.schooladmin.constants.ViewConstant;
import com.dougblizz.schooladmin.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/teachers")
public class TeacherController {

    @Autowired
    @Qualifier("teacherService")
    private TeacherService teacherService;

    @GetMapping
    public ModelAndView showTeachers(){
        ModelAndView mav=new ModelAndView(ViewConstant.TEACHER_VIEW);
        mav.addObject("teachers",teacherService.allTeachers());
        return mav;
    }

}
