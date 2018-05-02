package com.netcracker.etalon.controllers;

import com.netcracker.devschool.dev4.etalon.entity.Client;

import com.netcracker.devschool.dev4.etalon.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

@Controller
@RequestMapping(value = "/clients")
public class ClientController {
    @Autowired
    private ClientService clientService;

    //Save the uploaded file to this folder


    @RequestMapping(value = "/edit/{idClient}", method = RequestMethod.POST)
    @ResponseBody
    public Client editClient(@PathVariable String idClient,
                               @RequestParam(value = "first_name", required = false) String first_name,
                               @RequestParam(value = "last_name", required = false) String last_name,
                               @RequestParam(value = "phone_number", required = false) String phone_number,
                               @RequestParam(value = "email", required = false) String email,
                               @RequestParam(value = "coach", required = false) String coach

    ) {
        String msg = "";
        Client client = clientService.findById(Integer.parseInt(idClient));
        try {
            if (!Objects.equals(first_name, "") && first_name != null) client.setFirst_name(first_name);
            if (!Objects.equals(last_name, "") && last_name != null) client.setLast_name(last_name);
            if (!Objects.equals(phone_number, "") && phone_number != null) client.setPhone_number(Integer.parseInt(phone_number));
            if (!Objects.equals(coach, "") && coach != null)
                client.setIdCoach(Integer.parseInt(coach));
            if (!Objects.equals(email, "") && email != null) client.setEmail(email);
            clientService.update(client);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return client;
    }



    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Client getClient(@PathVariable int id) {
        return clientService.findById(id);
    }
}
