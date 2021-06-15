package com.tp.tp_spring_jpa_mysql.repositories;

import com.tp.tp_spring_jpa_mysql.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Optional<Category> findByNom(String Name);
}
