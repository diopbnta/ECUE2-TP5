package net.lecnam.ussi2a.tp5;

/**
 * Livre avec encapsulation et règles métier.
 */
public class Livre {

    private final Auteur auteur;
    private String titre;
    private final String isbn;
    private final int nbExemplaires;
    private int nbDisponibles;

    public Livre(Auteur auteur, String titre, String isbn, int nbExemplaires) {

        if (auteur == null) {
            throw new IllegalArgumentException("L'auteur est obligatoire");
        }

        verifierTitre(titre);

        if (isbn == null || isbn.isBlank()) {
            throw new IllegalArgumentException("L'ISBN est obligatoire");
        }

        if (nbExemplaires < 1) {
            throw new IllegalArgumentException("Le livre doit avoir au moins 1 exemplaire");
        }

        this.auteur = auteur;
        this.titre = titre;
        this.isbn = isbn;
        this.nbExemplaires = nbExemplaires;
        this.nbDisponibles = nbExemplaires;
    }

    private void verifierTitre(String titre) {
        if (titre == null || titre.isBlank()) {
            throw new IllegalArgumentException("Le titre est obligatoire");
        }
    }

    public Auteur getAuteur() {
        return auteur;
    }

    public String getTitre() {
        return titre;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getNbExemplaires() {
        return nbExemplaires;
    }

    public int getNbDisponibles() {
        return nbDisponibles;
    }

    public void setTitre(String titre) {
        verifierTitre(titre);
        this.titre = titre;
    }

    public boolean estDisponible() {
        return nbDisponibles > 0;
    }

    public boolean emprunter() {
        if (!estDisponible()) {
            return false;
        }

        nbDisponibles--;
        return true;
    }

    public boolean rendre() {
        if (nbDisponibles >= nbExemplaires) {
            return false;
        }

        nbDisponibles++;
        return true;
    }

    public boolean aLeMemeIsbnQue(Livre autre) {
        return autre != null && this.isbn.equals(autre.isbn);
    }

    @Override
    public String toString() {
        return "[" + isbn + "] " + titre + " - " + auteur
                + " - " + nbDisponibles + "/" + nbExemplaires
                + " disponible(s)";
    }
}

