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
}
