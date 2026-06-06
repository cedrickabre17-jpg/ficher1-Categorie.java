Fichier 5 — Main.java
javaimport java.util.Scanner;

// fichier principal qui lance l'application
public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        GestionBudget app = new GestionBudget();

        // on crée des catégories de départ
        Categorie nourriture = new Categorie("Nourriture", "Alimentation quotidienne");
        Categorie transport = new Categorie("Transport", "Deplacement et carburant");
        Categorie loisirs = new Categorie("Loisirs", "Sorties et divertissements");
        app.ajouterCategorie(nourriture);
        app.ajouterCategorie(transport);
        app.ajouterCategorie(loisirs);

        // on crée des budgets de départ
        app.ajouterBudget(new Budget(nourriture, 50000, "Juin 2026"));
        app.ajouterBudget(new Budget(transport, 30000, "Juin 2026"));
        app.ajouterBudget(new Budget(loisirs, 20000, "Juin 2026"));

        // on ajoute quelques transactions de test
        app.ajouterTransaction(new Transaction("Salaire", 200000,
                               "01/06/2026", "revenu", nourriture));
        app.ajouterTransaction(new Transaction("Courses marche", 15000,
                               "02/06/2026", "depense", nourriture));
        app.ajouterTransaction(new Transaction("Taxi", 5000,
                               "03/06/2026", "depense", transport));

        int choix = 0;

        // boucle principale du menu
        while (choix != 7) {

            System.out.println("\n===== GESTION BUDGET PERSONNEL =====");
            System.out.println("1. Voir l'historique des transactions");
            System.out.println("2. Ajouter une transaction");
            System.out.println("3. Supprimer une transaction");
            System.out.println("4. Voir les budgets");
            System.out.println("5. Resume financier");
            System.out.println("6. Depenses par categorie");
            System.out.println("7. Quitter");
            System.out.print("Votre choix : ");

            // on gère le cas où l'utilisateur entre autre chose qu'un chiffre
            try {
                choix = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Erreur : entrez un chiffre entre 1 et 7 !");
                continue;
            }

            // option 1 : historique
            if (choix == 1) {
                app.afficherHistorique();

            // option 2 : ajouter une transaction
            } else if (choix == 2) {
                System.out.print("Description : ");
                String desc = scanner.nextLine();

                System.out.print("Montant (FCFA) : ");
                double montant = 0;
                try {
                    montant = Double.parseDouble(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Erreur : montant invalide !");
                    continue;
                }

                System.out.print("Date (jj/mm/aaaa) : ");
                String date = scanner.nextLine();

                System.out.print("Type (revenu / depense) : ");
                String type = scanner.nextLine();

                // afficher les catégories disponibles
                System.out.println("Categories disponibles :");
                for (int i = 0; i < app.getCategories().size(); i++) {
                    System.out.println((i + 1) + ". " +
                        app.getCategories().get(i).getNom());
                }
                System.out.print("Choisissez le numero de la categorie : ");
                int numCat = 0;
                try {
                    numCat = Integer.parseInt(scanner.nextLine()) - 1;
                } catch (NumberFormatException e) {
                    System.out.println("Erreur : numero invalide !");
                    continue;
                }

                if (numCat < 0 || numCat >= app.getCategories().size()) {
                    System.out.println("Erreur : categorie introuvable !");
                } else {
                    try {
                        Categorie cat = app.getCategories().get(numCat);
                        Transaction t = new Transaction(desc, montant, date, type, cat);
                        app.ajouterTransaction(t);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Erreur : " + e.getMessage());
                    }
                }

            // option 3 : supprimer une transaction
            } else if (choix == 3) {
                app.afficherHistorique();
                System.out.print("Numero de la transaction a supprimer : ");
                try {
                    int index = Integer.parseInt(scanner.nextLine()) - 1;
                    app.supprimerTransaction(index);
                } catch (NumberFormatException e) {
                    System.out.println("Erreur : entrez un nombre valide !");
                }

            // option 4 : voir les budgets
            } else if (choix == 4) {
                app.afficherBudgets();

            // option 5 : résumé financier
            } else if (choix == 5) {
                app.afficherResume();

            // option 6 : dépenses par catégorie
            } else if (choix == 6) {
                app.afficherParCategorie();

            // option 7 : quitter
            } else if (choix == 7) {
                System.out.println("Au revoir !");

            } else {
                System.out.println("Choix invalide ! Entrez un chiffre entre 1 et 7.");
            }
        }

        scanner.close();
    }
}
