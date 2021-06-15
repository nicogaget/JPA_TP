package com.tp.tp_spring_jpa_mysql.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tp.tp_spring_jpa_mysql.repositories.ProduitRepository;
import com.tp.tp_spring_jpa_mysql.services.ProduitService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProduitConfig {
    @Bean
    public ProduitService produitService(ProduitRepository repository, ObjectMapper mapper){
        return new ProduitService(repository, mapper);
    }
}
