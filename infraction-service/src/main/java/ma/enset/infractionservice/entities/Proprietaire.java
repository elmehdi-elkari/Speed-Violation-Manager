package ma.enset.infractionservice.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Proprietaire {
    private Long id;
    private String nom;
    private Date dateNaissance;
    private String email;

}
