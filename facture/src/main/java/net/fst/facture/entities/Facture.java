package net.fst.facture.entities;


import jakarta.persistence.*;
import lombok.*;
import net.fst.facture.enums.EtatFacture;
import net.fst.facture.models.Commande;
import net.fst.facture.models.Paiement;

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
    private Long commandeId;
    @Transient
    private Commande commande;

    private Long paiementId;
    @Transient
    private Paiement paiement;


}
