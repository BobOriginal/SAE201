package modele;

public abstract class Cours {
	private int id;
	private int annee;
	private int nbHeure;
	private String intituler;
	private static int nbCours = 0;
	public Cours(int annee, int nbHeure, String intituler) {
		super();
		this.annee = annee;
		this.nbHeure = nbHeure;
		this.intituler = intituler;
		id = nbCours;
		nbCours++;
	}
}
