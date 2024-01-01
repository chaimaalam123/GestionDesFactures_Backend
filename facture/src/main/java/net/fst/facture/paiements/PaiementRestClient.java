package net.fst.facture.paiements;

import net.fst.facture.models.Paiement;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="PAIEMENT-SERVICE")
public interface PaiementRestClient {
    @GetMapping("/paiements/{id}")
    Paiement findPaiementById(@PathVariable Long id);

    @GetMapping("/paiements")
    List<Paiement> AllPaiements();
}
