package com.example.gestionlogistique.services;

import com.example.gestionlogistique.dtos.ProduitDTO;
import com.example.gestionlogistique.entities.Produit;
import com.example.gestionlogistique.entities.StockeProduit;

import java.util.List;

public interface ProduitService {
    List<StockeProduit> getAllProduits();

    ProduitDTO saveProduit(ProduitDTO produitDTO);

    ProduitDTO updateProduit(ProduitDTO produitDTO);

    void deleteProduit(Long produitId);

    ProduitDTO getProduitById(Long id);
}
