package net.fst.FacturePaiement.repository;

import net.fst.FacturePaiement.entities.Facture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FactureRepository extends JpaRepository<Facture,Long>
{
}
