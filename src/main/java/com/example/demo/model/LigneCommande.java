package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class LigneCommande {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false,updatable = false)
    private Long idLigneCommande;
    private double quantiteCommande;
    private double totale;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "idCommande", referencedColumnName = "idCommande")
    private Commande commande;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "idProduit", referencedColumnName = "idProduit")
    private Produit produit;
}
