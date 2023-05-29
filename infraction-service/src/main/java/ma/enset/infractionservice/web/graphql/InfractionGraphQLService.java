package ma.enset.infractionservice.web.graphql;

import lombok.AllArgsConstructor;
import ma.enset.infractionservice.entities.Infraction;
import ma.enset.infractionservice.repository.InfractionRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;


@Controller
@AllArgsConstructor
public class InfractionGraphQLService {
    private InfractionRepository infractionRepo;

    @QueryMapping
    public List<Infraction> infractionList(){
        return infractionRepo.findAll();
    }

    @QueryMapping
    public Infraction infractionById(@Argument Long id){
        return infractionRepo.findById(id).get();

    }

    @MutationMapping
    public Infraction saveInfraction(@Argument Infraction proprietaire){
        return infractionRepo.save(proprietaire);
    }

    @MutationMapping
    public Infraction updateInfraction(@Argument Infraction proprietaire, @Argument Long id){
        proprietaire.setId(id);
        return infractionRepo.save(proprietaire);
    }

    @MutationMapping
    public void deleteProprietaire(@Argument Long id){
        infractionRepo.deleteById(id);
    }


}
