package net.fst.fournisseur.web;

import net.fst.fournisseur.entity.Fournisseur;
import net.fst.fournisseur.repository.FournisseurRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class FournisseurController {

    private FournisseurRepository fournisseurRepository;

    public FournisseurController(FournisseurRepository fournisseurRepository) {
        this.fournisseurRepository = fournisseurRepository;
    }

    @GetMapping("/fournisseurs")
    public List<Fournisseur> allFournisseurs(){

        return fournisseurRepository.findAll();
    }

    @GetMapping("/fournisseurs/{id}")
    public Fournisseur fournisseurById (@PathVariable Long id){
        Fournisseur fournisseur = fournisseurRepository.findById(id).get();
        return fournisseur;
    }
    @PostMapping("/fournisseurs")
    public Fournisseur saveFournisseur(@RequestBody Fournisseur fournisseur){
        return fournisseurRepository.save(fournisseur);
    }

    @PutMapping("/fournisseurs/{id}")
    public Fournisseur updateFournisseur(@RequestBody Fournisseur fournisseur, @PathVariable Long id){
        fournisseur.setId(id);
        return fournisseurRepository.save(fournisseur);
    }
    @DeleteMapping("/fournisseurs/{id}")
    public void deleteFournisseur(@PathVariable Long id){
        fournisseurRepository.deleteById(id);
    }
}

