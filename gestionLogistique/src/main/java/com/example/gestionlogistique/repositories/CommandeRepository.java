package com.example.gestionlogistique.repositories;

import com.example.gestionlogistique.entities.CommandeClient;
import com.example.gestionlogistique.enums.EnumEtat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CommandeRepository extends JpaRepository<CommandeClient,Long> {
    List<CommandeClient> findByClient_Id(Long clientId);
    List<CommandeClient> findByEtat(EnumEtat etat);



}
