package ma.enset.immatriculationservice.web.rest;

import lombok.AllArgsConstructor;
import ma.enset.immatriculationservice.entities.Proprietaire;
import ma.enset.immatriculationservice.entities.Vehicule;
import ma.enset.immatriculationservice.repository.ProprietaireRepository;
import ma.enset.immatriculationservice.repository.VehiculeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ImmmatriculationRestController {

    @Autowired
    private VehiculeRepository vehiculeRepository;
    @Autowired
    private ProprietaireRepository proprietaireRepository;


    @GetMapping("/proprietaires")
    public List<Proprietaire> proprietaireList(){
        return proprietaireRepository.findAll();
    }

    @GetMapping("/proprietaires/{id}")
    public Proprietaire proprietaireById(@PathVariable Long id){
        return proprietaireRepository.findById(id).get();
    }

    @PostMapping("/proprietaires")
    public Proprietaire saveProprietaire(@RequestBody Proprietaire proprietaire){
        return proprietaireRepository.save(proprietaire);
    }

    @PutMapping("/proprietaires/{id}")
    public Proprietaire updateProprietaire(@RequestBody Proprietaire proprietaire, @PathVariable Long id){
        proprietaire.setId(id);
        return proprietaireRepository.save(proprietaire);
    }
    @DeleteMapping("/proprietaires/{id}")
    public void deleteProprietaire(@PathVariable Long id){
        proprietaireRepository.deleteById(id);
    }


    //.--------------------------------------------------------------------------------------------------------

    @GetMapping("/vehicules")
    public List<Vehicule> vehiculeList(){
        return vehiculeRepository.findAll();
    }

    @GetMapping("/vehicules/prop/{id}")
    public List<Vehicule> vehiculeListByProp(@PathVariable long id){
        Proprietaire p = proprietaireRepository.findById(id).get();
        return vehiculeRepository.findByProprietaire(p);
    }



    @GetMapping("/vehicules/{id}")
    public Vehicule vehiculeById(@PathVariable Long id){
        return vehiculeRepository.findById(id).get();
    }
    @GetMapping("/vehicules/mtr/{id}")
    public Vehicule vehiculeByMatr(@PathVariable String id){
        return vehiculeRepository.findByNumeroMatricule(id);
    }

    @PostMapping("/vehicules")
    public Vehicule saveVehicule(@RequestBody Vehicule vehicule){
        return vehiculeRepository.save(vehicule);
    }

    @PutMapping("/vehicules/{id}")
    public Vehicule updateVehicule(@RequestBody Vehicule vehicule, @PathVariable Long id){
        vehicule.setId(id);
        return vehiculeRepository.save(vehicule);
    }
    @DeleteMapping("/vehicules/{id}")
    public void deleteVehicule(@PathVariable Long id){
        vehiculeRepository.deleteById(id);
    }

}
