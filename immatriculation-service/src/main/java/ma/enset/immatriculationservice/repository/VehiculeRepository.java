package ma.enset.immatriculationservice.repository;

import ma.enset.immatriculationservice.entities.Proprietaire;
import ma.enset.immatriculationservice.entities.Vehicule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface VehiculeRepository extends JpaRepository<Vehicule,Long> {

    Vehicule findByNumeroMatricule(String mtr);
    List<Vehicule> findByProprietaire(Proprietaire p);
}
