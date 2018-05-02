package com.netcracker.devschool.dev4.etalon.service;

import com.netcracker.devschool.dev4.etalon.entity.Calculation;

import java.util.List;

public interface CalculationService {
    Calculation create(Calculation calculation);

    public void deleteCalculationById(int id);

    Calculation delete(int id) throws Exception;

    List<Calculation> findAll();

    List<Calculation> findByIdClient(int id);

    Calculation update(Calculation calculation) throws Exception;

    Calculation findById(int id);

    void findCalculationByIdClientAndIdSubscription(int idClient, int idSubscription);

    void deleteCalculationByIdClient(int idClient);
}
