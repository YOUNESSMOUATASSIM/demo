package com.example.demo.service;


import com.example.demo.dto.UtilisateurDTO;
import com.example.demo.model.Administrateur;
import com.example.demo.model.Responsable;
import com.example.demo.model.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MyUserDetailsService implements UserDetailsService {


    private  final PasswordEncoder bcryptEncoder;
    private  final ResponsableService responsableService;
    private  final  AdministrateurService administrateurService;

    @Autowired
    public MyUserDetailsService(@Lazy PasswordEncoder bcryptEncoder, ResponsableService responsableService, AdministrateurService administrateurService) {

        this.bcryptEncoder = bcryptEncoder;
        this.responsableService = responsableService;
        this.administrateurService = administrateurService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Utilisateur user=null ;

          
            user = responsableService.selectionnerResponsableName(username);
        if(user ==null){
            user = administrateurService.selectionnerAdministrateurName(username);
        }

           




        if (user == null) {
            throw new UsernameNotFoundException("n'existe aucun utilisateur avec username : " + username);
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                new ArrayList<>());
    }

    public Utilisateur saveResponsable(UtilisateurDTO user) {
        Responsable newUser = new Responsable();
        newUser.setEmail(user.getEmail());
        newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
        newUser.setUsername(user.getUsername());
        newUser.setCin(user.getCin());
        newUser.setRib(user.getRib());
        newUser.setEtat(true);
        return responsableService.ajouterResponsable(newUser);
    }
    public Utilisateur saveAdmin(UtilisateurDTO user) {
        Administrateur newUser = new Administrateur();
        newUser.setEmail(user.getEmail());
        newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
        newUser.setUsername(user.getUsername());
        newUser.setCin(user.getCin());
        newUser.setRib(user.getRib());
        newUser.setEtat(true);
        return administrateurService.ajouterAdministrateur(newUser);
    }
}
