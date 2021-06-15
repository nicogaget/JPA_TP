package com.tp.tp_spring_jpa_mysql.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tp.tp_spring_jpa_mysql.repositories.ClientRepository;
import com.tp.tp_spring_jpa_mysql.services.ClientService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClientsConfig {
    @Bean
    public ClientService clientService(ClientRepository repository, ObjectMapper mapper){
        return new ClientService(repository, mapper);
    }

}
