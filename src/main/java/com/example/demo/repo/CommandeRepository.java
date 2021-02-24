package com.example.demo.repo;

import com.example.demo.model.Commande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeRepository extends JpaRepository<Commande,Long> {
}
