//package skool.saas.skool.C_LYCEE.Dto;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.EnumType;
//import jakarta.persistence.Enumerated;
//import skool.saas.skool.C_LYCEE.enums.ClasseLYCEE;
//
//import java.time.LocalDate;
//
//public class EleveLyceeDto {
//
//    private String matricule;
//    private String nom;
//    private String prenom;
//    private String adresse;
//
//    @Enumerated(EnumType.STRING)
//    @Column(nullable = false)
//    private ClasseLYCEE classe;
//
//    private String serie;
//    private String sexe;
//    private String lieuNais;
//    private String etblProv;
//    private String nationnalite;
//    private LocalDate dateNaiss;
//    private String photo;
//
//
//
//    private String tuteurNom;
//
//    private String tuteurTelephone;
//    private String tuteurProfession;
//
//
//
//    // Getters et Setters...
//    public String getMatricule() {
//        return matricule;
//    }
//
//    public void setMatricule(String matricule) {
//        this.matricule = matricule;
//    }
//
//    public String getNom() {
//        return nom;
//    }
//
//    public void setNom(String nom) {
//        this.nom = nom;
//    }
//
//    public String getPrenom() {
//        return prenom;
//    }
//
//    public void setPrenom(String prenom) {
//        this.prenom = prenom;
//    }
//
//    public String getAdresse() {
//        return adresse;
//    }
//
//    public void setAdresse(String adresse) {
//        this.adresse = adresse;
//    }
//
//    public ClasseLYCEE getClasse() {
//        return classe;
//    }
//
//    public void setClasse(ClasseLYCEE classe) {
//        this.classe = classe;
//    }
//
//    public String getSerie() {
//        return serie;
//    }
//
//    public void setSerie(String serie) {
//        this.serie = serie;
//    }
//
//    public String getSexe() {
//        return sexe;
//    }
//
//    public void setSexe(String sexe) {
//        this.sexe = sexe;
//    }
//
//    public String getLieuNais() {
//        return lieuNais;
//    }
//
//    public void setLieuNais(String lieuNais) {
//        this.lieuNais = lieuNais;
//    }
//
//    public String getEtblProv() {
//        return etblProv;
//    }
//
//    public void setEtblProv(String etblProv) {
//        this.etblProv = etblProv;
//    }
//
//    public String getNationnalite() {
//        return nationnalite;
//    }
//
//    public void setNationnalite(String nationnalite) {
//        this.nationnalite = nationnalite;
//    }
//
//    public LocalDate getDateNaiss() {
//        return dateNaiss;
//    }
//
//    public void setDateNaiss(LocalDate dateNaiss) {
//        this.dateNaiss = dateNaiss;
//    }
//
//    public byte[] getPhoto() {
//        return photo.getBytes();
//    }
//
//    public void setPhoto(byte[] photo) {
//        this.photo = photo;
//    }
//
//    public String getTuteurNom() {
//        return tuteurNom;
//    }
//
//    public void setTuteurNom(String tuteurNom) {
//        this.tuteurNom = tuteurNom;
//    }
//
//
//    public String getTuteurTelephone() {
//        return tuteurTelephone;
//    }
//
//    public void setTuteurTelephone(String tuteurTelephone) {
//        this.tuteurTelephone = tuteurTelephone;
//    }
//
//    public String getTuteurProfession() {
//        return tuteurProfession;
//    }
//
//    public void setTuteurProfession(String tuteurProfession) {
//        this.tuteurProfession = tuteurProfession;
//    }
//}
