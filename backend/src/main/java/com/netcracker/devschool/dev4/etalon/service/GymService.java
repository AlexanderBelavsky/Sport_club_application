package com.netcracker.devschool.dev4.etalon.service;

import com.netcracker.devschool.dev4.etalon.entity.Gym;


import java.util.List;

public interface GymService {
    public Gym create(Gym gym);

    public void deleteGymById(int id);

    public Gym delete(int idGym) throws Exception;

    public List<Gym> findAll();

    public Gym update(Gym gym) throws Exception;

    public Gym findById(int idGym);
}
