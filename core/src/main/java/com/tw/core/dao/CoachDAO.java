package com.tw.core.dao;

import com.tw.core.Coach;
import com.tw.core.Employee;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by twer on 7/17/14.
 */
@Repository
@Transactional
public class CoachDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public CoachDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Coach> listCoach() {
        return sessionFactory.getCurrentSession().createQuery("from Coach")
                .list();
    }

    public void addCoach(Coach coach) {
        sessionFactory.getCurrentSession().save(coach);
    }

    public Coach findCoachById(long id) {
        Coach coach = (Coach) sessionFactory.getCurrentSession().get(Coach.class, id);
        return coach;
    }

    public void updateCoach(Coach coach) {
        sessionFactory.getCurrentSession().update(coach);
    }

    public void deleteCoach(long id) {
        Coach coach = findCoachById(id);
        if (coach != null) {
            sessionFactory.getCurrentSession().delete(coach);
        }
    }

    public void deleteCoachList(long[] ids) {
        for (long id : ids) {
            deleteCoach(id);
        }
    }

}
