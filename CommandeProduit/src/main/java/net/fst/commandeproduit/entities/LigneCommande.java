package net.fst.commandeproduit.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.*;

@Entity
@NoArgsConstructor
@Setter
@Getter
@ToString
public class LigneCommande {
    @EmbeddedId
    private LigneCommandeID id = new LigneCommandeID();

    @ManyToOne
    @MapsId("commdId")
    @JsonIgnore
    private Commande commande;

    @ManyToOne
    @MapsId("prodId")
    @JsonIgnore
    private Produit produit;

    private int quantite;

    public LigneCommande(LigneCommandeID id) {
        this.id = id;
    }


}
