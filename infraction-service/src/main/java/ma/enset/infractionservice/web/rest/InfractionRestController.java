package ma.enset.infractionservice.web.rest;

import lombok.AllArgsConstructor;
import ma.enset.infractionservice.entities.Infraction;
import ma.enset.infractionservice.feigen.RadarService;
import ma.enset.infractionservice.feigen.VehiculeSerice;
import ma.enset.infractionservice.repository.InfractionRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class InfractionRestController {

    private InfractionRepository infractionRepository;
    private RadarService radarService;
    private VehiculeSerice vehiculeSerice;


    @GetMapping("/infractions")
    public List<Infraction> infractionList(){
        Page<Infraction> infractionList = infractionRepository.findAll(Pageable.ofSize(10));
        for (Infraction infraction : infractionList) {
            //System.out.println(infraction.getNumeroRadar());
            //System.out.println("test");
            //System.out.println(radarService.toString());
            //infraction.setRadar(radarService.findRadarById(infraction.getNumeroRadar()));
            infraction.setVehicule(vehiculeSerice.findVehiculeByMatricule(infraction.getMatricule()));
        }

        return infractionList.toList() ;
    }

    @GetMapping("/infractions/{id}")
    public Infraction infractionById(@PathVariable Long id){
        Infraction infraction=  infractionRepository.findById(id).get();
        infraction.setRadar(radarService.findRadarById(infraction.getNumeroRadar()));
        infraction.setVehicule(vehiculeSerice.findVehiculeByMatricule(infraction.getMatricule()));
        return infraction;
    }

    @PostMapping("/infractions")
    public Infraction saveInfraction(@RequestBody Infraction infraction){
        return infractionRepository.save(infraction);
    }

    @PutMapping("/infractions/{id}")
    public Infraction updateInfraction(@RequestBody Infraction infraction, @PathVariable Long id){
        infraction.setId(id);
        return infractionRepository.save(infraction);
    }
    @DeleteMapping("/infractions/{id}")
    public void deleteInfraction(@PathVariable Long id){
        infractionRepository.deleteById(id);
    }


}
