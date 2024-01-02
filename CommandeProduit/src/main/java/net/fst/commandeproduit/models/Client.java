package net.fst.commandeproduit.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class Client {
    private Long id;
    private String prénom;
    private String nom;
    private String email;
    private String adresse;

}
