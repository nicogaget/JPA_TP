package com.tp.tp_spring_jpa_mysql.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tp.tp_spring_jpa_mysql.repositories.CategoryRepository;
import com.tp.tp_spring_jpa_mysql.services.CategoryService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CategoryConfig {
    @Bean
    public CategoryService categoryService(CategoryRepository repository, ObjectMapper mapper){
        return new CategoryService(repository, mapper);
    }

}
