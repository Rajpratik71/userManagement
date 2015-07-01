package com.tw.web;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.tw.core.Course;
import com.tw.core.CourseDate;
import com.tw.core.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLOutput;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by chenbojian on 15-6-26.
 */
@Controller
@RequestMapping("/course")
public class CourseController {
    private CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @RequestMapping("/")
    public ModelAndView listCourse() {
        ModelAndView modelAndView = new ModelAndView("courseList");
        List<Course> courses = courseService.listCourse();
        modelAndView.addObject("courses", courses);
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView addCoursePage(CourseBean courseBean) {
        ModelAndView modelAndView = new ModelAndView("addCourse");
        courseBean.getCourseDates().add(new Date(0));
        courseBean.getCourseDates().add(new Date(1));
        return new ModelAndView("addCourse");
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addCourse(@ModelAttribute CourseBean courseBean) {
        for(Date date : courseBean.getCourseDates()){
            System.out.println("courseBean = [" + date + "] in POST");

        }
        courseService.addCourse(courseBean.toCourse());
        return new ModelAndView("redirect:/course/");
    }

    @RequestMapping(value = "/{id}/delete")
    public ModelAndView deleteCourse(@PathVariable("id") long id) {
        courseService.deleteCourse(id);
        return new ModelAndView("redirect:/course/");
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
    public ModelAndView editCoursePage(@PathVariable("id") long id) {
        Course course = courseService.findCourseById(id);
        ModelAndView modelAndView = new ModelAndView("courseEdit");
        modelAndView.addObject("course", course);
        return modelAndView;
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
    public ModelAndView editCourse(@PathVariable("id") long id, @ModelAttribute Course course) {
        courseService.updateCourse(course);
        return new ModelAndView("redirect:/course/");
    }

    @InitBinder
    private void dateBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        CustomDateEditor editor = new CustomDateEditor(dateFormat, true);
        binder.registerCustomEditor(Date.class, editor);
    }
}
