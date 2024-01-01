package net.fst.produit.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Fournisseur {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;

    private String address;
}
