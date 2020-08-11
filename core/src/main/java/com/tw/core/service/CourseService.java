package com.tw.core.service;

import com.tw.core.Course;
import com.tw.core.CourseDate;
import com.tw.core.dao.CourseDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by chenbojian on 15-6-26.
 */
@Service
public class CourseService {
    private CourseDAO courseDAO;

    @Autowired
    public CourseService(CourseDAO courseDAO) {
        this.courseDAO = courseDAO;
    }

    public List<Course> listCourse(){
        return courseDAO.listCourse();
    }

    public void addCourse(Course course){
        courseDAO.addCourse(course);
    }

    public void deleteCourse(long id){
        courseDAO.deleteCourse(id);
    }

    public void updateCourse(Course course){
        courseDAO.updateCourse(course);
    }

    public Course findCourseById(long id) {
        return courseDAO.findCourseById(id);
    }

    public List<CourseDate> findCourseBetween(Date start, Date end) {
        return courseDAO.findDateBetween(start,end);
    }
}
