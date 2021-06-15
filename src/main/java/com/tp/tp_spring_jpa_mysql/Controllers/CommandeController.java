package com.tp.tp_spring_jpa_mysql.Controllers;

import com.tp.tp_spring_jpa_mysql.dtos.GetCommandeDTO;
import com.tp.tp_spring_jpa_mysql.models.Commande;
import com.tp.tp_spring_jpa_mysql.services.ClientService;
import com.tp.tp_spring_jpa_mysql.services.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("commandes")
public class CommandeController {
    @Autowired
    private CommandeService service;
    private ClientService clientService;

    @GetMapping("")
    public List<GetCommandeDTO> findAll() {
        return this.service.findAll();
    }

    @GetMapping("{id}")
    public Optional<Commande> findById(@PathVariable int id) {
        return service.findById(id);
    }

    @PostMapping
    public Commande save(@RequestBody Commande commande) {
        return service.save(commande);
    }

    @DeleteMapping
    public void delete(@RequestBody Commande commande) {
        service.delete(commande.getId());
    }
}
