Fichier 4 — GestionBudget.java
javaimport java.util.ArrayList;

// classe principale qui gère toutes les données de l'application
public class GestionBudget {

    private ArrayList<Transaction> transactions;
    private ArrayList<Budget> budgets;
    private ArrayList<Categorie> categories;

    // constructeur
    public GestionBudget() {
        transactions = new ArrayList<Transaction>();
        budgets = new ArrayList<Budget>();
        categories = new ArrayList<Categorie>();
    }

    // ajouter une catégorie
    public void ajouterCategorie(Categorie c) {
        categories.add(c);
        System.out.println("Categorie '" + c.getNom() + "' ajoutee !");
    }

    // ajouter une transaction
    public void ajouterTransaction(Transaction t) {
        transactions.add(t);

        // si c'est une dépense on met à jour le budget correspondant
        if (t.getType().equals("depense")) {
            for (int i = 0; i < budgets.size(); i++) {
                // on cherche le budget qui correspond à la catégorie
                if (budgets.get(i).getCategorie().getNom()
                        .equals(t.getCategorie().getNom())) {
                    budgets.get(i).ajouterDepense(t.getMontant());
                }
            }
        }
        System.out.println("Transaction ajoutee avec succes !");
    }

    // supprimer une transaction par son index
    public void supprimerTransaction(int index) {
        if (index < 0 || index >= transactions.size()) {
            System.out.println("Erreur : index invalide !");
        } else {
            System.out.println("Transaction '" +
                transactions.get(index).getDescription() + "' supprimee !");
            transactions.remove(index);
        }
    }

    // ajouter un budget
    public void ajouterBudget(Budget b) {
        budgets.add(b);
        System.out.println("Budget pour '" + b.getCategorie().getNom() + "' ajoute !");
    }

    // afficher tout l'historique des transactions
    public void afficherHistorique() {
        if (transactions.isEmpty()) {
            System.out.println("Aucune transaction enregistree.");
        } else {
            System.out.println("\n=== Historique des transactions ===");
            for (int i = 0; i < transactions.size(); i++) {
                System.out.println("Transaction n°" + (i + 1) + " :");
                transactions.get(i).afficher();
            }
        }
    }

    // afficher tous les budgets
    public void afficherBudgets() {
        if (budgets.isEmpty()) {
            System.out.println("Aucun budget defini.");
        } else {
            System.out.println("\n=== Etat des budgets ===");
            for (int i = 0; i < budgets.size(); i++) {
                budgets.get(i).afficher();
            }
        }
    }

    // afficher le résumé général (revenus, dépenses, solde)
    public void afficherResume() {
        double totalRevenus = 0;
        double totalDepenses = 0;

        // on parcourt toutes les transactions pour calculer les totaux
        for (int i = 0; i < transactions.size(); i++) {
            if (transactions.get(i).getType().equals("revenu")) {
                totalRevenus = totalRevenus + transactions.get(i).getMontant();
            } else {
                totalDepenses = totalDepenses + transactions.get(i).getMontant();
            }
        }

        double solde = totalRevenus - totalDepenses;

        System.out.println("\n======= RESUME FINANCIER =======");
        System.out.println("Total revenus  : " + totalRevenus + " FCFA");
        System.out.println("Total depenses : " + totalDepenses + " FCFA");
        System.out.println("Solde actuel   : " + solde + " FCFA");

        // on affiche un message selon le solde
        if (solde < 0) {
            System.out.println("Attention : vous etes en deficit !");
        } else {
            System.out.println("Bonne gestion !");
        }
        System.out.println("================================");
    }

    // afficher le résumé par catégorie
    public void afficherParCategorie() {
        System.out.println("\n=== Depenses par categorie ===");
        for (int i = 0; i < categories.size(); i++) {
            double total = 0;
            String nomCat = categories.get(i).getNom();
            for (int j = 0; j < transactions.size(); j++) {
                if (transactions.get(j).getType().equals("depense") &&
                    transactions.get(j).getCategorie().getNom().equals(nomCat)) {
                    total = total + transactions.get(j).getMontant();
                }
            }
            System.out.println(nomCat + " : " + total + " FCFA");
        }
    }

    public ArrayList<Categorie> getCategories() { return categories; }
    public ArrayList<Transaction> getTransactions() { return transactions; }
    public ArrayList<Budget> getBudgets() { return budgets; }
}
