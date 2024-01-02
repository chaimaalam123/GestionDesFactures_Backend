package net.fst.FacturePaiement.commandes;

import net.fst.FacturePaiement.models.Commande;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="COMMANDE-SERVICE")
public interface CommandeRestClient {
    @GetMapping("/commandes/{id}")
    Commande findCommandeById(@PathVariable Long id);

    @GetMapping("/commandes")
    List<Commande> AllCommandes();


}
