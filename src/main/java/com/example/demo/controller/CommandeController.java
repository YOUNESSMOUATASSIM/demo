package com.example.demo.controller;

import com.example.demo.model.Client;
import com.example.demo.model.Commande;
import com.example.demo.service.CommandeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Commandes")
public class CommandeController {
    private final CommandeService commandeService;

    public CommandeController(CommandeService commandeService) {
        this.commandeService = commandeService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Commande>> selectionnerCommandes(){
        List<Commande> commandeList=commandeService.selectionnerCommandes();
        return new ResponseEntity<>(commandeList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Commande> selectionnerCommande(@PathVariable("id") Long id){
        Commande commande =commandeService.selectionnerCommande(id);
        return new ResponseEntity<>(commande,HttpStatus.OK);
    }

    @PostMapping("/ajouter")
    public ResponseEntity<Commande> ajouterCommande(@RequestBody Commande commande){
        Commande commande1=commandeService.ajouterCommande(commande);
        return new ResponseEntity<>(commande1,HttpStatus.CREATED);
    }

    @PutMapping("/modifier/{id}")
    public ResponseEntity<Commande> modifierCommande(@PathVariable("id") Long id,@RequestBody Commande commande){

        return ResponseEntity.ok(commandeService.modifierCommande(id,commande));
    }
    @DeleteMapping("/supprimer/{id}")
    public ResponseEntity<Commande> supprimerCommande(@PathVariable("id") Long id){
        commandeService.supprimerCommande(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
