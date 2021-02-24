package com.example.demo.service;

import com.projetStage.projetStage.exceptions.FournisseurException;

import com.example.demo.model.Fournisseur;
import com.example.demo.repo.FournisseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class FournisseurService {
    private  final FournisseurRepository fournisseurRepository;
    @Autowired
    public FournisseurService(FournisseurRepository fournisseurRepository) {
        this.fournisseurRepository = fournisseurRepository;
    }

    public Fournisseur ajouterFournisseur(Fournisseur fournisseur){
        return fournisseurRepository.save(fournisseur);
    }
    public Fournisseur modifierFournisseur(Fournisseur fournisseur){
        return fournisseurRepository.save(fournisseur);

    }
    public  void supprimerFournisseur(Long idFournisseur){
        fournisseurRepository.deleteById(idFournisseur);
    }
    public List<Fournisseur> selectionnerFournisseurs(){
        return fournisseurRepository.findAll();
    }
    public Fournisseur selectionnerFournisseur(Long idFournisseur){
        return fournisseurRepository.findById(idFournisseur).
                orElseThrow(()->new FournisseurException("le fournisseur id :"+idFournisseur+" n'existe pas !"));
    }
}
