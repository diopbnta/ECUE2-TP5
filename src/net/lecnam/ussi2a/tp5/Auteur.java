package net.lecnam.ussi2a.tp5;

import java.time.LocalDate;
import java.time.Period;

public class Auteur {

    private final String nom;
    private final String prenom;
    private final LocalDate dateNaissance;

    public Auteur(String nom, String prenom, LocalDate dateNaissance) {

        if (nom == null || nom.isBlank()) {
            throw new IllegalArgumentException("Le nom est obligatoire");
        }

        if (dateNaissance == null) {
            throw new IllegalArgumentException("La date de naissance est obligatoire");
        }

        if (dateNaissance.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("La date de naissance ne peut pas être dans le futur");
        }

        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public int getAge() {
        return Period.between(dateNaissance, LocalDate.now()).getYears();
    }

    @Override
    public String toString() {
        return prenom + " " + nom + " (" + getAge() + " ans)";
    }
}