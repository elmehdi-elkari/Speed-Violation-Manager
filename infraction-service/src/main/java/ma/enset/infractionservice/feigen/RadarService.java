package ma.enset.infractionservice.feigen;

import ma.enset.infractionservice.entities.Radar;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("radar-service")
public interface RadarService {

    @GetMapping("/radars/{id}")
    Radar findRadarById(@PathVariable Long id);

}
