package net.fst.FacturePaiement.services;

import net.fst.FacturePaiement.entities.Facture;

import java.util.List;

public interface FactureService {

    public List<Facture> findAllFactures();

    public Facture saveFacture(Facture facture);

    public  Facture findById(Long id);

    public String typePayement(Facture f);

    Facture update(Facture facture, Long id);
}
