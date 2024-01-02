package net.fst.FacturePaiement.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import net.fst.FacturePaiement.enums.EtatFacture;
import net.fst.FacturePaiement.models.Commande;

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
    private final float TVA =  0.2f;
    private double montant_HTVA;
    private double montant_TTC;
    private double montantPayer = 0;
    private Date dateFacture;
    @OneToOne
    @JsonIgnore
    private Facture ancienneFacture;
    private Long commandeId;
    @Transient
    private Commande commande;
    public void payer(){

        this.etatFacture = EtatFacture.PAYER_EN_TOTALITE;
    }

    public void payerEnPartie(double montantPayer){
        this.etatFacture = EtatFacture.PAYER_EN_PARTIE;
        this.montantPayer +=montantPayer;
    }
    public void nonPayee(){

        this.etatFacture = EtatFacture.PAS_PAYER;
    }


}
