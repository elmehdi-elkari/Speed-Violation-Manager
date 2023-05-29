package ma.enset.infractionservice.feigen;

import ma.enset.infractionservice.entities.Vehicule;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("immatriculation-service")
public interface VehiculeSerice {
    @GetMapping("/vehicules/mtr/{id}")
    Vehicule findVehiculeByMatricule(@PathVariable String id);
}
