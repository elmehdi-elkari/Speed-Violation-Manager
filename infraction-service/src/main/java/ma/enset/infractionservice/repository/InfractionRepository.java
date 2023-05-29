package ma.enset.infractionservice.repository;


import ma.enset.infractionservice.entities.Infraction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InfractionRepository extends JpaRepository<Infraction,Long> {
}

