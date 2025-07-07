//package skool.saas.skool.C_LYCEE.Controller;
//
//import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.tags.Tag;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.server.ResponseStatusException;
//
//
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/College")
//@CrossOrigin(origins = "http://localhost:3000")
//
//@Tag(name = "College", description = "Gestion du system COLLEGE")
//
//public class LyceController {
//
//    @Autowired
//    private EleveLyceeService eleveCollegeService;
//
//    @Autowired
//    private TuteurLyceeService tuteurCollegeService;
//
//
//    @Operation(summary = "Ajout d'un eleve ")
//    @PostMapping
//    public ResponseEntity<LyceeCollege> ajouterEleve(@RequestBody EleveLyceeDto dto) {
//        LyceeCollege eleveCree = eleveCollegeService.ajouterEleveEtTuteur(dto);
//        return ResponseEntity.ok(eleveCree);
//    }
//
//
//    @Operation(summary = "Récupérer tous les tuteurs ")
//    @GetMapping
//    public List<TuteurLyceeSimpleDto> getAllTuteurs() {
//        return tuteurCollegeService.getAllTuteurs();
//    }
//
//
//    @Operation(summary = "get by nom et prenom ")
//    @GetMapping("/getby")
//    public ResponseEntity<?> getEleveByNomAndPrenom(
//            @RequestParam String nom,
//            @RequestParam String prenom) {
//
//        return eleveCollegeService.getEleveByNomAndPrenom(nom, prenom)
//                .map(ResponseEntity::ok)
//                .orElse(ResponseEntity.notFound().build());
//    }
//
//    @Operation(summary = "get les stats ")
//    @GetMapping("/stats")
//    public List<LyceeStatistiqueDto> getStatistiquesCollege() {
//        return eleveCollegeService.getStatistiquesParClasseCollege();
//    }
//
//    @Operation(summary = "get les eleves par classe  ")
//    @GetMapping("/{classe}")
//    public List<LyceeCollege> getElevesByClasseCollege(@PathVariable("classe") String classeStr) {
//        ClasseCOLLEGE classe;
//
//        try {
//            classe = ClasseCOLLEGE.valueOf(classeStr.toUpperCase()); // Ex: "cp1" => CP1
//        } catch (IllegalArgumentException e) {
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Classe invalide : " + classeStr);
//        }
//
//        return eleveCollegeService.getElevesByClasseCollege(classe);
//    }
//
//
//
//
//
//}
