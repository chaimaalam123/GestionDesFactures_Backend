package net.fst.facture.models;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import net.fst.facture.enums.EtatCommande;
@Getter
@Setter
@ToString
public class Commande {
    private Long id;
    private EtatCommande etatCommande;
    private Long clientId;
    private Client client;
}
