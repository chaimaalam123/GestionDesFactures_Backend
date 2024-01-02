package net.fst.FacturePaiement.web;

import net.fst.FacturePaiement.commandes.CommandeRestClient;
import net.fst.FacturePaiement.entities.Facture;
import net.fst.FacturePaiement.services.FactureService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FactureRestController {
    private FactureService factureService;
    private CommandeRestClient commandeRestClient;


    public FactureRestController(FactureService factureService, CommandeRestClient commandeRestClient) {
        this.factureService = factureService;
        this.commandeRestClient = commandeRestClient;
    }

    @GetMapping("/factures")
    public List<Facture> allFactures(){
        List<Facture> factures = factureService.findAllFactures();
        factures.forEach(f->{
            f.setCommande(commandeRestClient.findCommandeById(f.getCommandeId()));
        });
        return factures;
    }

    @GetMapping("/factures/{id}")
    public Facture findFactureById (@PathVariable Long id){
        Facture facture = factureService.findById(id);
        facture.setCommande(commandeRestClient.findCommandeById(facture.getId()));
        return facture;
    }

    @PostMapping("/factures")
    public Facture saveFacture(@RequestBody Facture facture){

        return factureService.saveFacture(facture);
    }

    @PutMapping("/factures/{id}")
    public Facture updateFacture(@RequestBody Facture facture, @PathVariable Long id){
        return factureService.update(facture,id);
    }

}
