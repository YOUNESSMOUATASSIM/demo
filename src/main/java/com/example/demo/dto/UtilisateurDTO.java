package com.example.demo.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class UtilisateurDTO {
        private String email;
        private String password;

        private String username;
        private String cin;
        private int rib;
        private boolean etat;



}
