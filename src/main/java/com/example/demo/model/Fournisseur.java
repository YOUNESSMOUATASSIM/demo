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
public class Fournisseur {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false,updatable = false)
    private Long idFournisseur;
    private String nom;
    private String prenom;
    private String adresse;
    private String cin;


    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "idResonsable", referencedColumnName = "idUser")
    private Responsable responsable;

    @OneToMany(fetch = LAZY)
    private List<Produit> produitsList = new ArrayList<>();
}
