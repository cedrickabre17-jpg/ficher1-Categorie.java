*Projet Java — Programmation Orientée Objet*
*Auteur : KABRE Cédric*
*Université Virtuelle du Burkina Faso (UVBF) — 2026*

---

## C'est quoi ce projet ?

C'est une application Java en console qui permet de gérer son *budget personnel*.
Elle permet d'enregistrer ses revenus et dépenses, de définir des budgets par catégorie,
et de suivre l'état de ses finances en temps réel.

---

## Ce que l'application peut faire

- ✅ Voir l'historique complet des transactions
- ✅ Ajouter une transaction (revenu ou dépense)
- ✅ Supprimer une transaction
- ✅ Suivre les budgets par catégorie
- ✅ Afficher un résumé financier (revenus, dépenses, solde)
- ✅ Voir les dépenses classées par catégorie
- ✅ Recevoir une alerte automatique si un budget est dépassé

---

## Comment lancer le projet ?

### 1. Prérequis
Il faut avoir *Java installé* sur ton ordinateur.
Pour vérifier, ouvre un terminal et tape :

java -version


### 2. Compiler le code

javac *.java


### 3. Lancer l'application

java Main


---

## Comment utiliser le menu ?

Quand tu lances l'application, ce menu s'affiche :


===== GESTION BUDGET PERSONNEL =====
1. Voir l'historique des transactions
2. Ajouter une transaction
3. Supprimer une transaction
4. Voir les budgets
5. Resume financier
6. Depenses par categorie
7. Quitter
Votre choix :


Il suffit de taper le *numéro* correspondant et d'appuyer sur Entrée.

---

## Structure du projet

Le projet est composé de *5 fichiers Java* :


GestionBudgetApp/
├── Categorie.java       → représente une catégorie de dépense
├── Transaction.java     → représente un revenu ou une dépense
├── Budget.java          → représente un budget alloué à une catégorie
├── GestionBudget.java   → gère toutes les données de l'application
└── Main.java            → lance l'application et affiche le menu


---

## Exemple d'utilisation


===== GESTION BUDGET PERSONNEL =====
Votre choix : 2
Description : Courses marché
Montant (FCFA) : 15000
Date (jj/mm/aaaa) : 03/06/2026
Type (revenu / depense) : depense
Categories disponibles :
1. Nourriture
2. Transport
3. Loisirs
Choisissez le numero de la categorie : 1
Transaction ajoutee avec succes !

===== GESTION BUDGET PERSONNEL =====
Votre choix : 5

======= RESUME FINANCIER =======
Total revenus  : 200000.0 FCFA
Total depenses : 15000.0 FCFA
Solde actuel   : 185000.0 FCFA
Bonne gestion !
================================


---

## Concepts POO utilisés

| Concept | Où on l'utilise |
|---|---|
| Classes | Categorie, Transaction, Budget, GestionBudget |
| Encapsulation | Attributs privés avec getters et setters |
| Constructeur | Chaque classe a son propre constructeur |
| ArrayList | Pour stocker les transactions, budgets et catégories |
| Gestion d'exceptions | try/catch sur tous les inputs utilisateur |

---

## Catégories disponibles par défaut

Au lancement de l'application, 3 catégories sont déjà créées :

| Catégorie | Description | Budget alloué |
|---|---|---|
| Nourriture | Alimentation quotidienne | 50 000 FCFA |
| Transport | Déplacement et carburant | 30 000 FCFA |
| Loisirs | Sorties et divertissements | 20 000 FCFA |

---

## Limites connues

- Les données sont *perdues* quand on ferme l'application (pas de base de données)
- On ne peut pas encore *modifier* une transaction existante
- Il n'y a pas encore de *graphiques* pour visualiser les dépenses

---

## Auteur

*KABRE Cédric*
Étudiant en L2 Génie logiciel — UVBF 2026

