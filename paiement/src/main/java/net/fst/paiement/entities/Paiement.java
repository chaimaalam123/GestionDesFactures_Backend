package net.fst.paiement.entities;

import jakarta.persistence.*;
import lombok.*;
import net.fst.paiement.enums.ModePaiement;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Paiement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private ModePaiement modePaiement;

}
