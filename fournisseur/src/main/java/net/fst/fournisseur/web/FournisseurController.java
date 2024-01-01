package net.fst.fournisseur.web;

import net.fst.fournisseur.entity.Fournisseur;
import net.fst.fournisseur.repository.FournisseurRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class FournisseurController {

    private FournisseurRepository fournisseurRepository;
    @GetMapping("/fournisseurs")
    public List<Fournisseur> allFournisseurs(){
        return fournisseurRepository.findAll();
    }
 }
