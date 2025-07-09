package skool.saas.skool.GLOBALE.service;

import org.springframework.beans.factory.annotation.Autowired;
import skool.saas.skool.GLOBALE.Entity.Licence;
import skool.saas.skool.GLOBALE.repository.LicenceRepository;

import java.time.LocalDate;
import java.util.Optional;


public class LicenceService {
    @Autowired
    private LicenceRepository licenceRepository;

    /**
     * Vérifie si la licence est valide pour l'école donnée.
     * @param licenceKey La clé de licence à vérifier
     * @param nomEcole Le nom de l'école (pour s'assurer qu'elle appartient à cette école)
     * @return true si licence valide, false sinon
     */
    public boolean verifierLicence(String licenceKey, String nomEcole) {
        Optional<Licence> optionalLicence = licenceRepository.findByLicenceKeyAndNomEcole(licenceKey, nomEcole);

        if (optionalLicence.isEmpty()) {
            return false; // Licence non trouvée
        }

        Licence licence = optionalLicence.get();

        if (!licence.isActive()) {
            return false; // Licence inactive
        }

        LocalDate now = LocalDate.now();

        // Vérifie si la date actuelle est entre dateDebut (incluse) et dateFin (exclue)
        return (now.isEqual(licence.getDateDebut()) || now.isAfter(licence.getDateDebut()))
                && now.isBefore(licence.getDateFin());
    }

}
