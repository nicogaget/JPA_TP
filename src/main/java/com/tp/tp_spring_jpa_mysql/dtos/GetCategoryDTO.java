package com.tp.tp_spring_jpa_mysql.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GetCategoryDTO {
    private int id;
    private String nom;
}
