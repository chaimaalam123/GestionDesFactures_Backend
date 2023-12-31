package net.fst.commande.entities;

import jakarta.persistence.*;
import lombok.*;
import net.fst.commande.enums.EtatCommande;
import net.fst.commande.models.Client;

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
    @Enumerated(EnumType.STRING)
    private EtatCommande etatCommande;
    private Long clientId;
    @Transient
    private Client client;
}
