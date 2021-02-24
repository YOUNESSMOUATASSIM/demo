package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public   class  Utilisateur implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false,updatable = false)
    protected Long idUser;
    @Email
    @NotEmpty(message = "Email est necessaire")
    protected String email;
    protected String nom;
    protected String prenom;
    protected String cin;
    protected int rib;
    @NotBlank(message = "Password est necessaire")
    protected String password;
    protected boolean etat;
}
