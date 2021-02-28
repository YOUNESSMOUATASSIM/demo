package com.example.demo.repo;
import com.example.demo.model.Responsable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ResponsableRepository extends JpaRepository<Responsable,Long> {


    Responsable findByUsername(String username);
}
