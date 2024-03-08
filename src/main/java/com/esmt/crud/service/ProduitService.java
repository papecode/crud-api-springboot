package com.esmt.crud.service;

import com.esmt.crud.model.Produit;

import java.util.List;

public interface ProduitService {

    Produit create(Produit produit);

    List<Produit> lire();
// Prend en parametre l'id du prdui et le produit à modifier
    Produit modifier(Long id, Produit produit);

    String supprimer(Long id);
}
