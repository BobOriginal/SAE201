package modele;

import java.util.ArrayList;
import java.util.Calendar;

import Exceptions.DoublonCoursException;
import Exceptions.StatusException;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Personne {
	final static String ELEVE_TARIF_REDUIT = "tarif reduit";
	final static String ELEVE_PLEIN_TARIF = "plein tarif";
	final static String NON_INSCRIT = "non inscrit";
	private int id;
	private StringProperty nom = new SimpleStringProperty();
	private StringProperty prenom = new SimpleStringProperty();
	private StringProperty status = new SimpleStringProperty();
	private StringProperty sexe = new SimpleStringProperty();
	private ArrayList<Cours> mesCours;
	private IntegerProperty nbHeureCours = new SimpleIntegerProperty();
	private CotisationAnnuelle maCotisation;
	static int nbPersonne = 0;
	private StringProperty adresse = new SimpleStringProperty();
	private StringProperty codePostal = new SimpleStringProperty();
	private StringProperty ville = new SimpleStringProperty();

	private boolean factureArchiver = false;

	public Personne(String nom, String prenom, String status, String adresse, String typePaiment, String sexe)
			throws StatusException {

		super();

		// A terme, devra être passer en paramètre.
		ville.set(" lannion");
		codePostal.set("22300");

		this.nom.set(nom);
		this.prenom.set(prenom);
		this.adresse.set(adresse);
		this.sexe.set(sexe);

		if (status == ELEVE_TARIF_REDUIT ||
				status == ELEVE_PLEIN_TARIF ||
				status == NON_INSCRIT) {
			this.status.set(status);
		} else {
			throw new StatusException();
		}
		id = nbPersonne;
		nbPersonne++;
		mesCours = new ArrayList<Cours>();
		Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);
		maCotisation = new CotisationAnnuelle(year, typePaiment, this);
	}

	public StringProperty getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom.set(nom);
	}

	public StringProperty getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom.set(prenom);
	}

	public StringProperty getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status.set(status);
	}

	public int getId() {
		return id;
	}

	public static int getNbPersonne() {
		return nbPersonne;
	}

	public ArrayList<Cours> getMesCours() {
		return mesCours;
	}

	public IntegerProperty getNbHeureCours() {
		return nbHeureCours;
	}

	private void addCours(Cours c) {
		mesCours.add(c);
		nbHeureCours.add(c.getNbHeure());
	}

	public StringProperty getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse.set(adresse);
	}

	public CotisationAnnuelle getMaCotisation() {
		return maCotisation;
	}

	public StringProperty getSexe() {
		return sexe;
	}

	public StringProperty getCodePostal() {
		return codePostal;
	}

	public StringProperty getVille() {
		return ville;
	}

	public boolean getEtatArchivage() {
		return factureArchiver;
	}

	public void setEtatArchivage(boolean nouvelEtat) {
		factureArchiver = nouvelEtat;
	}

	public void ajouterUnCours(Cours c) {
		try {
			if (c == null) {
				throw new NullPointerException();
			} else if (mesCours.contains(c)) {
				throw new DoublonCoursException();
			}
			addCours(c);
		} catch (NullPointerException e) {
			System.out.println("Cours valeur null");
		} catch (DoublonCoursException e) {
		}
	}

	public void payer(Double valeur) {
		Double dejaPayer = maCotisation.getDejaPayer() + valeur;
		Double resteApayer = maCotisation.getResteAPayer() - valeur;
		maCotisation.setDejaPayer(dejaPayer);
		maCotisation.setResteAPayer(resteApayer);
	}

}