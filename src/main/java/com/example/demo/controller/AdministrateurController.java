package com.example.demo.controller;


import com.example.demo.dto.UtilisateurDTO;
import com.example.demo.model.Administrateur;
import com.example.demo.service.AdministrateurService;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/Admin")
public class AdministrateurController {
    private final AdministrateurService administrateurService;
    private PasswordEncoder bcryptEncoder;

    public AdministrateurController(AdministrateurService administrateurService,PasswordEncoder bcryptEncoder) {
        this.administrateurService = administrateurService;


        this.bcryptEncoder = bcryptEncoder;
    }



    @GetMapping("/all")
    public ResponseEntity<List<Administrateur>> selectionnerAdministrateures() {
        List<Administrateur> adminList = administrateurService.selectionnerAdministrateurs();
        return new ResponseEntity<>(adminList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
        public ResponseEntity<Administrateur> selectionnerAdminstrateur(@PathVariable("id") Long id) {
        Administrateur admin = administrateurService.selectionnerAdministrateur(id);
        return new ResponseEntity<>(admin, HttpStatus.OK);
    }

    @PostMapping("/ajouter")
    public ResponseEntity<Administrateur> ajouterAdministrateur(@RequestBody Administrateur administrateur) {
        administrateur.setPassword(bcryptEncoder.encode(administrateur.getPassword()));
        Administrateur administrateur1 = administrateurService.ajouterAdministrateur(administrateur);
        return new ResponseEntity<>(administrateur1, HttpStatus.CREATED);
    }

    /*@PutMapping("/modifier/{id}")
    public ResponseEntity<Administrateur> modifierAdministrateur(@RequestBody Administrateur administrateur) {
        administrateur.setPassword(bcryptEncoder.encode(administrateur.getPassword()));
        Administrateur administrateur2 = administrateurService.modifierAdministrateur(administrateur);
        return new ResponseEntity<>(administrateur2, HttpStatus.OK);
    }*/
    @PutMapping("/modifier/{id}")
    public ResponseEntity<Administrateur> modifierAdministrateur(@PathVariable("id") Long id,@RequestBody Administrateur administrateur){
        administrateur.setPassword(bcryptEncoder.encode(administrateur.getPassword()));

        return ResponseEntity.ok(administrateurService.modifierAdministrateur(id,administrateur));
    }

    @DeleteMapping("/supprimer/{id}")
    public ResponseEntity<Administrateur> supprimerAdministrateur(@PathVariable("id") Long id) {
        administrateurService.supprimerAdministrateur(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
