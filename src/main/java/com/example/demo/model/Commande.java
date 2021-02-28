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
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false,updatable = false)
    private Long idCommande;
    @NotEmpty(message = "Date commande est necessaire ")
    private Date dateCommande;
    @NotEmpty(message = "Quantite commande est necessaire")
    private double quantite;
    @NotEmpty(message = "Prix commande est necessaire")
    private double prix;
    public double prixCommande(List<LigneCommande> listeligneCommande){

        for (LigneCommande l: listeligneCommande) {
            this.prix+=l.totaleLigneCommande(l.getProduit());
        }
        return this.prix;
    }

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "idClient", referencedColumnName = "idClient")
    private Client client;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "idResponsable", referencedColumnName = "idUser")
    private Responsable responsable;

    @OneToMany(fetch = LAZY)
    private List<LigneCommande> lignesCommandeList = new ArrayList<>();
}
