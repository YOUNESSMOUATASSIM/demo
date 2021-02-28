package com.example.demo.controller;


import com.example.demo.model.Responsable;
import com.example.demo.service.ResponsableService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Responsables")
public class ResponsableController {
    private final ResponsableService responsableService;

    public ResponsableController(ResponsableService responsableService) {
        this.responsableService = responsableService;

    }

    @GetMapping("/all")
    public ResponseEntity<List<Responsable>> selectionnerResponsables() {
        List<Responsable> responsableList = responsableService.selectionnerResponsables();
        return new ResponseEntity<>(responsableList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Responsable> selectionnerResponsable(@PathVariable("id") Long id) {
        Responsable responsable = responsableService.selectionnerResponsable(id);
        return new ResponseEntity<>(responsable, HttpStatus.OK);
    }

    @PostMapping("/ajouter")
    public ResponseEntity<Responsable> ajouterResponsable(@RequestBody Responsable responsable) {
        Responsable responsable1 = responsableService.ajouterResponsable(responsable);
        return new ResponseEntity<>(responsable1, HttpStatus.CREATED);
    }

    @PutMapping("/modifier/{id}")
    public ResponseEntity<Responsable> modifierResponsable(@RequestBody Responsable responsable) {
        Responsable responsable2 = responsableService.modifierResponsable(responsable);
        return new ResponseEntity<>(responsable2, HttpStatus.OK);
    }

    @DeleteMapping("/supprimer/{id}")
    public ResponseEntity<Responsable> supprimerResponsable(@PathVariable("id") Long id) {
        responsableService.supprimerResponsable(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}