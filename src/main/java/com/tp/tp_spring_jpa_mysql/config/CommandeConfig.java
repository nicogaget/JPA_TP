package com.tp.tp_spring_jpa_mysql.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tp.tp_spring_jpa_mysql.repositories.CommandeRepository;
import com.tp.tp_spring_jpa_mysql.services.CommandeService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommandeConfig {
    @Bean
    public CommandeService commandeService(CommandeRepository repository, ObjectMapper mapper){
        return new CommandeService(repository,mapper);
    }
}
