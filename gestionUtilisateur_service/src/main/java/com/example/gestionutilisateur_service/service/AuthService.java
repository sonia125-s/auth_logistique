package com.example.gestionutilisateur_service.service;

import com.example.gestionutilisateur_service.dto.UserCredentialDTO;
import com.example.gestionutilisateur_service.dto.requests.AuthRequest;
import com.example.gestionutilisateur_service.entities.UserCredential;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AuthService {

    String generateToken(UserCredential userDetails, List<String> roles);

    void validateToken(String token);

    UserCredential saveUser(UserCredentialDTO credential);

    String authenticate(AuthRequest authRequest);

}
