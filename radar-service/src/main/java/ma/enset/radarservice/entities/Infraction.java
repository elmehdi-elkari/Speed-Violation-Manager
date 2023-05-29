package ma.enset.radarservice.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;



@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Infraction {

    private Long id;
    private Long numeroRadar;
    private Date date;
    private String matricule;
    private Float vitesseVehicule;
    private Float vitesseMax;
    private Float montant;


}
