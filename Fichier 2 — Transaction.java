java// classe qui représente une transaction (revenu ou dépense)
public class Transaction {

    private String description;
    private double montant;
    private String date;
    private String type; // "revenu" ou "depense"
    private Categorie categorie;

    // constructeur
    public Transaction(String description, double montant,
                       String date, String type, Categorie categorie) {
        // on vérifie que le montant est positif
        if (montant <= 0) {
            throw new IllegalArgumentException("Erreur : le montant doit etre superieur a 0 !");
        }
        // on vérifie que le type est valide
        if (!type.equals("revenu") && !type.equals("depense")) {
            throw new IllegalArgumentException("Erreur : le type doit etre 'revenu' ou 'depense' !");
        }
        this.description = description;
        this.montant = montant;
        this.date = date;
        this.type = type;
        this.categorie = categorie;
    }

    // afficher les détails de la transaction
    public void afficher() {
        System.out.println("----------------------------------");
        System.out.println("Description : " + description);
        System.out.println("Montant     : " + montant + " FCFA");
        System.out.println("Date        : " + date);
        System.out.println("Type        : " + type);
        System.out.println("Categorie   : " + categorie.getNom());
        System.out.println("----------------------------------");
    }

    // getters
    public String getDescription() { return description; }
    public double getMontant() { return montant; }
    public String getDate() { return date; }
    public String getType() { return type; }
    public Categorie getCategorie() { return categorie; }

    // setters
    public void setDescription(String description) { this.description = description; }
    public void setMontant(double montant) { this.montant = montant; }
}
