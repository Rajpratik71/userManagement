package com.tw.core.dao;

import com.tw.core.CourseDate;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by chenbojian on 15-7-2.
 */
@Repository
@Transactional
public class CourseDateDAO {
    private SessionFactory sessionFactory;


    @Autowired
    public CourseDateDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<CourseDate> findDateBetween(Date start,Date end){
        return sessionFactory.getCurrentSession()
                .createQuery("From CourseDate as c where c.date between :startDate and :endDate")
                .setTimestamp("startDate", start)
                .setTimestamp("endDate", end)
                .list();
    }
}
