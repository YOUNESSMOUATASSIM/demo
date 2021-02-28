package com.example.demo.controller;

import com.example.demo.model.Produit;
import com.example.demo.service.ProduitService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Produits")
public class ProduitController {
    private final ProduitService produitService;

    public ProduitController(ProduitService produitService) {
        this.produitService = produitService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Produit>> selectionnerProduits(){
        List<Produit> produitList=produitService.selectionnerProduits();
        return new ResponseEntity<>(produitList, HttpStatus.OK);
    }

    @GetMapping("/trouve/{id}")
    public ResponseEntity<Produit> selectionnerProduit(@PathVariable("id") Long id){
        Produit produit =produitService.selectionnerProduit(id);
        return new ResponseEntity<>(produit,HttpStatus.OK);
    }

    @PostMapping("/ajouter")
    public ResponseEntity<Produit> ajouterProduit(@RequestBody Produit produit){
        Produit produit1=produitService.ajouterProduit(produit);
        return new ResponseEntity<>(produit1,HttpStatus.CREATED);
    }

    @PutMapping("/modifier/{id}")
    public ResponseEntity<Produit> modifierProduit(@PathVariable("id") Long id,@RequestBody Produit produit){
        return  ResponseEntity.ok(produitService.modifierProduit(id,produit));
    }
    @DeleteMapping("/supprimer/{id}")
    public ResponseEntity<Produit> supprimerProduit(@PathVariable("id") Long id){
        produitService.supprimerProduit(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
