package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false,updatable = false)
    private Long idProduit;
    @NotEmpty(message = "libelle est necessaire")
    private String libelle;
    @NotEmpty(message = "prixUnitaire est necessaire")
    private double prixUnitaire;
    private double quantiteUnitaire;
    private Date dateProduction;
    private Date dateExperation;


    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "idResponsable", referencedColumnName = "idUser")
    private Responsable responsable;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "idFournisseur", referencedColumnName = "idFournisseur")
    private Fournisseur fournisseur;

    @OneToMany(fetch = LAZY)
    private List<LigneCommande> ligneCommandesList = new ArrayList<>();



}
