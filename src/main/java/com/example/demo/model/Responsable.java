package com.example.demo.model;


import  com.example.demo.model.Administrateur;
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

public class Responsable extends Utilisateur {

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "idAdmin", referencedColumnName = "idUser")
    private Administrateur admin;

    @OneToMany(fetch = LAZY)
    private List<Client> clientsList = new ArrayList<>();

    @OneToMany(fetch = LAZY)
    private List<Fournisseur> fournisseursList = new ArrayList<>();

    @OneToMany(fetch = LAZY)
    private List<Commande> commandesList = new ArrayList<>();

    @OneToMany(fetch = LAZY)
    private List<Produit> produitsList = new ArrayList<>();


    public Responsable(Long id, String email, String nom, String prenom, String cin, int rib, String password, boolean etat, Administrateur admin,
                       List<Client> clientsList, List<Fournisseur> fournisseursList, List<Commande> commandesList,
                       List<Produit> produitsList){
        super(id,email,nom,prenom,cin,rib,password,etat);
        this.admin=admin;
        this.clientsList=clientsList;
        this.commandesList=commandesList;
        this.fournisseursList=fournisseursList;
        this.produitsList=produitsList;
    }

}
