package net.fst.facture.web;

import net.fst.facture.commandes.CommandeRestClient;
import net.fst.facture.entities.Facture;
import net.fst.facture.paiements.PaiementRestClient;
import net.fst.facture.repository.FactureRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FactureRestController {
    private FactureRepository factureRepository;
    private CommandeRestClient commandeRestClient;

    private PaiementRestClient paiementRestClient;

    public FactureRestController(FactureRepository factureRepository, CommandeRestClient commandeRestClient, PaiementRestClient paiementRestClient) {
        this.factureRepository = factureRepository;
        this.commandeRestClient = commandeRestClient;
        this.paiementRestClient = paiementRestClient;
    }

    @GetMapping("/factures")
    public List<Facture> allFactures(){
        List<Facture> factures = factureRepository.findAll();
        factures.forEach(f->{
            f.setCommande(commandeRestClient.findCommandeById(f.getId()));
            f.setPaiement(paiementRestClient.findPaiementById(f.getId()));
        });
        return factures;
    }

    @GetMapping("/factures/{id}")
    public Facture findFactureById (@PathVariable Long id){
        Facture facture = factureRepository.findById(id).get();
        facture.setCommande(commandeRestClient.findCommandeById(facture.getId()));
        facture.setPaiement(paiementRestClient.findPaiementById(facture.getId()));
        return facture;
    }

    @PostMapping("/factures")
    public Facture saveFacture(@RequestBody Facture facture){
        return factureRepository.save(facture);
    }

    @PutMapping("/factures/{id}")
    public Facture updateFacture(@RequestBody Facture facture, @PathVariable Long id){
        facture.setId(id);
        return factureRepository.save(facture);
    }
    @DeleteMapping("/factures/{id}")
    public void deleteFacture(@PathVariable Long id){
        factureRepository.deleteById(id);
    }
}
