package com.tp.tp_spring_jpa_mysql.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tp.tp_spring_jpa_mysql.dtos.GetClientDTO;
import com.tp.tp_spring_jpa_mysql.models.Client;
import com.tp.tp_spring_jpa_mysql.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClientService {


    private JpaRepository<Client, Integer> repository;

    private ObjectMapper mapper;

    public ClientService(JpaRepository<Client, Integer> repository, ObjectMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Autowired
    ClientRepository clientRepository;

    public List<GetClientDTO> findAll() {
        List<Client> clients = this.repository.findAll();
        List<GetClientDTO> getClientDTOS = new ArrayList<>();
        clients.forEach(client -> {
            getClientDTOS.add(
                    this.mapper.convertValue(client, GetClientDTO.class)
            );
        });
        return getClientDTOS;
    }


    public Optional<Client> findById(int id) {
        return this.repository.findById(id);
    }

    public Optional<Client> findByNom(String name) {
        return this.clientRepository.findByNom(name);
    }


    public Client save(Client entity) {
        return this.clientRepository.save(entity);
    }


    public Client update(String id, Client entity) {
        return this.clientRepository.save(entity);
    }


    public void delete(int id) {
        this.clientRepository.deleteById(id);
    }
}
