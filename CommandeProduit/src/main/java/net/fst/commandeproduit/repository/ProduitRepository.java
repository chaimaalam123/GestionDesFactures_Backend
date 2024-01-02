package net.fst.commandeproduit.repository;

import net.fst.commandeproduit.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProduitRepository extends JpaRepository<Produit,Long> {
    Optional<Produit> findProduitByDesignationIgnoreCase(String designation);
}
