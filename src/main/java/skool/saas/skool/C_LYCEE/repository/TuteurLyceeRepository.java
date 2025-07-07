package skool.saas.skool.C_LYCEE.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import skool.saas.skool.C_LYCEE.Entity.TuteurLycee;

import java.util.Optional;

public interface TuteurLyceeRepository extends JpaRepository<TuteurLycee, Long> {

    Optional<TuteurLycee> findByNomIgnoreCaseAndPrenomIgnoreCase(String nom, String prenom);


}
