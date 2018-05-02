package com.netcracker.devschool.dev4.etalon.service;


import com.netcracker.devschool.dev4.etalon.entity.Coach;
import com.netcracker.devschool.dev4.etalon.entity.Subscription;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CoachService {
    public Coach create(Coach coach);

    public void  deleteCoachById(int id);

    public Coach delete(int idCoach) throws Exception;

    public List<Coach> findAll();

    public Coach update(Coach coach) throws Exception;

    public Coach findById(int idCoach);

    List<Subscription> findSubscriptionByIdCoach( int id);
}
