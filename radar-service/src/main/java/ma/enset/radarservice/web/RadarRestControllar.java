package ma.enset.radarservice.web;

import ma.enset.radarservice.entities.Radar;
import ma.enset.radarservice.repositories.RadarRepository;
import ma.enset.radarservice.services.InfractionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RadarRestControllar {
    @Autowired
    private RadarRepository radarRepository;


    @GetMapping("/radars/{id}")
    Radar getRadarByID(@PathVariable Long id){
        return radarRepository.findById(id).get();
    }

    @GetMapping("/radars")
    List<Radar> getAll(){
        return radarRepository.findAll();
    }

}
