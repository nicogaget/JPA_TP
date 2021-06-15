package com.tp.tp_spring_jpa_mysql.Controllers;

import com.sun.istack.NotNull;
import com.tp.tp_spring_jpa_mysql.dtos.GetCommandeDTO;
import com.tp.tp_spring_jpa_mysql.models.Client;
import com.tp.tp_spring_jpa_mysql.models.Commande;
import com.tp.tp_spring_jpa_mysql.repositories.ClientRepository;
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
    private CommandeService commandeService;
    @Autowired
    private ClientService clientService;

    @GetMapping("")
    public List<GetCommandeDTO> findAll() {
        return this.commandeService.findAll();
    }

    @GetMapping("/client/{id}")
    public List<GetCommandeDTO> findCommandesByClientId(@PathVariable int id) {

            Optional<Client> client = clientService.findById(id);
            return this.commandeService.findByClient(client);

    }

    @GetMapping("{id}")
    public Optional<Commande> findById(@PathVariable int id) {
        return commandeService.findById(id);
    }

    @PostMapping
    public Commande save(@RequestBody Commande commande) {
        return commandeService.save(commande);
    }

    @DeleteMapping
    public void delete(@RequestBody Commande commande) {
        commandeService.delete(commande.getId());
    }
}
