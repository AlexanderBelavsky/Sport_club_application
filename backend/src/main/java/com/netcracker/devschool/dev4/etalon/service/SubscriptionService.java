package com.netcracker.devschool.dev4.etalon.service;


import com.netcracker.devschool.dev4.etalon.entity.Calculation;
import com.netcracker.devschool.dev4.etalon.entity.Subscription;

import java.util.List;

public interface SubscriptionService {
    public Subscription create(Subscription subscription);

    public void deleteSubscriptionById(int id);

    public Subscription delete(int idSubscription) throws Exception;

    public List<Subscription> findAll();

    public Subscription update(Subscription subscription) throws Exception;

    public Subscription findById(int idSubscription);

    List<Subscription> findSubscriptionByIdClient(int id);

    Subscription findSubscriptionByIdClient1(int id);
}
