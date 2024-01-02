package net.fst.commandeproduit.repository;

import net.fst.commandeproduit.entities.Commande;
import net.fst.commandeproduit.entities.LigneCommande;
import net.fst.commandeproduit.entities.LigneCommandeID;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface LigneCommandRepository extends JpaRepository<LigneCommande, LigneCommandeID> {
    ArrayList<LigneCommande> findByCommande(Commande commande);
}
