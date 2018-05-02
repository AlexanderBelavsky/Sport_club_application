package com.netcracker.devschool.dev4.etalon.service;

import com.netcracker.devschool.dev4.etalon.entity.Calculation;
import com.netcracker.devschool.dev4.etalon.entity.Coach;
import com.netcracker.devschool.dev4.etalon.entity.Subscription;
import com.netcracker.devschool.dev4.etalon.repository.CoachRepository;
import com.netcracker.devschool.dev4.etalon.repository.SubscriptionRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {
    @Resource
    private SubscriptionRepository subscriptionRepository;

    @Override
    public Subscription create(Subscription subscription) {
        return subscriptionRepository.save(subscription);
    }

    @Override
    public void deleteSubscriptionById(int id) {
        subscriptionRepository.delete(id);
    }

    @Override
    public Subscription delete(int idSubscription) throws Exception {
        if (subscriptionRepository.exists(idSubscription)) {
            Subscription deleted = subscriptionRepository.findOne(idSubscription);
            subscriptionRepository.delete(idSubscription);
            return deleted;
        } else {
            throw new Exception("Not found");
        }
    }

    @Override
    public List<Subscription> findAll() {
        return subscriptionRepository.findAll();
    }

    @Override
    public Subscription update(Subscription subscription) throws Exception {
        if (subscriptionRepository.exists(subscription.getidSubscription())) {
            Subscription updated = subscriptionRepository.findOne(subscription.getidSubscription());
            updated.setDescription(subscription.getDescription());
            updated.setValue(subscription.getValue());
            updated.setIdGym(subscription.getIdGym());
            updated.setDay1(subscription.getDay1());
            updated.setDay2(subscription.getDay2());
            updated.setMonth(subscription.getMonth());
            return updated;
        }
        return null;
    }

    @Override
    public Subscription findById(int idSubscription) {
        return subscriptionRepository.findOne(idSubscription);
    }

    @Override
    public List<Subscription> findSubscriptionByIdClient(int id) {
        return subscriptionRepository.findSubscriptionByIdClient(id);
    }
    @Override
    public Subscription findSubscriptionByIdClient1(int id){
        return subscriptionRepository.findSubscriptionByIdClient1(id);
    }
}
