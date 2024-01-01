package net.fst.produit.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.fst.produit.enums.TypeProduit;
import net.fst.produit.model.Fournisseur;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String designation ;
    private Double price;
    private int quantite;
    private double tva;
    @Enumerated(EnumType.STRING)
    private TypeProduit typeProduit;
    private  Long fourniseurId;
    @Transient
    private Fournisseur fournisseur;

}
