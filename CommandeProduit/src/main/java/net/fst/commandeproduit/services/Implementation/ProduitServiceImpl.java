package net.fst.commandeproduit.services.Implementation;

import jakarta.persistence.EntityNotFoundException;
import net.fst.commandeproduit.entities.Produit;
import net.fst.commandeproduit.repository.ProduitRepository;
import net.fst.commandeproduit.services.ProduitService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProduitServiceImpl  implements ProduitService {

    ProduitRepository produitRepository;

    public ProduitServiceImpl(ProduitRepository produitRepository) {
        this.produitRepository = produitRepository;
    }

    @Override
    public List<Produit> findAllProduits() {
        return produitRepository.findAll();
    }

    @Override
    public Produit findById(Long id) {
        Optional<Produit> produit = produitRepository.findById(id);
        if (produit.isPresent()) {
            return produit.get();
        } else {
            throw new EntityNotFoundException("Produit not found");
        }

    }

    @Override
    public Produit findByDesignation(String designation) {
        return produitRepository.findProduitByDesignationIgnoreCase(designation)
                .orElseThrow(() -> new EntityNotFoundException("Produit not found"));
    }


    @Override
    public Produit saveProduit(Produit produit) {
        return produitRepository.save(produit);
    }

    @Override
    public Produit updateProduit(Produit produit, Long id) {
        findById(id);
        produit.setId(id);
        return produitRepository.save(produit);
    }

    @Override
    public void deleteProduitById(Long id) {
     findById(id);
     produitRepository.deleteById(id);
    }
}
