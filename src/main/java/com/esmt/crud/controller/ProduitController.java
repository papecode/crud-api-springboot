package com.esmt.crud.controller;

import com.esmt.crud.model.Produit;
import com.esmt.crud.service.ProduitService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produit")
@AllArgsConstructor
public class ProduitController {
// inversion de contrôle
    private final ProduitService produitService;
    @PostMapping("/create")
    public Produit create(@RequestBody Produit produit) {
        return produitService.create(produit);
    }

    @GetMapping("/read")
    public List<Produit> read() {
        return produitService.lire();
    }

    @PutMapping("/update/{id}")
    public Produit update(@PathVariable Long id, @RequestBody Produit produit) {
        return produitService.modifier(id, produit);
    }
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        return produitService.supprimer(id);
    }

}
