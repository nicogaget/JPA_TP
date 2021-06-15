package com.tp.tp_spring_jpa_mysql.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class GetCommandeDTO {
    private int id;
    private List<GetProduitDTO> produits;

}
