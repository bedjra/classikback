//package skool.saas.skool.GLOBALE.repository;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import skool.saas.skool.GLOBALE.Entity.Licence;
//
//import java.util.Optional;
//
//public interface LicenceRepository extends JpaRepository<Licence, Long> {
//    Optional<Licence> findByLicenceKey(String licenceKey);
//    Optional<Licence> findByUtilisateur_IdUser(Long idUser);
//}