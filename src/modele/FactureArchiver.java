package modele;

public class FactureArchiver {
    private Personne personne;
    private int id;

    public FactureArchiver(Personne personne, int id) {
        this.personne = personne;
        this.id = id;
    }

    public Personne getPersonne() {
        return personne;
    }

    public int getId() {
        return id;
    }
}
