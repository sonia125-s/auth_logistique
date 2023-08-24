package com.example.gestionlogistique.repositories;

import com.example.gestionlogistique.entities.Transport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransportRepository extends JpaRepository<Transport,Long> {
}
