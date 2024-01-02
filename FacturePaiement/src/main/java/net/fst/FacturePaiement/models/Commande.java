package net.fst.FacturePaiement.models;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Commande {
    private Long id;
    private String etatCommande;
    private Long clientId;
    private Client client;
}
