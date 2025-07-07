package skool.saas.skool.C_LYCEE.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import skool.saas.skool.C_LYCEE.Entity.EleveLycee;
import skool.saas.skool.C_LYCEE.enums.ClasseLYCEE;

import java.util.List;
import java.util.Optional;

public interface EleveLyceeRepository extends JpaRepository<EleveLycee, Long> {
    List<EleveLycee> findByClasse(ClasseLYCEE classe);
    Optional<EleveLycee> findByNomIgnoreCaseAndPrenomIgnoreCase(String nom, String prenom);
    long countByClasseAndSexeIgnoreCase(ClasseLYCEE classe, String sexe);
    long countByClasse(ClasseLYCEE classe);

}
