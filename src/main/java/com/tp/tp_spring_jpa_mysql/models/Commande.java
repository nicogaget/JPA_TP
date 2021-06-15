package com.tp.tp_spring_jpa_mysql.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;


@Data
@Entity
@Table(name = "commande")
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private Client client;
    @ManyToMany
    @JoinTable(
            name = "commande_has_produit",
            joinColumns = {@JoinColumn(name = "commande_id")},
            inverseJoinColumns = {@JoinColumn(name = "produit_id")}
    )
    private List<Produit> produits;
}
