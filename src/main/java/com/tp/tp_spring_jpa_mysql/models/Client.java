package com.tp.tp_spring_jpa_mysql.models;


import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "client")
public class Client {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    private String nom;
    private String prenom;


}
