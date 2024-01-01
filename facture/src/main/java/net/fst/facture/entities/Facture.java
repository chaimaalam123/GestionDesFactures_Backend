package net.fst.facture.entities;


import jakarta.persistence.*;
import lombok.*;
import net.fst.facture.enums.EtatFacture;
import net.fst.facture.models.Commande;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Facture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private EtatFacture etatFacture;
    private double montantTotal;
    private Date dateFacture;
    private Long CommandeId;
    @Transient
    private Commande commande;


}
