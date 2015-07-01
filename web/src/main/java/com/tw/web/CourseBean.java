package com.tw.web;

import com.tw.core.Coach;
import com.tw.core.Course;
import com.tw.core.CourseDate;
import org.springframework.util.AutoPopulatingList;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by chenbojian on 15-7-1.
 */
public class CourseBean {
    private String courseName = "course";
    private int coachId;
    private List<Date> courseDates =new ArrayList<Date>(0);

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCoachId() {
        return coachId;
    }

    public void setCoachId(int coachId) {
        this.coachId = coachId;
    }

    public List<Date> getCourseDates() {
        return courseDates;
    }

    public void setCourseDates(List<Date> courseDates) {
        this.courseDates = courseDates;
    }
    public Course toCourse(){
        Course course= new Course();
        course.setCoach(new Coach());
        course.getCoach().setId(coachId);
        course.setCourseName(courseName);
        for (Date date : courseDates) {
            CourseDate courseDate = new CourseDate();
            courseDate.setCourse(course);
            courseDate.setDate(date);
            course.getCourseDates().add(courseDate);
        }
        return course;
    }
}
