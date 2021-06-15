package com.tp.tp_spring_jpa_mysql.Controllers;

import com.tp.tp_spring_jpa_mysql.dtos.GetClientDTO;
import com.tp.tp_spring_jpa_mysql.models.Client;
import com.tp.tp_spring_jpa_mysql.models.Commande;
import com.tp.tp_spring_jpa_mysql.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("clients")
public class ClientController {
    @Autowired
    private ClientService service;


    @GetMapping("")
    public List<GetClientDTO> findAll() {
        return this.service.findAll();
    }

    @GetMapping("{id}")
    public Optional<Client> findById(@PathVariable int id) {
        return service.findById(id);
    }

    @GetMapping("/name/{name}")
    public Optional<Client> findByNom(@PathVariable String name) {
        return service.findByNom(name);
    }


    @PostMapping
    public Client save(@RequestBody Client client) {
        return service.save(client);
    }

    @DeleteMapping
    public void delete(@RequestBody Client client) {
        service.delete(client.getId());
    }
}
