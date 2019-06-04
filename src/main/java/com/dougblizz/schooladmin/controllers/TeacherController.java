package com.dougblizz.schooladmin.controllers;

import com.dougblizz.schooladmin.constants.ViewConstant;
import com.dougblizz.schooladmin.entities.Teacher;
import com.dougblizz.schooladmin.repositories.CourseRepository;
import com.dougblizz.schooladmin.services.CourseService;
import com.dougblizz.schooladmin.services.SchoolService;
import com.dougblizz.schooladmin.services.TeacherService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/teachers")
public class TeacherController {

    public static final Log LOG= LogFactory.getLog(TeacherController.class);

    @Autowired
    @Qualifier("courseService")
    private CourseService courseService;


    @Autowired
    @Qualifier("schoolService")
    private SchoolService schoolService;

    @Autowired
    @Qualifier("teacherService")
    private TeacherService teacherService;

    @GetMapping("/all")
    public ModelAndView showTeachers(){
        ModelAndView mav=new ModelAndView(ViewConstant.TEACHER_VIEW);
        mav.addObject("teachers",teacherService.allTeachers());
        return mav;
    }

    @GetMapping("/teacherform")
    public String teacherForm(@RequestParam(name="id", required = false) long id,
                              Model model){
        Teacher teacher=new Teacher();
        if (id!=0){
            teacher=teacherService.findTeacherById(id);
        }
        model.addAttribute("listcourse",courseService.allCourses());
        model.addAttribute("listschool",schoolService.allSchools());
        model.addAttribute("teacher",teacher);
        return ViewConstant.TEACHER_CONTACT_VIEW;
    }

    @PostMapping("/add")
    public String addSchools(@ModelAttribute(name="teacher") Teacher teacher) {
        LOG.info("METHOD: addContact() -- PARAMs: error=" + teacher.toString());
        teacherService.addTeacher(teacher);

        return "redirect:/teachers/all";
    }



}
