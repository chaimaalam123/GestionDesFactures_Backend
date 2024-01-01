package net.fst.produit.web;

import net.fst.produit.entity.Produit;
import net.fst.produit.fournisseurs.FournisseurRestClient;
import net.fst.produit.repository.ProduitRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProduitController {

    private ProduitRepository produitRepository;
    private FournisseurRestClient fournisseurRestClient;

    public ProduitController(ProduitRepository produitRepository, FournisseurRestClient fournisseurRestClient) {
        this.produitRepository = produitRepository;
        this.fournisseurRestClient = fournisseurRestClient;
    }

    @GetMapping("/produits")
    public List<Produit> getProducts(){

        return produitRepository.findAll();
    }
    @GetMapping("/produits/{id}")
    public Produit produitById (@PathVariable Long id){
        Produit produit = produitRepository.findById(id).get();
        produit.setFournisseur(fournisseurRestClient.findFournisseurById(produit.getId()));
        return produit;
    }
    @PostMapping("/produits")
    public Produit saveCommande(@RequestBody Produit produit){

        return produitRepository.save(produit);
    }

    @PutMapping("/produits/{id}")
    public Produit updateCommande(@RequestBody Produit produit, @PathVariable Long id){
        produit.setId(id);
        return produitRepository.save(produit);
    }
    @DeleteMapping("/produits/{id}")
    public void deleteCommande(@PathVariable Long id){

        produitRepository.deleteById(id);
    }
}


