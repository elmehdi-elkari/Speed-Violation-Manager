package ma.enset.infractionservice;

import ma.enset.infractionservice.entities.Infraction;
import ma.enset.infractionservice.repository.InfractionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication @EnableFeignClients
public class InfractionServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InfractionServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(InfractionRepository infractionRepository){
        return args -> {
            /*for (int i=0;i<20;i++){
                Infraction infraction = Infraction.builder()
                        .id((long) i)
                        .date(new Date())
                        .matricule("jdhklj")
                        .montant(1232.2f)
                        .numero("3421")
                        .vitesseVehicule(232.23f)
                        .build();

                infractionRepository.save(infraction);
            }*/
        };
    }

}
