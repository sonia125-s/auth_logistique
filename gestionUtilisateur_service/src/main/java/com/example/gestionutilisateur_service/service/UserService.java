package com.example.gestionutilisateur_service.service;

import com.example.gestionutilisateur_service.dto.UserCredentialDTO;
import com.example.gestionutilisateur_service.dto.UserLogin;
import com.example.gestionutilisateur_service.entities.UserCredential;
import com.example.gestionutilisateur_service.enums.Role;

import java.util.List;

public interface UserService {


    List<UserCredentialDTO> getTransporteurs(Role role);

    UserCredentialDTO getUser(Long id);

    UserCredential addUser(UserCredential userCredential);

    void deleteUser(Long id);

    UserCredential updateUser(UserCredential userCredential);

    List<UserCredential> getAll();

    UserCredential login(UserLogin userLogin);
     UserCredential loadUserByUsername(String username);

    List<UserCredential> getAllUser();
}
