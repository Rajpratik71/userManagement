package com.tw.web;

import com.tw.core.Course;
import com.tw.core.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
    public ModelAndView listCourse(){
        ModelAndView modelAndView = new ModelAndView("courseList");
        List<Course> courses = courseService.listCourse();
        modelAndView.addObject("courses",courses);
        return modelAndView;
    }
    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public ModelAndView addCoursePage(){
        ModelAndView modelAndView = new ModelAndView("addCourse");
        modelAndView.addObject("course", new Course());
        return modelAndView;
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public ModelAndView addCourse(@ModelAttribute Course course){
        courseService.addCourse(course);
        return new ModelAndView("redirect:/course/");
    }

    @RequestMapping(value = "/{id}/delete")
    public ModelAndView deleteCourse(@PathVariable("id") long id){
        courseService.deleteCourse(id);
        return new ModelAndView("redirect:/course/");
    }

    @RequestMapping(value = "/{id}/edit",method = RequestMethod.GET)
    public ModelAndView editCoursePage(@PathVariable("id") long id){
        Course course = courseService.findCourseById(id);
        ModelAndView modelAndView = new ModelAndView("courseEdit");
        modelAndView.addObject("course",course);
        return modelAndView;
    }
    @RequestMapping(value = "/{id}/edit",method = RequestMethod.POST)
    public ModelAndView editCourse(@PathVariable("id") long id,@ModelAttribute Course course){
        Course saveCourse = courseService.findCourseById(id);
        saveCourse.setCourseName(course.getCourseName());
        saveCourse.setCoachId(course.getCoachId());
        courseService.updateCourse(saveCourse);
        return new ModelAndView("redirect:/course/");
    }
}
