package com.tp.tp_spring_jpa_mysql.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tp.tp_spring_jpa_mysql.dtos.GetCategoryDTO;
import com.tp.tp_spring_jpa_mysql.models.Category;
import com.tp.tp_spring_jpa_mysql.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CategoryService {


    private JpaRepository<Category, Integer> repository;
    private ObjectMapper mapper;

    public CategoryService(JpaRepository<Category, Integer> repository, ObjectMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Autowired
    CategoryRepository categoryRepository;

    public List<GetCategoryDTO> findAll() {
        List<Category> categories = this.repository.findAll();
        List<GetCategoryDTO> getCategoryDTOS = new ArrayList<>();
        categories.forEach(category -> {
            getCategoryDTOS.add(
                    this.mapper.convertValue(category, GetCategoryDTO.class)
            );

        });
        return getCategoryDTOS;
    }


    public Optional<Category> findById(int id) {
        return this.repository.findById(id);
    }

    public Optional<Category> findByNom(String name) {
        return this.categoryRepository.findByNom(name);
    }


    public Category save(Category entity) {
        return this.categoryRepository.save(entity);
    }


    public Category update(String id, Category entity) {
        return this.categoryRepository.save(entity);
    }


    public void delete(int id) {
        this.categoryRepository.deleteById(id);
    }
}
