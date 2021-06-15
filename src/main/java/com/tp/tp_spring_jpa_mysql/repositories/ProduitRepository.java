package com.tp.tp_spring_jpa_mysql.repositories;

import com.tp.tp_spring_jpa_mysql.models.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProduitRepository extends JpaRepository<Produit,Integer> {
    Optional<Produit> findByNom(String Name);
}