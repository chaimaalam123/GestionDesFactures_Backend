package net.fst.commande.web;

import net.fst.commande.clients.CustomerRestClient;
import net.fst.commande.entities.Commande;
import net.fst.commande.models.Client;
import net.fst.commande.repository.CommandeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommandeRestController {

    private CommandeRepository commandeRepository;
    private CustomerRestClient customerRestClient;

    public CommandeRestController(CommandeRepository commandeRepository, CustomerRestClient customerRestClient) {
        this.commandeRepository = commandeRepository;
        this.customerRestClient = customerRestClient;
    }

    @GetMapping("/commandes")
    public List<Commande> commandeList(){
        List<Commande> commandes = commandeRepository.findAll();
        commandes.forEach(c ->{
            c.setClient(customerRestClient.findCustomerById(c.getClientId()));
        });
        return commandes;
    }

    @GetMapping("/commandes/{id}")
    public Commande commandeById (@PathVariable Long id){
        Commande commande = commandeRepository.findById(id).get();
        Client client = customerRestClient.findCustomerById(commande.getId());
        commande.setClient(client);
        return commande;
    }
    @PostMapping("/commandes")
    public Commande saveCommande(@RequestBody Commande commande){
        return commandeRepository.save(commande);
    }

    @PutMapping("/commandes/{id}")
    public Commande updateCommande(@RequestBody Commande commande, @PathVariable Long id){
        commande.setId(id);
        return commandeRepository.save(commande);
    }
    @DeleteMapping("/commandes/{id}")
    public void deleteCommande(@PathVariable Long id){
        commandeRepository.deleteById(id);
    }
}
