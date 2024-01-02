package net.fst.commandeproduit.services.Implementation;

import jakarta.persistence.EntityNotFoundException;
import net.fst.commandeproduit.clients.CustomerRestClient;
import net.fst.commandeproduit.entities.Commande;
import net.fst.commandeproduit.exceptions.UnableToSaveEntityException;
import net.fst.commandeproduit.repository.CommandeRepository;
import net.fst.commandeproduit.services.CommandeService;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class CommandeServiceImpl  implements CommandeService
{

    CommandeRepository commandeRepository;
    CustomerRestClient customerRestClient;


    public CommandeServiceImpl(CommandeRepository commandeRepository, CustomerRestClient customerRestClient) {
        this.commandeRepository = commandeRepository;
        this.customerRestClient = customerRestClient;
    }

    @Override
    public List<Commande> findAllCommandes() {
        return commandeRepository.findAll();
    }


    @Override
    public Commande findById(Long id) {
        Optional<Commande> commande = commandeRepository.findById(id);
        if (commande.isPresent()) {
            return commande.get();
        } else {
            throw new EntityNotFoundException("Commande not found");
        }
    }

    @Override
    public Commande saveCommande(Commande commande) {
        customerRestClient.findCustomerById(commande.getClientId());
        try {
            commande.mettreEnAttente();
            return commandeRepository.save(commande);
        }catch (Exception e){
            throw new UnableToSaveEntityException("Unable to save Commande");
        }
    }

    @Override
    public Commande updateCommande(Commande commande , Long id) {
        findById(id);
        commande.setId(id);
        return commandeRepository.save(commande);
    }

    @Override
    public void deleteCommandeById(Long id) {
        findById(id);
        commandeRepository.deleteById(id);
    }

    @Override
    public Commande ConfirmerCommande(Long id) {
        Commande commande = commandeRepository.findById(id).orElse(null);
        if (commande == null) {
            throw new EntityNotFoundException("Commande not found");
        }
        commande.confirmer();
        return commandeRepository.save(commande);
    }

    @Override
    public Commande getCommandeByClientId(Long id) {
        return commandeRepository.getCommandeByClientId(id);
    }
}
