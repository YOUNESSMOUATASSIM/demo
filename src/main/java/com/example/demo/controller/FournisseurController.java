package com.example.demo.controller;

import com.example.demo.model.Fournisseur;
import com.example.demo.service.FournisseurService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Fournisseurs")
public class FournisseurController {
    private final FournisseurService fournisseurService;

    public FournisseurController(FournisseurService fournisseurService) {
        this.fournisseurService = fournisseurService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Fournisseur>> selectionnerFournisseurs() {
        List<Fournisseur> fournisseurList = fournisseurService.selectionnerFournisseurs();
        return new ResponseEntity<>(fournisseurList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fournisseur> selectionnerFournisseur(@PathVariable("id") Long id) {
        Fournisseur fournisseur = fournisseurService.selectionnerFournisseur(id);
        return new ResponseEntity<>(fournisseur, HttpStatus.OK);
    }

    @PostMapping("/ajouter")
    public ResponseEntity<Fournisseur> ajouterFournisseur(@RequestBody Fournisseur fournisseur) {
        Fournisseur fournisseur1 = fournisseurService.ajouterFournisseur(fournisseur);
        return new ResponseEntity<>(fournisseur1, HttpStatus.CREATED);
    }

    @PutMapping("/modifier/{id}")
    public ResponseEntity<Fournisseur> modifierFournisseur(@PathVariable("id") Long id,@RequestBody Fournisseur fournisseur) {

        return ResponseEntity.ok(fournisseurService.modifierFournisseur(id,fournisseur));
    }

    @DeleteMapping("/supprimer/{id}")
    public ResponseEntity<Fournisseur> supprimerFournisseur(@PathVariable("id") Long id) {
        fournisseurService.supprimerFournisseur(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}