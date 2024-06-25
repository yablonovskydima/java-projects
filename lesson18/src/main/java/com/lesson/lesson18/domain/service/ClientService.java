package com.lesson.lesson18.domain.service;

import com.lesson.lesson18.domain.entity.Client;
import com.lesson.lesson18.domain.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService
{
    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository)
    {
        this.clientRepository = clientRepository;
    }

    public Client updateClient(int id, Client updatedClient)
    {
        Client isexist =clientRepository.findById(id).orElse(null);

        if(isexist != null)
        {
            isexist.setName(updatedClient.getName());
            isexist.setPhoneNumber(updatedClient.getPhoneNumber());
            isexist.setRents(updatedClient.getRents());
            return clientRepository.save(isexist);
        }
        else
        {
            return null;
        }
    }
}
