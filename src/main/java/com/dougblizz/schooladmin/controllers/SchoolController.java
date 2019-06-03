package com.dougblizz.schooladmin.controllers;

import com.dougblizz.schooladmin.constants.ViewConstant;
import com.dougblizz.schooladmin.entities.School;
import com.dougblizz.schooladmin.services.SchoolService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/schools")
public class SchoolController {

    public static final Log LOG= LogFactory.getLog(SchoolController.class);

    @Autowired
    @Qualifier("schoolService")
    private SchoolService schoolService;

    @GetMapping("/all")
    public ModelAndView showSchools(){
        ModelAndView mav=new ModelAndView(ViewConstant.SCHOOL_VIEW);
        mav.addObject("schools",schoolService.allSchools());
        return mav;
    }

    @GetMapping("/cancel")
    public String cancel(){
        return "redirect:/schools/all";
    }

    @GetMapping("/schoolform")
    private String redirectContactForm(@RequestParam(name="id", required = false) long id,
                                       Model model){
        School school=new School();
        if (id!=0){
            school=schoolService.findContactById(id);
        }
        model.addAttribute("school",school);
        return ViewConstant.CONTACTFORM_VIEW;
    }

    @PostMapping("/add")
    public String addSchools(@ModelAttribute(name="school")School school){
        LOG.info("METHOD: addContact() -- PARAMs: error="+school.toString());
        schoolService.addSchool(school);

        return "redirect:/schools/all";
    }

    @GetMapping("/delete")
    public String deleteSchool(@RequestParam(name="id", required = true) long id){
        schoolService.deleteSchool(id);
        return "redirect:/schools/all";
    }
}
