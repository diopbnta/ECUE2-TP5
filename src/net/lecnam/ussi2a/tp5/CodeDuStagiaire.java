package net.lecnam.ussi2a.tp5;

import java.time.LocalDate;

public class CodeDuStagiaire {

    public static void main(String[] args) {

        Bibliotheque bib = new Bibliotheque();

        Auteur hugo = new Auteur(
                "Hugo",
                "Victor",
                LocalDate.of(1802, 2, 26)
        );

        Auteur zola = new Auteur(
                "Zola",
                "Émile",
                LocalDate.of(1840, 4, 2)
        );

        Auteur verne = new Auteur(
                "Verne",
                "Jules",
                LocalDate.of(1828, 2, 8)
        );

        Livre miserables = new Livre(
                hugo,
                "Les Misérables",
                "9782070409228",
                2
        );

        Livre germinal = new Livre(
                zola,
                "Germinal",
                "9782253004226",
                1
        );

        Livre tourDuMonde = new Livre(
                verne,
                "Le Tour du monde en 80 jours",
                "9782253012696",
                1
        );

        bib.ajouterLivre(miserables);
        bib.ajouterLivre(germinal);
        bib.ajouterLivre(tourDuMonde);

        // =========================
        // ÉTAPE 1
        // =========================

        System.out.println("\n=== Étape 1 : état initial ===");
        bib.afficherLivres();

        // =========================
        // ÉTAPE 2
        // =========================

        System.out.println("\n=== Étape 2 : emprunts de Germinal ===");

        System.out.println(
                bib.emprunter("9782253004226")
                        ? "Accepté : emprunt de Germinal"
                        : "Refusé : Germinal n'est plus disponible"
        );

        System.out.println(
                bib.emprunter("9782253004226")
                        ? "Accepté : deuxième emprunt"
                        : "Refusé : aucun exemplaire disponible"
        );

        System.out.println(
                bib.emprunter("9782253004226")
                        ? "Accepté : troisième emprunt"
                        : "Refusé : aucun exemplaire disponible"
        );

        System.out.println(germinal);

        // =========================
        // ÉTAPE 3
        // =========================

        System.out.println("\n=== Étape 3 : auteur contemporain ===");

        try {
            new Auteur(
                    "Dupont",
                    "Jean",
                    LocalDate.of(2090, 1, 1)
            );

            System.out.println("Accepté");

        } catch (IllegalArgumentException e) {
            System.out.println("Refusé : " + e.getMessage());
        }

        // =========================
        // ÉTAPE 4
        // =========================

        System.out.println("\n=== Étape 4 : correction du titre ===");

        tourDuMonde.setTitre("Le Tour du monde en 80 jours");

        try {
            tourDuMonde.setTitre("");

            System.out.println("Accepté");

        } catch (IllegalArgumentException e) {
            System.out.println("Refusé : " + e.getMessage());
        }

        System.out.println(tourDuMonde);

        // =========================
        // ÉTAPE 5
        // =========================

        System.out.println("\n=== Étape 5 : ajout d'un livre ===");

        Livre notreDame = new Livre(
                hugo,
                "Notre-Dame de Paris",
                "9782253096337",
                1
        );

        System.out.println(
                bib.ajouterLivre(notreDame)
                        ? "Accepté : livre ajouté"
                        : "Refusé : livre non ajouté"
        );

        System.out.println(bib);

        // =========================
        // ÉTAPE 6
        // =========================

        System.out.println("\n=== Étape 6 : tentative d'ajout d'un doublon ===");

        Livre doublon = new Livre(
                zola,
                "Un autre titre",
                "9782253004226",
                1
        );

        System.out.println(
                bib.ajouterLivre(doublon)
                        ? "Accepté : livre ajouté"
                        : "Refusé : ISBN déjà présent"
        );

        System.out.println(bib);

        System.out.println("\nFin du programme");
    }
}