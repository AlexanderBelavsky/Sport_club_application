package com.netcracker.devschool.dev4.etalon.service;

import com.netcracker.devschool.dev4.etalon.entity.Client;
import com.netcracker.devschool.dev4.etalon.repository.ClientRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {
    @Resource
    private ClientRepository clientRepository;

    @Override
    @Transactional
    public Client create(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public void  deleteClientById(int id){
        clientRepository.delete(id);
    }

    @Override
    @Transactional
    public Client delete(int id) throws Exception {
        Client deletedStudent = clientRepository.findOne(id);

        if (deletedStudent == null)
            throw new Exception("Not found");

        clientRepository.delete(deletedStudent);
        return deletedStudent;
    }

    @Override
    @Transactional
    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    @Transactional
    public Client update(Client client) throws Exception {
        Client updated = clientRepository.findOne(client.getIdClient());
        updated.setFirst_name(client.getFirst_name());
        updated.setLast_name(client.getLast_name());
        updated.setPhone_number(client.getPhone_number());
        updated.setIdCoach(client.getIdCoach());
        updated.setEmail(client.getEmail());
        return updated; //TODO:
    }

    @Override
    public Client findById(int id) {
        return clientRepository.findOne(id);
    }
}
