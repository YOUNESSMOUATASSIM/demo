package com.example.demo.repo;

import com.example.demo.model.LigneCommande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LigneCommandeRepo extends JpaRepository<LigneCommande,Long> {
}
