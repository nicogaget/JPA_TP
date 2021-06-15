package com.tp.tp_spring_jpa_mysql.Controllers;

import com.tp.tp_spring_jpa_mysql.dtos.GetCategoryDTO;
import com.tp.tp_spring_jpa_mysql.models.Category;
import com.tp.tp_spring_jpa_mysql.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("categories")
public class CategoryController {
    @Autowired
    private CategoryService service;

    @GetMapping("")
    public List<GetCategoryDTO> findAll() {
        return this.service.findAll();
    }

    @GetMapping("{id}")
    public Optional<Category> findById(@PathVariable Long id) {
        return service.findById(Math.toIntExact(id));
    }

    @GetMapping("/name/{name}")
    public Optional<Category> findByNom(@PathVariable String name) {
        return service.findByNom(name);
    }

    @PostMapping
    public Category save(@RequestBody Category category) {
        return service.save(category);
    }

    @DeleteMapping
    public void delete(@RequestBody Category category) {
        service.delete(category.getId());
    }
}
