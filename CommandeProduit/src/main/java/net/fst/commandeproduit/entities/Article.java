package net.fst.commandeproduit.entities;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
@DiscriminatorValue(value = "Ar")
public class Article extends Produit {

    private int stock;

    public Article(Long id, String designation, Double price, double tva, int stock) {
        super(id, designation, price, tva);
        this.stock = stock;
    }
}
