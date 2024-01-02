package net.fst.commandeproduit.web;


import net.fst.commandeproduit.entities.Produit;
import net.fst.commandeproduit.fournisseurs.FournisseurRestClient;
import net.fst.commandeproduit.services.ProduitService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ProduitController {

    private ProduitService produitService;

    private FournisseurRestClient fournisseurRestClient;

    public ProduitController(ProduitService produitService, FournisseurRestClient fournisseurRestClient) {
        this.produitService = produitService;
        this.fournisseurRestClient = fournisseurRestClient;
    }

    @GetMapping("/produits")
    public List<Produit> getProducts(){
        List<Produit> produits = produitService.findAllProduits();
        produits.forEach(p->{
            p.setFournisseur(fournisseurRestClient.findFournisseurById(p.getFourniseurId()));
        });
        return produits;
    }
    @GetMapping("/produits/{id}")
    public Produit produitById (@PathVariable Long id){
        Produit produit = produitService.findById(id);
        produit.setFournisseur(fournisseurRestClient.findFournisseurById(produit.getFourniseurId()));
        return produit;
    }
    @GetMapping("/produitsD/{designation}")
    public Produit produitByDesignation (@PathVariable String designation){
        Produit produit = produitService.findByDesignation(designation);
        produit.setFournisseur(fournisseurRestClient.findFournisseurById(produit.getFourniseurId()));
        return produit;
    }
    @PostMapping("/produits")
    public Produit saveCommande(@RequestBody Produit produit){

        return produitService.saveProduit(produit);
    }

    @PutMapping("/produits/{id}")
    public Produit updateCommande(@RequestBody Produit produit, @PathVariable Long id){
        return produitService.updateProduit(produit,id);
    }
    @DeleteMapping("/produits/{id}")
    public void deleteCommande(@PathVariable Long id){

        produitService.deleteProduitById(id);
    }
}


