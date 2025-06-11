package modele;

public class Facture {
	private static int ID;
	private int numero;

	private CotisationAnnuelle data;
	private Personne personne;
	private String date;

	public Facture(Personne personne, String date) {
		numero = ID;
		ID++;
		this.personne = personne;
		this.data = personne.getMaCotisation();
		this.date = date;
	}

	/* Getters/Setters... */
	public void setCotisation(CotisationAnnuelle cA) {
		data = cA;
	}

	public String getDate() {
		return date;
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
