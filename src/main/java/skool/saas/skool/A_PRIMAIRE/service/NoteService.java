package skool.saas.skool.A_PRIMAIRE.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import skool.saas.skool.A_PRIMAIRE.Dto.NoteDto;
import skool.saas.skool.A_PRIMAIRE.Entity.Eleve;
import skool.saas.skool.A_PRIMAIRE.Entity.Matiere;
import skool.saas.skool.A_PRIMAIRE.Entity.Note;
import skool.saas.skool.A_PRIMAIRE.enums.EvaluationPrimaire;
import skool.saas.skool.A_PRIMAIRE.enums.MatierePrimaire;
import skool.saas.skool.A_PRIMAIRE.repository.EleveRepository;
import skool.saas.skool.A_PRIMAIRE.repository.MatiereRepository;
import skool.saas.skool.A_PRIMAIRE.repository.NoteRepository;
import skool.saas.skool.GLOBALE.Entity.AnneeContext;
import skool.saas.skool.GLOBALE.Entity.AnneeScolaire;


@Service
public class NoteService {

    @Autowired
    private EleveRepository eleveRepository;

    @Autowired
    private NoteRepository noteRepository;

    @Autowired
    private MatiereRepository matiereRepository;



//    public void enregistrerNotes(NoteDto dto) {
//        Eleve eleve = eleveRepository.findById(dto.getEleveId())
//                .orElseThrow(() -> new RuntimeException("Élève introuvable"));
//
//        AnneeScolaire annee = AnneeContext.get();
//
//        for (NoteDto.MatiereNote noteDto : dto.getNotes()) {
//            Note note = new Note();
//            note.setEleve(eleve);
//            note.setAnneeScolaire(annee);
//            note.setClasse(dto.getClasse());
//            note.setValeurNote(noteDto.getValeurNote());
//            note.setEvaluationPrimaire(EvaluationPrimaire.valueOf(dto.getEvaluation()));
//
//            if (noteDto.getMatiereId() != null) {
//                Matiere matiere = matiereRepository.findById(noteDto.getMatiereId())
//                        .orElseThrow(() -> new RuntimeException("Matière personnalisée introuvable"));
//                note.setMatiere(matiere);
//            } else if (noteDto.getMatierePrimaire() != null) {
//                MatierePrimaire matiereEnum = MatierePrimaire.valueOf(noteDto.getMatierePrimaire());
//                note.setMatierePrimaire(matiereEnum);
//            } else {
//                throw new RuntimeException("Aucune matière spécifiée.");
//            }
//
//
//            noteRepository.save(note);
//        }
//    }


    public void mettreAJourNotes(NoteDto dto) {
        Eleve eleve = eleveRepository.findById(dto.getEleveId())
                .orElseThrow(() -> new RuntimeException("Élève introuvable"));
        AnneeScolaire annee = AnneeContext.get();

        for (NoteDto.MatiereNote noteDto : dto.getNotes()) {
            Note note = null;

            if (noteDto.getMatiereId() != null) {
                Matiere matiere = matiereRepository.findById(noteDto.getMatiereId())
                        .orElseThrow(() -> new RuntimeException("Matière personnalisée introuvable"));

                note = noteRepository.findByEleveAndClasseAndAnneeScolaireAndMatiereAndEvaluationPrimaire(
                        eleve, dto.getClasse(), annee, matiere,
                        EvaluationPrimaire.valueOf(dto.getEvaluation())
                ).orElse(null);

                if (note == null) {
                    note = new Note();
                    note.setMatiere(matiere);
                }

            } else if (noteDto.getMatierePrimaire() != null) {
                MatierePrimaire matiereEnum = MatierePrimaire.valueOf(noteDto.getMatierePrimaire());

                note = noteRepository.findByEleveAndClasseAndAnneeScolaireAndMatierePrimaireAndEvaluationPrimaire(
                        eleve, dto.getClasse(), annee, matiereEnum,
                        EvaluationPrimaire.valueOf(dto.getEvaluation())
                ).orElse(null);

                if (note == null) {
                    note = new Note();
                    note.setMatierePrimaire(matiereEnum);
                }

            } else {
                throw new RuntimeException("Aucune matière spécifiée.");
            }

            // mise à jour ou création dans les deux cas
            note.setEleve(eleve);
            note.setAnneeScolaire(annee);
            note.setClasse(dto.getClasse());
            note.setValeurNote(noteDto.getValeurNote());
            note.setEvaluationPrimaire(EvaluationPrimaire.valueOf(dto.getEvaluation()));

            noteRepository.save(note);
        }
    }


}

