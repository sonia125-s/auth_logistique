package com.example.gestionutilisateur_service.dto;

import com.example.gestionutilisateur_service.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserCredentialDTO {
    private Long id ;
    private  String username ;
    private  String email ;
    private  String password ;
    private Role role;
}
