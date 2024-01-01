package net.fst.produit.web;


import jakarta.persistence.GeneratedValue;
import net.fst.produit.entity.Produit;
import net.fst.produit.repository.ProduitRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class ProduitController {

    private ProduitRepository produitRepository;

    @GetMapping("/prduits")
    public List<Produit> getProducts(){
        return produitRepository.findAll();
    }

}
