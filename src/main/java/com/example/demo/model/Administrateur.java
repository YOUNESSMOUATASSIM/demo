package com.example.demo.model;

import com.example.demo.model.Utilisateur;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Administrateur extends Utilisateur {

    @OneToMany(fetch = LAZY)
    private List<Responsable> responsableList = new ArrayList<>();

    public Administrateur(Long id,String email,String username,String cin,int rib,String password,boolean etat,List<Responsable> l){
        super(id,email,username,cin,rib,password,etat);
        this.responsableList=l;
    }

}
