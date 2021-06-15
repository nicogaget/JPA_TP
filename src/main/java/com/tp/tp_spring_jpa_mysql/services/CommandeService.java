package com.tp.tp_spring_jpa_mysql.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tp.tp_spring_jpa_mysql.dtos.GetCommandeDTO;
import com.tp.tp_spring_jpa_mysql.models.Client;
import com.tp.tp_spring_jpa_mysql.models.Commande;
import com.tp.tp_spring_jpa_mysql.repositories.CommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CommandeService {


    private final ObjectMapper mapper;
    private JpaRepository<Commande, Integer> repository;


    public CommandeService(JpaRepository<Commande, Integer> repository, ObjectMapper mapper) {
        this.repository = repository;
        this.mapper=mapper;

    }

    @Autowired
    CommandeRepository commandeRepository;


    public List<GetCommandeDTO> findAll() {
        List<Commande> commandes = this.repository.findAll();
        List<GetCommandeDTO> getCommandeDTOS = new ArrayList<>();
        commandes.forEach( commande -> {
            getCommandeDTOS.add(
                    this.mapper.convertValue(commande, GetCommandeDTO.class )
            );
        });
        return getCommandeDTOS;
    }
    public List<Commande> findByClient(Optional<Client> client){

        return this.commandeRepository.findByClient(client);
    }

    public Optional<Commande> findById(int id) {
        return this.repository.findById(id);
    }

    public Optional<Commande> findByNom(int id) {
        return this.commandeRepository.findById(id);
    }



    public Commande save(Commande entity) {
        return this.commandeRepository.save(entity);
    }


    public Commande update(String id, Commande entity) {
        return this.commandeRepository.save(entity);
    }


    public void delete(int id) {
        this.commandeRepository.deleteById(id);
    }


}
