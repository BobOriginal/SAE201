package modele;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class InfoTabViewCours {
    private Cours cours;
    private StringProperty libelle = new SimpleStringProperty();
    private DoubleProperty prix = new SimpleDoubleProperty();
    private DoubleProperty nbHeure = new SimpleDoubleProperty();

    public InfoTabViewCours(Cours c, Personne p) {
        cours = c;
        libelle.set(cours.getIntituler());
        nbHeure.set(cours.getNbHeure());

        if (p.getStatus().equals(Personne.ELEVE_TARIF_REDUIT)) {
            prix.set(Donnee.prixCourTarifReduit.get(nbHeure.get()));
        } else if (p.getStatus().equals(Personne.ELEVE_PLEIN_TARIF)) {
            prix.set(Donnee.prixCourPleinTarif.get(nbHeure.get()));
        }
    }

    public void setLibelle(String l) {
        libelle.set(l);
    }

    public void setPrix(double p) {
        prix.set(p);
    }

    public void setNbHeure(double h) {
        nbHeure.set(h);
    }

    public String getLibelle() {
        return libelle.get();
    }

    public double getPrix() {
        return prix.get();
    }

    public double getNbHeure() {
        return nbHeure.get();
    }

    public StringProperty libelleProperty() {
        return libelle;
    }

    public DoubleProperty prixProperty() {
        return prix;
    }

    public DoubleProperty nbHeureProperty() {
        return nbHeure;
    }
}
