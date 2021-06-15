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
    private JpaRepository<Commande, Integer> commandeJpaRepository;



    public CommandeService(JpaRepository<Commande, Integer> repository, ObjectMapper mapper) {
        this.commandeJpaRepository = repository;
        this.mapper=mapper;

    }

    @Autowired
    CommandeRepository commandeRepository;


    public List<GetCommandeDTO> findAll() {
        List<Commande> commandes = this.commandeJpaRepository.findAll();
        List<GetCommandeDTO> getCommandeDTOS = new ArrayList<>();
        commandes.forEach( commande -> {
            getCommandeDTOS.add(
                    this.mapper.convertValue(commande, GetCommandeDTO.class )
            );
        });
        return getCommandeDTOS;
    }

    public List<GetCommandeDTO>findByClient(Optional<Client> client){
        List<Commande> commandes = commandeRepository.findByClient(client);
        List<GetCommandeDTO> getCommandeDTOS = new ArrayList<>();
        commandes.forEach( commande -> {
            getCommandeDTOS.add(
                    this.mapper.convertValue(commande, GetCommandeDTO.class )
            );
        });
        return getCommandeDTOS;
    }

    public Optional<Commande> findById(int id) {
        return this.commandeJpaRepository.findById(id);
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
