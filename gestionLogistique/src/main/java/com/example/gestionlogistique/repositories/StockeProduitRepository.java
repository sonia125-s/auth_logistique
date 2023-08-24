package com.example.gestionlogistique.repositories;

import com.example.gestionlogistique.entities.StockeProduit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockeProduitRepository extends JpaRepository<StockeProduit,Long> {
}
