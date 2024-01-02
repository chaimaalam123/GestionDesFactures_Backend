package net.fst.commandeproduit.web;

import net.fst.commandeproduit.entities.LigneCommande;
import net.fst.commandeproduit.services.LigneCommandeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LigneCommandeController {
    LigneCommandeService ligneCommandeService ;

    public LigneCommandeController(LigneCommandeService ligneCommandeService) {
        this.ligneCommandeService = ligneCommandeService;
    }

    @GetMapping("/ligneCommande")
    public List<LigneCommande> findAll() {
        return ligneCommandeService.findAll();
    }
    @PostMapping("/ligneCommande")
    LigneCommande save(@RequestBody LigneCommande ligneCommande) {
        return  ligneCommandeService.save(ligneCommande);
    }

    @GetMapping("/ligneCommande/{id}")
    public List<LigneCommande> findByIdCommande(@PathVariable Long id) {
        return ligneCommandeService.ListProduitByIdCommande(id);
    }

}
