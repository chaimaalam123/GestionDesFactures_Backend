package net.fst.commandeproduit.services.Implementation;


import net.fst.commandeproduit.entities.Commande;
import net.fst.commandeproduit.entities.LigneCommande;
import net.fst.commandeproduit.entities.Produit;
import net.fst.commandeproduit.repository.CommandeRepository;
import net.fst.commandeproduit.repository.LigneCommandRepository;
import net.fst.commandeproduit.repository.ProduitRepository;
import net.fst.commandeproduit.services.LigneCommandeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LigneCommandeServiceImpl implements LigneCommandeService {
    LigneCommandRepository ligneCommandRepository;

    CommandeRepository commandeRepository;

    ProduitRepository produitRepository;

    public LigneCommandeServiceImpl(LigneCommandRepository ligneCommandRepository, CommandeRepository commandeRepository, ProduitRepository produitRepository) {
        this.ligneCommandRepository = ligneCommandRepository;
        this.commandeRepository = commandeRepository;
        this.produitRepository = produitRepository;
    }

    @Override
    public List<LigneCommande> ListProduitByIdCommande(Long idCommande) {
        Commande commande = commandeRepository.findById(idCommande).get();
        return ligneCommandRepository.findByCommande(commande);
    }

    @Override
    public List<LigneCommande> findAll() {
        return ligneCommandRepository.findAll();
    }

    @Override
    public LigneCommande save(LigneCommande ligneCommande) {
        try {
            Commande commande = commandeRepository.findById(ligneCommande.getId().getCommdId()).get();
            Produit produit = produitRepository.findById(ligneCommande.getId().getProdId()).get();
            ligneCommande.setProduit(produit);
            ligneCommande.setCommande(commande);
            return ligneCommandRepository.save(ligneCommande);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}
