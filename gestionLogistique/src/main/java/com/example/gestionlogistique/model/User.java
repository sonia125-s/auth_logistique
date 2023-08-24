package com.example.gestionlogistique.model;

import com.example.gestionlogistique.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private  Long id;
    private String nom ;
    private String email;

    private Role role;
}
