package com.example.demo.service;


import com.projetStage.projetStage.exceptions.AdministrateurException;
import com.example.demo.model.Administrateur;
import com.example.demo.repo.AdministrateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AdministrateurService {
    private final AdministrateurRepository administrateurRepository;

   // private final PasswordEncoder bcryptEncode;



    @Autowired
    public AdministrateurService(  AdministrateurRepository administrateurRepository) {
        this.administrateurRepository = administrateurRepository;


    }

    public Administrateur ajouterAdministrateur(Administrateur administrateur){
        return administrateurRepository.save(administrateur);
    }
    public Administrateur modifierAdministrateur(Administrateur administrateur){

        return administrateurRepository.save(administrateur);

    }
    public Administrateur modifierAdministrateur(Long id,Administrateur userupdate){

        Administrateur user= administrateurRepository.getOne(id);
        user.setUsername(userupdate.getUsername());
        user.setEmail(userupdate.getEmail());
        user.setPassword(userupdate.getPassword());
        user.setUsername(userupdate.getUsername());
        user.setCin(userupdate.getCin());
        user.setRib(userupdate.getRib());
        user.setEtat(true);
        return administrateurRepository.save(user);


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
    public Administrateur selectionnerAdministrateurName(String username) {
        return administrateurRepository.findByUsername(username);
    }


}
