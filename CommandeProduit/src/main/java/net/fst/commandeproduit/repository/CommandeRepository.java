package net.fst.commandeproduit.repository;

import net.fst.commandeproduit.entities.Commande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeRepository extends JpaRepository<Commande,Long> {
    Commande getCommandeByClientId(long id);
}
