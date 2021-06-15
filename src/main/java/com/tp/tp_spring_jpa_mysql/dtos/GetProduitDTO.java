package com.tp.tp_spring_jpa_mysql.dtos;

import com.tp.tp_spring_jpa_mysql.models.Category;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GetProduitDTO {
    private String nom;
    private double prix;
    private Category category;
}
