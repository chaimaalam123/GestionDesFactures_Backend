package net.fst.commandeproduit.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@DiscriminatorValue(value = "Se")
public class Service extends Produit {
    private String type;

    public Service(Long id, String designation, Double price, double tva, String type) {
        super(id, designation, price, tva);
        this.type = type;
    }
}
