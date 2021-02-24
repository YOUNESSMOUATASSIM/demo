package com.example.demo.service;

import com.projetStage.projetStage.exceptions.AdministrateurException;
import com.example.demo.model.Administrateur;
import com.example.demo.repo.AdministrateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AdministrateurService {
    private final AdministrateurRepository administrateurRepository;
    @Autowired
    public AdministrateurService(AdministrateurRepository administrateurRepository) {
        this.administrateurRepository = administrateurRepository;
    }

    public Administrateur ajouterAdministrateur(Administrateur administrateur){
        return administrateurRepository.save(administrateur);
    }
    public Administrateur modifierAdministrateur(Administrateur administrateur){
        return administrateurRepository.save(administrateur);

    }
    public  void supprimerAdministrateur(Long idAdministrateur){
        administrateurRepository.deleteById(idAdministrateur);
    }
    public List<Administrateur> selectionnerAdministrateurs(){
        return administrateurRepository.findAll();
    }

    public Administrateur selectionnerAdministrateur(Long idAdministrateur){
        return administrateurRepository.findById(idAdministrateur).
                orElseThrow(()-> new AdministrateurException("l'administrateur id :"+idAdministrateur+" n'exite pas !"));
    }

    public Administrateur selectionnerAdministrateur(String email) {
        return (Administrateur) administrateurRepository.findByEmail(email).
                orElseThrow(()-> new AdministrateurException("l'administrateur avec email :"+email+" n'exite pas !"));
    }
}
