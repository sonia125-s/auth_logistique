package com.example.gestionlogistique.services.implementation;

import com.example.gestionlogistique.dtos.ProduitDTO;
import com.example.gestionlogistique.entities.Produit;
import com.example.gestionlogistique.entities.StockeProduit;
import com.example.gestionlogistique.mappers.ClientMapper;
import com.example.gestionlogistique.repositories.ProduitRepository;
import com.example.gestionlogistique.repositories.StockeProduitRepository;
import com.example.gestionlogistique.services.ProduitService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProduitServiceImpl  implements ProduitService {
    @Autowired
    private ProduitRepository produitRepository;
    @Autowired
    private ClientMapper clientMapper;
    @Autowired
    private StockeProduitRepository stockeProduitRepository;

    /*@Override
    public List<ProduitDTO> getAllProduits(){
        List<Produit> produitList=  produitRepository.findAll();
        return  produitList.stream().map(produit ->clientMapper.fromProduit(produit) ).collect(Collectors.toList());
    }*/
    /*@Override
    public ProduitDTO saveProduit(ProduitDTO produitDTO){
        Produit produit =clientMapper.fromProduitDTO(produitDTO);
        Produit saveProduit= produitRepository.save(produit);
        return clientMapper.fromProduit(saveProduit);
    }
    @Override
    public ProduitDTO updateProduit(ProduitDTO produitDTO){
        Produit produit=clientMapper.fromProduitDTO(produitDTO);
        Produit saveProduit = produitRepository.save(produit);
        return  clientMapper.fromProduit(saveProduit);
    }
    @Override
    public void deleteProduit(Long produitId){
        produitRepository.deleteById(produitId);;
    }
    @Override
    public ProduitDTO getProduitById(Long id){
        Produit produit=produitRepository.findById(id).orElse(null);
        return clientMapper.fromProduit(produit);

    }*/
    //****************************************
    @Override
    public List<StockeProduit> getAllProduits(){
        return   stockeProduitRepository.findAll();
    }
    @Override
    public ProduitDTO saveProduit(ProduitDTO produitDTO){
        StockeProduit stockeProduit =clientMapper.fromStockeProduitDTO(produitDTO);
        StockeProduit saveProduit= stockeProduitRepository.save(stockeProduit);
        return clientMapper.fromStockeProduit(saveProduit);
    }
    @Override
    public ProduitDTO updateProduit(ProduitDTO produitDTO){
        StockeProduit stockeProduit =clientMapper.fromStockeProduitDTO(produitDTO);
        StockeProduit saveProduit= stockeProduitRepository.save(stockeProduit);
        return clientMapper.fromStockeProduit(saveProduit);
    }
    @Override
    public void deleteProduit(Long produitId){
        stockeProduitRepository.deleteById(produitId);
    }
    @Override
    public ProduitDTO getProduitById(Long id){
        StockeProduit produit=stockeProduitRepository.findById(id).orElse(null);
        return clientMapper.fromStockeProduit(produit);

    }

}
