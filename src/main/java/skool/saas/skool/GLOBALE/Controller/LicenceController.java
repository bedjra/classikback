package skool.saas.skool.GLOBALE.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import skool.saas.skool.GLOBALE.Entity.Utilisateur;
import skool.saas.skool.GLOBALE.service.LicenceService;
import skool.saas.skool.GLOBALE.service.UtilisateurService;

import java.util.Map;
@Tag(name = "Licence ", description = "Gestion de la licence")

@RestController
@RequestMapping("/licence")
public class LicenceController {

       @Autowired
    private LicenceService licenceService;

    @PostMapping
    public ResponseEntity<String> verifierLicence(@RequestBody Map<String, String> request) {
        String licenceKey = request.get("licenceKey");
        String nomEcole = request.get("nomEcole");

        if (licenceKey == null || nomEcole == null) {
            return ResponseEntity.badRequest().body("Clé licence ou nom école manquant");
        }

        boolean valide = licenceService.verifierLicence(licenceKey, nomEcole);

        if (valide) {
            return ResponseEntity.ok("Licence valide, accès autorisé");
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Licence invalide ou expirée");
        }
    }
}
