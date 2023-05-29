package ma.enset.immatriculationservice.web.graphql;

import lombok.AllArgsConstructor;
import ma.enset.immatriculationservice.entities.Proprietaire;
import ma.enset.immatriculationservice.entities.Vehicule;
import ma.enset.immatriculationservice.repository.ProprietaireRepository;
import ma.enset.immatriculationservice.repository.VehiculeRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;


@Controller
@AllArgsConstructor
public class ImmatriculationGraphQLService {
    private ProprietaireRepository proprietaireRepository;
    private VehiculeRepository vehiculeRepository;

    @QueryMapping
    public List<Proprietaire> proprietaireList(){
        return proprietaireRepository.findAll();
    }

    @QueryMapping
    public Proprietaire proprietaireById(@Argument Long id){
        return proprietaireRepository.findById(id).get();

    }

    @MutationMapping
    public Proprietaire saveProprietaire(@Argument Proprietaire proprietaire){
        return proprietaireRepository.save(proprietaire);
    }

    @MutationMapping
    public Proprietaire updateProprietaire(@Argument Proprietaire proprietaire, @Argument Long id){
        proprietaire.setId(id);
        return proprietaireRepository.save(proprietaire);
    }

    @MutationMapping
    public void deleteProprietaire(@Argument Long id){
        proprietaireRepository.deleteById(id);
    }

    //-------------------------------------------------------------------------------

    @QueryMapping
    public List<Vehicule> vehiculeList(){
        return vehiculeRepository.findAll();
    }

    @QueryMapping
    public Vehicule vehiculeById(@Argument Long id){
        return vehiculeRepository.findById(id).get();
    }

    @MutationMapping
    public Vehicule saveVehicule(@Argument Vehicule proprietaire){
        return vehiculeRepository.save(proprietaire);
    }

    @MutationMapping
    public Vehicule updateVehicule(@Argument Vehicule proprietaire, @Argument Long id){
        proprietaire.setId(id);
        return vehiculeRepository.save(proprietaire);
    }

    @MutationMapping
    public void deleteVehicule(@Argument Long id){
        vehiculeRepository.deleteById(id);
    }
}
