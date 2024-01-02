package net.fst.commandeproduit.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.fst.commandeproduit.models.Fournisseur;


import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Categorie",discriminatorType = DiscriminatorType.STRING,length = 2)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY,property = "categorie")
@JsonSubTypes({
        @JsonSubTypes.Type(name = "Ar" , value = Article.class),
        @JsonSubTypes.Type(name = "Se" , value = Service.class)
}
)
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String designation ;
    private Double prixUnitaire;
    private String description;
    private  Long fourniseurId;
    @Transient
    private Fournisseur fournisseur;
    @OneToMany(mappedBy = "produit", cascade = CascadeType.REMOVE)
    @JsonIgnore
    private List<LigneCommande> ligneCommande = new ArrayList<>();

    public Produit(Long id, String designation, Double price, double tva) {
    }
}
