package com.example.demo.service;

import com.projetStage.projetStage.exceptions.ProduitException;
import com.example.demo.model.Produit;
import com.example.demo.repo.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduitService {
    private final ProduitRepository produitRepository;

    @Autowired
    public ProduitService(ProduitRepository produitRepository) {
        this.produitRepository = produitRepository;
    }
    public Produit ajouterProduit(Produit produit){
        return produitRepository.save(produit);
    }
    public Produit modifierProduit(Produit produit){
        return produitRepository.save(produit);

    }
    public  void supprimerProduit(Long idProduit){
        produitRepository.deleteById(idProduit);
    }
    public List<Produit> selectionnerProduits(){
        return produitRepository.findAll();
    }
    public Produit selectionnerProduit(Long idProduit){
        return produitRepository.findById(idProduit).
                orElseThrow(()->new ProduitException("le produit id :"+idProduit+" n'exite pas  !"));
    }

    public Produit modifierProduit(Long id, Produit produit) {
        Produit oldProduit =produitRepository.getOne(id);

        oldProduit.setDateProduction(produit.getDateProduction());
        oldProduit.setDateExperation(produit.getDateExperation());
        oldProduit.setLibelle(produit.getLibelle());
        oldProduit.setQuantiteUnitaire(produit.getQuantiteUnitaire());
        oldProduit.setResponsable(produit.getResponsable());
        oldProduit.setLigneCommandesList(produit.getLigneCommandesList());
        oldProduit.setPrixUnitaire(produit.getPrixUnitaire());
        oldProduit.setFournisseur(produit.getFournisseur());
        return produitRepository.save(oldProduit);
    }
}
