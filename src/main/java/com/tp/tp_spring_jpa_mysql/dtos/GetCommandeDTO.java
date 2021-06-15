package com.tp.tp_spring_jpa_mysql.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class GetCommandeDTO {

    private GetClientDTO client;
    private List<GetProduitDTO> produits;

}
