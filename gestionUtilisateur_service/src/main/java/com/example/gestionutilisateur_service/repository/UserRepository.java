package com.example.gestionutilisateur_service.repository;

import com.example.gestionutilisateur_service.entities.UserCredential;
import com.example.gestionutilisateur_service.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.*;
@Repository
public interface UserRepository extends JpaRepository<UserCredential,Long> {
    List<UserCredential> findByRoles(Role role);
    Optional<UserCredential> findByUsername(String username);
    UserCredential findByEmail(String username);

}
