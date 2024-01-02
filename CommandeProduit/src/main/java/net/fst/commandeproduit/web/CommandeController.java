package net.fst.commandeproduit.web;

import net.fst.commandeproduit.clients.CustomerRestClient;
import net.fst.commandeproduit.entities.Commande;
import net.fst.commandeproduit.models.Client;
import net.fst.commandeproduit.services.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommandeController {

    private CommandeService commandeService;
    private CustomerRestClient customerRestClient;

    public CommandeController(CommandeService commandeService, CustomerRestClient customerRestClient) {
        this.commandeService = commandeService;
        this.customerRestClient = customerRestClient;
    }

    @GetMapping("/commandes")
    public List<Commande> commandeList(){
        List<Commande> commandes = commandeService.findAllCommandes();
        commandes.forEach(c ->{
            c.setClient(customerRestClient.findCustomerById(c.getClientId()));
        });
        return commandes;
    }

    @GetMapping("/commandes/{id}")
    public Commande commandeById (@PathVariable Long id){
        Commande commande = commandeService.findById(id);
        Client client = customerRestClient.findCustomerById(commande.getClientId());
        commande.setClient(client);
        return commande;
    }
    @PostMapping("/commandes")
    public Commande saveCommande(@RequestBody Commande commande){

        return commandeService.saveCommande(commande);
    }

    @PutMapping("/commandes/{id}")
    public Commande updateCommande(@RequestBody Commande commande, @PathVariable Long id){
        return commandeService.updateCommande(commande,id);
    }
    @DeleteMapping("/commandes/{id}")
    public void deleteCommande(@PathVariable Long id){
        commandeService.deleteCommandeById(id);
    }

    @GetMapping("confirmerCommande/{id}")
    public Commande confirmerCommande(@PathVariable Long id) {
        return commandeService.ConfirmerCommande(id);
    }

    @GetMapping("findCommandeByClientId/{id}")
    public Commande findCommandeByClientId(@PathVariable Long id) {
        Commande commande = commandeService.getCommandeByClientId(id);
        Client client = customerRestClient.findCustomerById(commande.getClientId());
        commande.setClient(client);
        return commande;
    }
}
