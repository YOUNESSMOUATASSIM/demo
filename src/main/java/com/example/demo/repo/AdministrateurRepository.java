package com.example.demo.repo;

import com.example.demo.model.Administrateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdministrateurRepository extends JpaRepository<Administrateur, Long> {


    Optional<Administrateur> findByEmail(String email);



    Administrateur findByUsername(String username);
}
