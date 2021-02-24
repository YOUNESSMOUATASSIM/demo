package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false,updatable = false)
    private Long idClient;
    private String nom;
    private String prenom;
    private String cin;
    private int rib;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "idResonsable", referencedColumnName = "idUser")
    private Responsable responsable;

    @OneToMany(fetch = LAZY)
    private List<Commande> commandesList = new ArrayList<>();



}
