package net.fst.commandeproduit.services;

import net.fst.commandeproduit.entities.Produit;

import java.util.List;

public interface ProduitService {

    public List<Produit> findAllProduits();
    public Produit findById(Long id);
    public Produit findByDesignation(String designation);

    public Produit saveProduit(Produit produit);
    public Produit updateProduit (Produit produit , Long id);
    public void deleteProduitById(Long id);

}
