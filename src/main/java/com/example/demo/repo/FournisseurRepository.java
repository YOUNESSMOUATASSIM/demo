package com.example.demo.repo;

import com.example.demo.model.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FournisseurRepository extends JpaRepository<Fournisseur,Long> {
}
