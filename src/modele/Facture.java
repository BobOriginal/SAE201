package modele;

public class Facture {
	private static int ID;
	private int numero;

	private CotisationAnnuelle data;
	private Personne personne;

	public Facture(Personne personne) {
		numero = ID;
		ID++;
		this.personne = personne;
	}

	/* Getters/Setters... */
	public void setCotisation(CotisationAnnuelle cA) {
		data = cA;
	}

	public Personne getPersonne() {
		return personne;
	}

	public CotisationAnnuelle getCotisation() {
		return data;
	}

	public int getNumero() {
		return numero;
	}
}
