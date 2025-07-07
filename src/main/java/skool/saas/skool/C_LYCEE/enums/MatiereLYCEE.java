package skool.saas.skool.C_LYCEE.enums;

public enum MatiereLYCEE {
    MATHEMATIQUES("Mathématiques"),
    PHYSIQUE_CHIMIE("Physique-Chimie"),
    SVT("SVT"),


    ALLEMAND("Allemand"),
    ANGLAIS("Anglais"),
    FRANCAIS("Français"),
    ESPAGNOL("Espagnol"),
    ECM("ECM"),
    HISTOIRE_GEOGRAPHIE("Histoire-Géographie"),



    EPS("EPS"),
    DESSIN("DESSIN"),
    MUSIQUE("Musique");


    private final String label;

    MatiereLYCEE(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
