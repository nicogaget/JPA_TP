package com.tp.tp_spring_jpa_mysql.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tp.tp_spring_jpa_mysql.dtos.GetProduitDTO;
import com.tp.tp_spring_jpa_mysql.models.Produit;
import com.tp.tp_spring_jpa_mysql.repositories.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProduitService {


    private JpaRepository<Produit, Integer> repository;
    private ObjectMapper mapper;
    @Autowired
    ProduitRepository produitRepository;

    public ProduitService(JpaRepository<Produit, Integer> repository, ObjectMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    public List<GetProduitDTO> findAll() {
        List<Produit> produits = this.repository.findAll();
        List<GetProduitDTO> getProduitDTOS = new ArrayList<>();
        produits.forEach(produit -> {
            getProduitDTOS.add(
                    this.mapper.convertValue(produit, GetProduitDTO.class)
            );
        });


        return getProduitDTOS;
    }


    public Optional<Produit> findById(int id) {
        return this.repository.findById(id);
    }

    public Optional<Produit> findByNom(String name) {
        return this.produitRepository.findByNom(name);
    }


    public Produit save(Produit entity) {
        return this.produitRepository.save(entity);
    }


    public Produit update(String id, Produit entity) {
        return this.produitRepository.save(entity);
    }


    public void delete(int id) {
        this.produitRepository.deleteById(id);
    }
}
