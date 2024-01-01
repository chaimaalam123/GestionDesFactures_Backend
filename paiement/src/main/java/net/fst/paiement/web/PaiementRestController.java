package net.fst.paiement.web;


import net.fst.paiement.entities.Paiement;
import net.fst.paiement.repository.PaiementRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PaiementRestController {
    private PaiementRepository paiementRepository;

    public PaiementRestController(PaiementRepository paiementRepository) {
        this.paiementRepository = paiementRepository;
    }

    @GetMapping("/paiements")
    public List<Paiement> allPaiements(){
        return paiementRepository.findAll();
    }

    @GetMapping("/paiements/{id}")
    public Paiement findPaiementById (@PathVariable Long id){
        return paiementRepository.findById(id).get();
    }

    @PostMapping("/paiements")
    public Paiement savePaiement(@RequestBody Paiement paiement){
        return paiementRepository.save(paiement);
    }

    @PutMapping("/paiements/{id}")
    public Paiement updatePaiement(@RequestBody Paiement paiement, @PathVariable Long id){
        paiement.setId(id);
        return paiementRepository.save(paiement);
    }
    @DeleteMapping("/paiements/{id}")
    public void deletePaiement(@PathVariable Long id){
        paiementRepository.deleteById(id);
    }
}
