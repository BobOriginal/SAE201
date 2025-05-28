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
	public int getNbHeure() {
		return nbHeure;
	}
	public void setNbHeure(int nbHeure) {
		this.nbHeure = nbHeure;
	}
	public int getId() {
		return id;
	}
	public int getAnnee() {
		return annee;
	}
	public String getIntituler() {
		return intituler;
	}
	public static int getNbCours() {
		return nbCours;
	}
	
	
}
