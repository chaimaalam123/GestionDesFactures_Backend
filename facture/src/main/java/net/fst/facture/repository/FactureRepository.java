package net.fst.facture.repository;

import net.fst.facture.entities.Facture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FactureRepository extends JpaRepository<Facture,Long>
{
}
