package net.fst.commandeproduit.entities;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LigneCommandeID implements Serializable {

    private Long commdId;
    private Long prodId;
}
