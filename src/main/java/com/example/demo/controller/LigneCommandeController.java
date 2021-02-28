package com.example.demo.controller;

import com.example.demo.model.Commande;
import com.example.demo.model.LigneCommande;
import com.example.demo.service.LigneCommandeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/LigneCommandes")
public class LigneCommandeController {
    private  final LigneCommandeService ligneCommandeService;

    public LigneCommandeController(LigneCommandeService ligneCommandeService) {
        this.ligneCommandeService = ligneCommandeService;
    }
    @GetMapping("/all")
    public ResponseEntity<List<LigneCommande>> selectionnerLignesCommande(){
        List<LigneCommande> ligneCommandeList=ligneCommandeService.selectionnerLigneCommandes();
        return new ResponseEntity<>(ligneCommandeList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LigneCommande> selectionnerLigneCommande(@PathVariable("id") Long id){
        LigneCommande ligneCommande =ligneCommandeService.selectionnerLigneCommande(id);
        return new ResponseEntity<>(ligneCommande,HttpStatus.OK);
    }

    @PostMapping("/ajouter")
    public ResponseEntity<LigneCommande> ajouterLigneCommande(@RequestBody LigneCommande ligneCommande){
        LigneCommande ligneCommande1=ligneCommandeService.ajouterLigneCommande(ligneCommande);
        return new ResponseEntity<>(ligneCommande1,HttpStatus.CREATED);
    }

    @PutMapping("/modifier/{id}")
    public ResponseEntity<LigneCommande> modifierLigneCommande(@PathVariable("id") Long id,@RequestBody LigneCommande ligneCommande){

        return ResponseEntity.ok(ligneCommandeService.modifierLigneCommande(id,ligneCommande));
    }
    @DeleteMapping("/supprimer/{id}")
    public ResponseEntity<LigneCommande> supprimerLigneCommande(@PathVariable("id") Long id){
        ligneCommandeService.supprimerLigneCommande(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
