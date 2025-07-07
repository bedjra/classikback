//package skool.saas.skool.GLOBALE.Entity;
//
//import jakarta.persistence.*;
//import lombok.Data;
//
//import java.time.LocalDate;
//
//@Entity
//@Data
//public class Licence {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(unique = true, nullable = false)
//    private String licenceKey; // ex : "ABCD-123-XYZ"
//
//    private LocalDate dateDebut;
//    private LocalDate dateFin;
//
//    private boolean active = true; // Pour pouvoir bloquer si besoin
//
//    @OneToOne
//    private Utilisateur utilisateur;
//
//}
