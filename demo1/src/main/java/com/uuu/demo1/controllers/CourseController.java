package com.uuu.demo1.controllers;

import com.uuu.demo1.beans.CourseForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.validation.Valid;

@Controller
public class CourseController implements WebMvcConfigurer {

    private static final Logger LOG = LoggerFactory.getLogger(CourseController.class);

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/results").setViewName("results");
    }

    @GetMapping("/course")
    public String showForm(CourseForm personForm) {
        return "courseForm";
    }

    @PostMapping("/course")
    public String checkPersonInfo(@Valid CourseForm form, BindingResult bindingResults) {
        LOG.info("courseForm={}", form);

        if(bindingResults.hasErrors()) {
            return "courseForm";
        }

        return "redirect:/results";
    }

}
