//package skool.saas.skool.GLOBALE.Controller;
//
//import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.tags.Tag;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import skool.saas.skool.GLOBALE.Entity.Utilisateur;
//import skool.saas.skool.GLOBALE.service.LicenceService;
//import skool.saas.skool.GLOBALE.service.UtilisateurService;
//
//import java.util.Map;
//@Tag(name = "Licence ", description = "Gestion de la licence")
//
//@RestController
//@RequestMapping("/licence")
//public class LicenceController {
//
//    @Autowired
//    private LicenceService licenceService;
//
//    @Autowired
//    private UtilisateurService utilisateurService;
//
//    @PostMapping("/valider")
//    @Operation(summary = "Le choix du système")
//    public ResponseEntity<String> validerLicence(@RequestBody Map<String, String> payload) {
//        String key = payload.get("licenceKey");
//
//        Utilisateur utilisateur = utilisateurService.getUtilisateurConnecte();
//        if (utilisateur == null) return ResponseEntity.status(401).body("Non authentifié");
//
//        String result = licenceService.activerLicenceManuellement(key, utilisateur);
//        return ResponseEntity.ok(result);
//    }
//
//    @GetMapping
//    @Operation(summary = "verification de la licence")
//    public ResponseEntity<String> verifierLicence() {
//        Utilisateur utilisateur = utilisateurService.getUtilisateurConnecte();
//        if (utilisateur == null) return ResponseEntity.status(401).body("Non authentifié");
//
//        boolean valid = licenceService.isLicenceValid(utilisateur);
//        return valid ?
//                ResponseEntity.ok("Licence encore valide") :
//                ResponseEntity.status(403).body("Licence expirée ou non trouvée");
//    }
//}
