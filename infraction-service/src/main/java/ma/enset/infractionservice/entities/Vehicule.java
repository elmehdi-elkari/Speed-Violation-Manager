package ma.enset.infractionservice.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Vehicule {

    private Long id;
    private String numeroMatricule;
    private String marque;
    private String puissanceFiscale;
    @ManyToOne()
    private Proprietaire proprietaire;
}
