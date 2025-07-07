//package skool.saas.skool.GLOBALE.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import skool.saas.skool.GLOBALE.Entity.Licence;
//import skool.saas.skool.GLOBALE.Entity.Utilisateur;
//import skool.saas.skool.GLOBALE.repository.LicenceRepository;
//
//import java.time.LocalDate;
//import java.util.Optional;
//import java.util.UUID;
//
//public class LicenceService {
//    @Autowired
//    private LicenceRepository licenceRepository;
//
//    public Licence generateLicenceForUser(Utilisateur utilisateur, int joursValidite) {
//        Licence licence = new Licence();
//        licence.setLicenceKey(UUID.randomUUID().toString());
//        licence.setDateDebut(LocalDate.now());
//        licence.setDateFin(LocalDate.now().plusDays(joursValidite));
//        licence.setUtilisateur(utilisateur);
//        licence.setActive(true);
//
//        return licenceRepository.save(licence);
//    }
//
//    public boolean isLicenceValid(Utilisateur utilisateur) {
//        Optional<Licence> optional = licenceRepository.findByUtilisateur_IdUser(utilisateur.getIdUser());
//        if (optional.isEmpty()) return false;
//
//        Licence licence = optional.get();
//        LocalDate now = LocalDate.now();
//
//        return licence.isActive() && (now.isEqual(licence.getDateDebut()) || now.isAfter(licence.getDateDebut())) && now.isBefore(licence.getDateFin());
//    }
//
//    public String activerLicenceManuellement(String key, Utilisateur utilisateur) {
//        Optional<Licence> optional = licenceRepository.findByLicenceKey(key);
//
//        if (optional.isPresent()) {
//            Licence licence = optional.get();
//            licence.setUtilisateur(utilisateur); // associer au user
//            licence.setActive(true);
//            licenceRepository.save(licence);
//            return "Licence activée avec succès jusqu’au " + licence.getDateFin();
//        }
//        return "Clé de licence invalide";
//    }
//
//}
