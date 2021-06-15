package com.tp.tp_spring_jpa_mysql.repositories;

import com.tp.tp_spring_jpa_mysql.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client,Integer> {
    Optional<Client> findByNom(String Name);

}
