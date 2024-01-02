package net.fst.commandeproduit.services;

import net.fst.commandeproduit.entities.Commande;
import net.fst.commandeproduit.entities.LigneCommande;


import java.util.List;

public interface LigneCommandeService {

    public List<LigneCommande> ListProduitByIdCommande(Long idCommande);

    public List<LigneCommande> findAll();

    public LigneCommande save(LigneCommande ligneCommande);

}
