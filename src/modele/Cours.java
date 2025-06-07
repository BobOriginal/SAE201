package modele;

public abstract class Cours {
	private int id;
	private int annee;
	private Double nbHeure;
	private String intituler;
	private static int nbCours = 0;
<<<<<<< HEAD
	public Cours(int annee, int nbHeure, String intituler) {
=======
	public Cours(int annee, Double nbHeure, String intituler) {
>>>>>>> Tom
		super();
		this.annee = annee;
		this.nbHeure = nbHeure;
		this.intituler = intituler;
		id = nbCours;
		nbCours++;
	}
<<<<<<< HEAD
	public int getNbHeure() {
		return nbHeure;
	}
	public void setNbHeure(int nbHeure) {
=======
	public Double getNbHeure() {
		return nbHeure;
	}
	public void setNbHeure(Double nbHeure) {
>>>>>>> Tom
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
