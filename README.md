# ficher1-Categorie.java
java// classe qui représente une catégorie de dépense
public class Categorie {

    private String nom;
    private String description;

    // constructeur
    public Categorie(String nom, String description) {
        this.nom = nom;
        this.description = description;
    }

    // afficher les infos de la catégorie
    public void afficher() {
        System.out.println("Categorie   : " + nom);
        System.out.println("Description : " + description);
    }

    // getters
    public String getNom() {
        return nom;
    }

    public String getDescription() {
        return description;
    }

    // setters
    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
