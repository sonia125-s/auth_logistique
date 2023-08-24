package com.example.gestionlogistique.web;

import com.example.gestionlogistique.dtos.ProduitDTO;
import com.example.gestionlogistique.entities.Produit;
import com.example.gestionlogistique.entities.StockeProduit;
import com.example.gestionlogistique.services.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
public class ProduitAPI {
    @Autowired
    private ProduitService produitService;

    @GetMapping("/logistiques/produits")
    public List<StockeProduit> getAllProduits(){

        return  produitService.getAllProduits();
    }
    @GetMapping("logistiques/produitsDTO")
    public List<ProduitDTO>gett(){
        List<StockeProduit> list = produitService.getAllProduits();
        List<ProduitDTO> list1=new ArrayList<>();
        ProduitDTO produitDTO=new ProduitDTO();
        for(StockeProduit stockeProduit: list){
            produitDTO.setId(stockeProduit.getId());
            produitDTO.setPrix(stockeProduit.getPrix());
            produitDTO.setDescription(stockeProduit.getDescription());
            list1.add(produitDTO);
        }
        return list1;
    }
    @PostMapping("logistiques/produits")
    public ProduitDTO saveProduit(@RequestBody ProduitDTO produitDTO){
        return produitService.saveProduit(produitDTO);
    }

    @DeleteMapping("logistiques/produits/{id}")
    public  void deleteProduit (@PathVariable Long id){
        produitService.deleteProduit(id);
    }
    @GetMapping("logistiques/produit/{id}")
    public ProduitDTO getProduitById(@PathVariable Long id){
        return produitService.getProduitById(id);
    }
    @PutMapping("logistiques/produitt/{id}")
    public ProduitDTO updateProduit(@PathVariable Long id , @RequestBody ProduitDTO produitDTO){
        produitDTO.setId(id);
        return produitService.updateProduit(produitDTO);
    }

}
