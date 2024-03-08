package com.esmt.crud.service;

import com.esmt.crud.model.Produit;
import com.esmt.crud.repository.ProduitRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service // considérer cette classe comme étant du code métier
@AllArgsConstructor
public class ProduitServiceImpl implements ProduitService{

    // faire une injection par contructeur
    private final ProduitRepository produitRepository;
    @Override
    public Produit create(Produit produit) {
        return produitRepository.save(produit);
    }

    @Override
    public List<Produit> lire() {
        return produitRepository.findAll();
    }

    @Override
    public Produit modifier(Long id, Produit produit) {
        return produitRepository.findById(id)
                .map(p-> {
                    p.setPrix(produit.getPrix());
                    p.setNom(produit.getNom());
                    p.setDescription((produit.getDescription()));
                    return produitRepository.save(p);
                }).orElseThrow(()-> new RuntimeException("Product not found !"));
    }

    @Override
    public String supprimer(Long id) {
        produitRepository.deleteById(id);
        return "Product deleted !";
    }
}
