package com.example.gestionutilisateur_service.service;


import com.example.gestionutilisateur_service.entities.UserCredential;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.Map;

public interface JwtService {
    void validateToken(final String token);

    String generateToken(UserCredential userDetails, List<String> roles);


}
