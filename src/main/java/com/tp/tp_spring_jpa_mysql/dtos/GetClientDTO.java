package com.tp.tp_spring_jpa_mysql.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GetClientDTO {
    private String nom;
    private String Prenom;
}
