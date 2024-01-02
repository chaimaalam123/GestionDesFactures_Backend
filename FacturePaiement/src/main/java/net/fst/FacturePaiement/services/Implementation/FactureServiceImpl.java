package net.fst.FacturePaiement.services.Implementation;

import jakarta.persistence.EntityNotFoundException;
import net.fst.FacturePaiement.commandes.CommandeRestClient;
import net.fst.FacturePaiement.entities.Facture;
import net.fst.FacturePaiement.exceptions.UnableToSaveEntityException;
import net.fst.FacturePaiement.repository.FactureRepository;
import net.fst.FacturePaiement.services.FactureService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FactureServiceImpl implements FactureService {
    FactureRepository factureRepository;
    CommandeRestClient commandeRestClient ;



    @Override
    public List<Facture> findAllFactures() {
        return factureRepository.findAll();
    }

    @Override
    public Facture saveFacture(Facture facture) {
        commandeRestClient.findCommandeById(facture.getCommande().getId());
        try {
            facture.nonPayee();
            return factureRepository.save(facture);
        }catch (Exception e){
            throw new UnableToSaveEntityException("Unable to save Facture");
        }
    }

    @Override
    public Facture findById(Long id) {
        Optional<Facture> facture = factureRepository.findById(id);
        if (facture.isPresent()) {
            return facture.get();
        } else {
            throw new EntityNotFoundException("facture not found");
        }
    }

    @Override
    public String typePayement(Facture f) {
        String option = " ";
        if(f.getMontant_HTVA() <=5000){
            option ="EN_ESPECE";
        }
        else {
            option="PAR_CHEQUE";
        }
        return  option;
    }

    @Override
    public Facture update(Facture facture, Long id) {
        facture.setCommande(findById(id).getCommande());
        facture.setAncienneFacture(findById(id));
        facture.setId(null);
        saveFacture(facture);
        return  facture;
    }
}
