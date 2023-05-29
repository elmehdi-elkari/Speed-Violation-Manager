package ma.enset.immatriculationservice;

import ma.enset.immatriculationservice.entities.Proprietaire;
import ma.enset.immatriculationservice.entities.Vehicule;
import ma.enset.immatriculationservice.repository.ProprietaireRepository;
import ma.enset.immatriculationservice.repository.VehiculeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication @EnableFeignClients
public class ImmatriculationServiceApplication implements CommandLineRunner {
    @Autowired
    private ProprietaireRepository proprietaireRepository;
    @Autowired
    private VehiculeRepository vehiculeRepository;

    public static void main(String[] args) {
        SpringApplication.run(ImmatriculationServiceApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {

        List<String> matricule = new ArrayList<>();
        matricule.add("A763BC");
        matricule.add("C268NM");
        matricule.add("E767OP");
        matricule.add("K757NE");
        matricule.add("W768BR");
        matricule.add("M766LL");

        List<String> marque = new ArrayList<>();
        matricule.add("Mercedes");
        matricule.add("BMW");
        matricule.add("Bantley");
        matricule.add("Dacia");
        matricule.add("Neo");
        matricule.add("Volswagen");

        List<String> proprietaire = new ArrayList<>();
        proprietaire.add("Ahmed");
        proprietaire.add("Youssef");
        proprietaire.add("Hicham");
        proprietaire.add("Mohammed");
        proprietaire.add("El mehdi");
        proprietaire.add("Reda");

        for (int i = 0; i < proprietaire.size(); i++) {
            Proprietaire p = Proprietaire.builder()
                    .nom(proprietaire.get(i))
                    .dateNaissance(new Date(3368*i+1))
                    .email(proprietaire.get(i).trim()+"@gmail.com")
                    .build();
            proprietaireRepository.save(p);

            Vehicule vehicule = Vehicule.builder()
                    .marque(marque.get(i))
                    .numeroMatricule(matricule.get(i))
                    .proprietaire(p)
                    .puissanceFiscale("puissance")
                    .build();
            vehiculeRepository.save(vehicule);
        }
        System.out.println(vehiculeRepository.findByNumeroMatricule("W768BR").getMarque());

    }
}

