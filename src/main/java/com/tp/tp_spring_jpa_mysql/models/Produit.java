package com.tp.tp_spring_jpa_mysql.models;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="produit")
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private double prix;
    @ManyToOne
    @JoinColumn(name="category_id",referencedColumnName = "id")
    private Category category;
}
