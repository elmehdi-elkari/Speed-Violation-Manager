package ma.enset.infractionservice.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;




@Data @AllArgsConstructor @NoArgsConstructor
public class Radar {
    private Long id ;
    private Double Longitude ;
    private Double Latitude ;
    private Double vitesse_maximale ;

}
