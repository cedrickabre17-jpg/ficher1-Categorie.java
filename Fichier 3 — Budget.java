Fichier 3 — Budget.java
java// classe qui représente un budget alloué à une catégorie
public class Budget {

    private Categorie categorie;
    private double montantAlloue;
    private double montantDepense;
    private String periode; // exemple : "Juin 2026"

    // constructeur
    public Budget(Categorie categorie, double montantAlloue, String periode) {
        this.categorie = categorie;
        this.montantAlloue = montantAlloue;
        this.montantDepense = 0; // au départ rien n'est dépensé
        this.periode = periode;
    }

    // ajouter une dépense au budget
    public void ajouterDepense(double montant) {
        montantDepense = montantDepense + montant;

        // on alerte si le budget est dépassé
        if (montantDepense > montantAlloue) {
            System.out.println(">>> ALERTE : Budget depasse pour la categorie '"
                               + categorie.getNom() + "' ! <<<");
        }
    }

    // calculer le montant restant
    public double getMontantRestant() {
        return montantAlloue - montantDepense;
    }

    // afficher les détails du budget
    public void afficher() {
        System.out.println("----------------------------------");
        System.out.println("Categorie   : " + categorie.getNom());
        System.out.println("Periode     : " + periode);
        System.out.println("Alloue      : " + montantAlloue + " FCFA");
        System.out.println("Depense     : " + montantDepense + " FCFA");
        System.out.println("Restant     : " + getMontantRestant() + " FCFA");

        // on affiche si le budget est dépassé ou non
        if (montantDepense > montantAlloue) {
            System.out.println("Statut      : DEPASSE !");
        } else {
            System.out.println("Statut      : OK");
        }
        System.out.println("----------------------------------");
    }

    // getters
    public Categorie getCategorie() { return categorie; }
    public double getMontantAlloue() { return montantAlloue; }
    public double getMontantDepense() { return montantDepense; }
    public String getPeriode() { return periode; }

    // setter
    public void setMontantAlloue(double montantAlloue) {
        this.montantAlloue = montantAlloue;
    }
}
