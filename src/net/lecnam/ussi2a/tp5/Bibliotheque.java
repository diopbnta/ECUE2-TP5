package net.lecnam.ussi2a.tp5;

public class Bibliotheque {

    private final Livre[] livres = new Livre[100];
    private int nbLivres = 0;

    public boolean ajouterLivre(Livre livre) {

        if (livre == null) {
            return false;
        }

        if (estPleine()) {
            return false;
        }

        if (rechercherLivre(livre.getIsbn()) != null) {
            return false;
        }

        livres[nbLivres] = livre;
        nbLivres++;

        return true;
    }

    public int getNbLivres() {
        return nbLivres;
    }

    public boolean estPleine() {
        return nbLivres >= livres.length;
    }

    public Livre rechercherLivre(String isbn) {

        if (isbn == null) {
            return null;
        }

        for (int i = 0; i < nbLivres; i++) {
            if (livres[i].getIsbn().equals(isbn)) {
                return livres[i];
            }
        }

        return null;
    }

    public boolean emprunter(String isbn) {

        Livre livre = rechercherLivre(isbn);

        if (livre == null) {
            return false;
        }

        return livre.emprunter();
    }

    public boolean rendre(String isbn) {

        Livre livre = rechercherLivre(isbn);

        if (livre == null) {
            return false;
        }

        return livre.rendre();
    }

    public void afficherLivres() {
        System.out.println(this);

        for (int i = 0; i < nbLivres; i++) {
            System.out.println(livres[i]);
        }
    }

    @Override
    public String toString() {
        return "Bibliothèque : " + nbLivres + "/100 livres";
    }
}