package com.example.demo.service;

import com.projetStage.projetStage.exceptions.LigneCommandeException;
import com.example.demo.model.LigneCommande;
import com.example.demo.repo.LigneCommandeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class LigneCommandeService {
    private final LigneCommandeRepo ligneCommandeRepo;
    @Autowired
    public LigneCommandeService(LigneCommandeRepo ligneCommandeRepo) {
        this.ligneCommandeRepo = ligneCommandeRepo;
    }
    public LigneCommande ajouterLigneCommande(LigneCommande ligneCommande){
        return ligneCommandeRepo.save(ligneCommande);
    }
    public LigneCommande modifierLigneCommande(LigneCommande ligneCommande){
        return ligneCommandeRepo.save(ligneCommande);

    }
    public  void supprimerLigneCommande(Long idLigneCommande){
        ligneCommandeRepo.deleteById(idLigneCommande);
    }
    public List<LigneCommande> selectionnerLigneCommandes(){
        return ligneCommandeRepo.findAll();
    }
    public LigneCommande selectionnerLigneCommande(Long idLigneCommande){
        return ligneCommandeRepo.findById(idLigneCommande).
                orElseThrow(()->new LigneCommandeException("la ligne de commande id :"+idLigneCommande+" n'existe pas !"));
    }
}
