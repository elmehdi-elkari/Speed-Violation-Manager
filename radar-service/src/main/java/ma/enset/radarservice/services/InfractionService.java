package ma.enset.radarservice.services;

import ma.enset.radarservice.entities.Infraction;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient("infraction-service")
public interface InfractionService {
    @PostMapping("/infractions")
    Infraction saveInfractions(Infraction infraction);
}
