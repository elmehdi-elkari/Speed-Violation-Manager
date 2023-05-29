package ma.enset.radarservice;

import ma.enset.radarservice.entities.Radar;
import ma.enset.radarservice.repositories.RadarRepository;
import ma.enset.radarservice.services.InfractionService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;


@SpringBootApplication @EnableFeignClients
public class RadarServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RadarServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner start(InfractionService infractionService, RadarRepository radarRepository){
		return args -> {

			ma.enset.radarservice.entities.Radar radar1 = radarRepository.save(new ma.enset.radarservice.entities.Radar(null,4.5,116.8,100.0f));
			radarRepository.save(radar1);

			ma.enset.radarservice.entities.Radar radar2 = radarRepository.save(new ma.enset.radarservice.entities.Radar(null,123.5,16.8,60.0f));
			radarRepository.save(radar2);

			ma.enset.radarservice.entities.Radar radar3 = radarRepository.save(new ma.enset.radarservice.entities.Radar(null,334.5,600.8,100.0f));
			radarRepository.save(radar3);

			//ma.enset.radarservice.entities.Radar radar2 = radarRepository.save(new ma.enset.radarservice.entities.Radar(null,10.07,126.8,60.0f));
			//radarRepository.save(radar2);

			for (Radar r : radarRepository.findAll()) {
				r.start(infractionService);
			}




		};
	}

}
