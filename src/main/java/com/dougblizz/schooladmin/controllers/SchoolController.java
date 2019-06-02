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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/schools")
public class SchoolController {

    public static final Log LOG= LogFactory.getLog(SchoolController.class);

    @Autowired
    @Qualifier("schoolService")
    private SchoolService schoolService;

    @GetMapping
    public ModelAndView showSchools(){
        ModelAndView mav=new ModelAndView(ViewConstant.SCHOOL_VIEW);
        mav.addObject("schools",schoolService.allSchools());
        return mav;
    }

    @GetMapping("/add")
    public String addSchools(@ModelAttribute(name="contactModel")School school,
                                   Model model){
        LOG.info("METHOD: addContact() -- PARAMs: error="+school.toString());

        /*if (schoolService.addContact(school) != null){
            model.addAttribute("result",1);
        }else{
            model.addAttribute("result",0);
        }*/

        return "redirect:/schools";
    }
}
