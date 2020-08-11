package com.tw.core.service;

import com.tw.core.Coach;
import com.tw.core.dao.CoachDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by twer on 7/17/14.
 */
@Service
@Transactional
public class CoachService {
    private CoachDAO coachDAO;

    @Autowired
    public CoachService(CoachDAO coachDAO) {
        this.coachDAO = coachDAO;
    }

    public List<Coach> listCoach() {
        return coachDAO.listCoach();
    }

    public void addCoach(Coach coach) {
        coachDAO.addCoach(coach);
    }

    public Coach findCoachById(long id) {
        return coachDAO.findCoachById(id);
    }

    public void updateCoach(Coach coach) {
        coachDAO.updateCoach(coach);
    }

    public void deleteCoach(long id) {
        coachDAO.deleteCoach(id);
    }

    public void deleteCoachList(long[] ids) {
        coachDAO.deleteCoachList(ids);
    }


}
