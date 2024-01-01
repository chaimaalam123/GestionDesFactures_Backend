package net.fst.produit.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.fst.produit.model.Fournisseur;

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
    @Transient
    private Fournisseur fournisseur;

}
