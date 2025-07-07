//package skool.saas.skool.C_LYCEE.service;
//
//import jakarta.persistence.EntityNotFoundException;
//import jakarta.transaction.Transactional;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Service;
//import org.springframework.web.server.ResponseStatusException;
//import skool.saas.skool.C_LYCEE.Dto.EleveLyceeDto;
//import skool.saas.skool.C_LYCEE.Entity.EleveLycee;
//import skool.saas.skool.C_LYCEE.Entity.TuteurLycee;
//import skool.saas.skool.C_LYCEE.enums.ClasseLYCEE;
//import skool.saas.skool.C_LYCEE.repository.EleveLyceeRepository;
//import skool.saas.skool.C_LYCEE.repository.TuteurLyceeRepository;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class EleveLyceeService {
//
//    @Autowired
//    private EleveLyceeRepository eleveLyceeRepository;
//
//    @Autowired
//    private TuteurLyceeRepository tuteurLyceeRepository;
//
//    @Transactional
//    public EleveLycee ajouterEleve(EleveLyceeDto dto) {
//        Optional<TuteurLycee> optionalTuteur = tuteurLyceeRepository
//                .findByNomIgnoreCaseAndPrenomIgnoreCase(dto.getTuteurNom(), dto.getPrenom());
//
//        TuteurLycee tuteur;
//        if (optionalTuteur.isPresent()) {
//            tuteur = optionalTuteur.get();
//        } else {
//            tuteur = new TuteurLycee();
//            tuteur.setNom(dto.getTuteurNom());
//            tuteur.setPrenom(dto.getPrenom());
//            tuteur.setTelephone(dto.getTuteurTelephone());
//            tuteur.setProfession(dto.getTuteurProfession());
//            tuteur = tuteurLyceeRepository.save(tuteur);
//        }
//
//        EleveLycee eleve = new EleveLycee();
//        eleve.setMatricule(dto.getMatricule());
//        eleve.setNom(dto.getNom());
//        eleve.setPrenom(dto.getPrenom());
//        eleve.setAdresse(dto.getAdresse());
//        eleve.setClasse(dto.getClasse());
//        eleve.setSerie(dto.getSerie());
//        eleve.setSexe(dto.getSexe());
//        eleve.setLieuNais(dto.getLieuNais());
//        eleve.setEtblProv(dto.getEtblProv());
//        eleve.setNationnalite(dto.getNationnalite());
//        eleve.setDateNaiss(dto.getDateNaiss());
//        eleve.setPhoto(dto.getPhoto());
//        eleve.setTuteur(tuteur);
//
//        return eleveLyceeRepository.save(eleve);
//    }
//
//    @Transactional
//    public EleveLycee modifierEleve(Long id, EleveLyceeDto dto) {
//        EleveLycee eleve = eleveLyceeRepository.findById(id)
//                .orElseThrow(() -> new EntityNotFoundException("Élève non trouvé avec l’ID: " + id));
//
//        eleve.setMatricule(dto.getMatricule());
//        eleve.setNom(dto.getNom());
//        eleve.setPrenom(dto.getPrenom());
//        eleve.setAdresse(dto.getAdresse());
//        eleve.setClasse(dto.getClasse());
//        eleve.setSerie(dto.getSerie());
//        eleve.setSexe(dto.getSexe());
//        eleve.setLieuNais(dto.getLieuNais());
//        eleve.setEtblProv(dto.getEtblProv());
//        eleve.setNationnalite(dto.getNationnalite());
//        eleve.setDateNaiss(dto.getDateNaiss());
//        eleve.setPhoto(dto.getPhoto());
//
//        Optional<TuteurLycee> optionalTuteur = tuteurLyceeRepository
//                .findByNomIgnoreCaseAndPrenomIgnoreCase(dto.getTuteurNom(), dto.getPrenom());
//
//        TuteurLycee tuteur;
//        if (optionalTuteur.isPresent()) {
//            tuteur = optionalTuteur.get();
//        } else {
//            tuteur = new TuteurLycee();
//            tuteur.setNom(dto.getTuteurNom());
//            tuteur.setPrenom(dto.getPrenom());
//            tuteur.setTelephone(dto.getTuteurTelephone());
//            tuteur.setProfession(dto.getTuteurProfession());
//            tuteur = tuteurLyceeRepository.save(tuteur);
//        }
//
//        eleve.setTuteur(tuteur);
//
//        return eleveLyceeRepository.save(eleve);
//    }
//
//    public void supprimerEleve(Long id) {
//        if (!eleveLyceeRepository.existsById(id)) {
//            throw new EntityNotFoundException("Élève non trouvé avec l’ID: " + id);
//        }
//        eleveLyceeRepository.deleteById(id);
//    }
//
//    public List<EleveLycee> getElevesByClasse(ClasseLYCEE classe) {
//        return eleveLyceeRepository.findByClasse(classe);
//    }
//
//    public Optional<EleveLycee> getEleveByNomAndPrenom(String nom, String prenom) {
//        return eleveLyceeRepository.findByNomIgnoreCaseAndPrenomIgnoreCase(nom, prenom);
//    }
//
//    public EleveLyceeDto getEleveById(Long id) {
//        EleveLycee eleve = eleveLyceeRepository.findById(id)
//                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Élève non trouvé avec l'id : " + id));
//
//        EleveLyceeDto dto = new EleveLyceeDto();
//        dto.setMatricule(eleve.getMatricule());
//        dto.setNom(eleve.getNom());
//        dto.setPrenom(eleve.getPrenom());
//        dto.setAdresse(eleve.getAdresse());
//        dto.setClasse(eleve.getClasse());
//        dto.setSerie(eleve.getSerie());
//        dto.setSexe(eleve.getSexe());
//        dto.setLieuNais(eleve.getLieuNais());
//        dto.setEtblProv(eleve.getEtblProv());
//        dto.setNationnalite(eleve.getNationnalite());
//        dto.setDateNaiss(eleve.getDateNaiss());
//        dto.setPhoto(eleve.getPhoto());
//
//        if (eleve.getTuteur() != null) {
//            dto.setTuteurNom(eleve.getTuteur().getNom());
//            dto.setTuteurTelephone(eleve.getTuteur().getTelephone());
//            dto.setTuteurProfession(eleve.getTuteur().getProfession());
//        }
//
//        return dto;
//    }
//
//}
