package net.fst.produit.fournisseurs;

import net.fst.produit.model.Fournisseur;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="FOURNISSEUR-SERVICE")
public interface FournisseurRestClient {

    @GetMapping("/fournisseurs/{id}")
    Fournisseur findFournisseurById(@PathVariable Long id);

    @GetMapping("/fournisseurs")
    List<Fournisseur> AllFournisseurs();

}
