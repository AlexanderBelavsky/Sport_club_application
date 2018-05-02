package com.netcracker.devschool.dev4.etalon.repository;

import com.netcracker.devschool.dev4.etalon.entity.Subscription;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SubscriptionRepository extends JpaRepository<Subscription,Integer> {
    @Query("select b from Subscription b where b.idSubscription in (select c.IdSubscription from Calculation c where c.idClient = :id)")
    List<Subscription> findSubscriptionByIdClient(@Param("id") int id);

    @Query("select b from Subscription b where b.idSubscription in (select c.IdSubscription from Calculation c where c.idClient = :id)")
    Subscription findSubscriptionByIdClient1(@Param("id") int id);

    /*@Query("select l from Subscription l where concat(l.description, l.value, l.day1, l.day2, l.month, " +
            "(select g.gym_name from Gym f where f.idGym = l.idGym) like concat('%', :skey, '%') ")
    Page<Subscription> findWithoutPracticeId(@Param("skey") String key, Pageable page);*/

}
