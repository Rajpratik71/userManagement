package com.tw.core.dao;

import com.tw.core.Course;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by chenbojian on 15-6-26.
 */
@Repository
@Transactional
public class CourseDAO {
    private SessionFactory sessionFactory;

    @Autowired
    public CourseDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Course> listCourse(){
        return sessionFactory.getCurrentSession().createQuery("from Course")
                .list();
    }

    public void addCourse(Course course){
        sessionFactory.getCurrentSession().save(course);
    }
    public void deleteCourse(long id){
        Course course = findCourseById(id);
        if(course != null) {
            sessionFactory.getCurrentSession().delete(course);
        }
    }

    public Course findCourseById(long id) {
        return (Course) sessionFactory.getCurrentSession().get(Course.class, id);
    }

    public void updateCourse(Course course){
        sessionFactory.getCurrentSession().update(course);
    }
}