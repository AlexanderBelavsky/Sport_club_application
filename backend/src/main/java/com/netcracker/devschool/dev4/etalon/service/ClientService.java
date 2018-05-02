package com.netcracker.devschool.dev4.etalon.service;

import com.netcracker.devschool.dev4.etalon.entity.Client;
import java.util.List;

public interface ClientService {
    Client create(Client client);

    public void  deleteClientById(int id);

    Client delete(int id) throws Exception;

    List<Client> findAll();

    Client update(Client client) throws Exception;

    Client findById(int id);
}
