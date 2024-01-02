package net.fst.commandeproduit.services;

import net.fst.commandeproduit.entities.Commande;


import java.util.List;


public interface CommandeService {
    public List<Commande> findAllCommandes ();

    Commande findById(Long id);

    public Commande saveCommande(Commande commande);

    public Commande updateCommande(Commande commande ,Long id );

    public void deleteCommandeById(Long id);
    public Commande ConfirmerCommande(Long id);

    public Commande getCommandeByClientId(Long id);


}
