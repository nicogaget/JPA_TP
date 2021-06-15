package com.tp.tp_spring_jpa_mysql.repositories;

import com.tp.tp_spring_jpa_mysql.models.Client;
import com.tp.tp_spring_jpa_mysql.models.Commande;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CommandeRepository extends JpaRepository<Commande,Integer> {
    Optional<Commande> findById(int id);
    List<Commande> findByClient(Optional<Client> client);
}