package net.fst.commandeproduit.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import net.fst.commandeproduit.enums.EtatCommande;
import net.fst.commandeproduit.models.Client;


import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String designation;
    @Enumerated(EnumType.STRING)
    private EtatCommande etatCommande;
    private Long clientId;
    @Transient
    private Client client;

    @OneToMany(mappedBy = "commande" , cascade = CascadeType.REMOVE)
    @JsonIgnore
    private List<LigneCommande> ligneCommande = new ArrayList<>();

    public void confirmer(){
        this.etatCommande = EtatCommande.CONFIRME;
    }

    public void mettreEnAttente(){
        this.etatCommande = EtatCommande.EN_ATTENDE_DE_CONFIRMATION;
    }
}
