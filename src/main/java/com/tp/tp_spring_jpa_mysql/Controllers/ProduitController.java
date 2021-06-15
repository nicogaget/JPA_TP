package com.tp.tp_spring_jpa_mysql.Controllers;

import com.tp.tp_spring_jpa_mysql.dtos.GetProduitDTO;
import com.tp.tp_spring_jpa_mysql.models.Produit;
import com.tp.tp_spring_jpa_mysql.services.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("produits")
public class ProduitController {
    @Autowired
    private ProduitService service;

    @GetMapping("")
    public List<GetProduitDTO> findAll() {
        return this.service.findAll();
    }

    @GetMapping("{id}")
    public Optional<Produit> findById(@PathVariable int id) {
        return service.findById(id);
    }

    @GetMapping("/name/{name}")
    public Optional<Produit> findByNom(@PathVariable String name) {
        return service.findByNom(name);
    }

    @PostMapping
    public Produit save(@RequestBody Produit produit) {
        return service.save(produit);
    }

    @DeleteMapping
    public void delete(@RequestBody Produit produit) {
        service.delete(produit.getId());
    }
}
