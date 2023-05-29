package ma.enset.infractionservice.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;


@Entity
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Infraction {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long numeroRadar;
    private Date date;
    private String matricule;
    private Float vitesseVehicule;
    private Float vitesseMax;
    private Float montant;
    @Transient
    private Vehicule vehicule;
    @Transient
    private Radar radar;


}
