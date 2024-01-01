package net.fst.paiement.repository;

import net.fst.paiement.entities.Paiement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaiementRepository extends JpaRepository<Paiement,Long> {
}
