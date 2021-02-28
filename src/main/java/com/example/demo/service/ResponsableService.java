package com.example.demo.service;


import com.example.demo.model.Administrateur;
import com.projetStage.projetStage.exceptions.ResponsableException;
import com.example.demo.model.Responsable;
import com.example.demo.repo.ResponsableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ResponsableService {
    private final ResponsableRepository responsableRepository;

    @Autowired
    public ResponsableService(  ResponsableRepository responsableRepository, PasswordEncoder bcryptEncode) {
        this.responsableRepository = responsableRepository;

    }
    public Responsable ajouterResponsable(Responsable responsable){
        return responsableRepository.save(responsable);
    }
    public Responsable modifierResponsable(Responsable responsable){

        return responsableRepository.save(responsable);

    }
    public  void supprimerResponsable(Long idResponsable){
        responsableRepository.deleteById(idResponsable);
    }
    public List<Responsable> selectionnerResponsables(){
        return responsableRepository.findAll();
    }
    public Responsable selectionnerResponsable(Long idResponsable){
        return responsableRepository.findById(idResponsable).
                orElseThrow(()->new ResponsableException("le responsable id :"+idResponsable+"n'existe pas !"));
    }

    /*.
             orElseThrow(()->new ResponsableException("le responsable avec username :"+username+" n'existe pas !"))*/
    public Responsable selectionnerResponsableName(String username) {
        return responsableRepository.findByUsername(username);

    }
    public Responsable modifierResponsable(Long id, Responsable userupdate){

        Responsable user= responsableRepository.getOne(id);
        user.setUsername(userupdate.getUsername());
        user.setEmail(userupdate.getEmail());
        user.setPassword(userupdate.getPassword());
        user.setUsername(userupdate.getUsername());
        user.setCin(userupdate.getCin());
        user.setRib(userupdate.getRib());
        user.setEtat(true);
        return responsableRepository.save(user);


    }


}
