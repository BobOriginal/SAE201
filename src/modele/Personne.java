package modele;

import java.util.ArrayList;
import java.util.Calendar;

import Exceptions.DoublonCoursException;
import Exceptions.StatusException;
import Exceptions.TropDeCoursExecption;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Personne {
	final static String ELEVE_TARIF_REDUIT = "tarif reduit";
	final static String ELEVE_PLEIN_TARIF = "plein tarif";
	public final static String NON_INSCRIT = "non inscrit";
	private int id;
	private StringProperty nom = new SimpleStringProperty();
	private StringProperty prenom = new SimpleStringProperty();
	private StringProperty status = new SimpleStringProperty();
	private StringProperty sexe = new SimpleStringProperty();
	private ArrayList<Cours> mesCours;
	private DoubleProperty nbHeureCours = new SimpleDoubleProperty();
	private CotisationAnnuelle maCotisation;
	static int nbPersonne = 0;
	private StringProperty adresse = new SimpleStringProperty();
	private StringProperty codePostal = new SimpleStringProperty();
	private StringProperty ville = new SimpleStringProperty();
	private BooleanProperty factureArchiver = new SimpleBooleanProperty();

	public Personne(String nom, String prenom, String status, String adresse, String typePaiment, String sexe,
			String ville, String codePostal) throws StatusException {
		super();

		factureArchiver.set(false);
		this.ville.set(ville);
		this.codePostal.set(codePostal);
		this.nom.set(nom);
		this.prenom.set(prenom);
		this.adresse.set(adresse);
		this.sexe.set(sexe);

		nbHeureCours.set(0.0);
		if (status == ELEVE_TARIF_REDUIT ||
				status == ELEVE_PLEIN_TARIF ||
				status == NON_INSCRIT) {
			this.status.set(status);
		} else {
			throw new StatusException();
		}
		id = nbPersonne++;
		mesCours = new ArrayList<Cours>();
		Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);
		maCotisation = new CotisationAnnuelle(year, typePaiment, this);
	}

	public String getNom() {
		return nom.get();
	}

	public StringProperty nomProperty() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom.set(nom);
	}

	public String getPrenom() {
		return prenom.get();
	}

	public StringProperty prenomProperty() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom.set(prenom);
	}

	public String getStatus() {
		return status.get();
	}

	public StringProperty statusProperty() {
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

	public Double getNbHeureCours() {
		return nbHeureCours.get();
	}

	public DoubleProperty nbHeureCoursProperty() {
		return nbHeureCours;
	}

	public String getAdresse() {
		return adresse.get();
	}

	public String getVille() {
		return ville.get();
	}

	public void setVille(String v) {
		ville.set(v);
	}

	public void setSexe(String s) {
		sexe.set(s);
	}

	public String getSexe() {
		return sexe.get();
	}

	public String getCodePostal() {
		return codePostal.get();
	}

	public void setCodePostal(String cp) {
		codePostal.set(cp);
	}

	public void setAdresse(String adresse) {
		this.adresse.set(adresse);
	}

	public StringProperty adresseProperty() {
		return adresse;
	}

	public CotisationAnnuelle getMaCotisation() {
		return maCotisation;
	}

	public StringProperty sexeProperty() {
		return sexe;
	}

	public StringProperty codePostalProperty() {
		return codePostal;
	}

	public StringProperty villeProperty() {
		return ville;
	}

	public boolean getEtatArchivage() {
		return factureArchiver.get();
	}

	public void setEtatArchivage(boolean nouvelEtat) {
		factureArchiver.set(nouvelEtat);
	}
	public void retirerCour(Cours c) {
		mesCours.remove(c);
		nbHeureCours.set(nbHeureCours.get() - c.getNbHeure());
		maCotisation.calculTotal(this);
	}
	private void addCours(Cours c) {
		mesCours.add(c);
		nbHeureCours.set(nbHeureCours.get() + c.getNbHeure());
		maCotisation.calculTotal(this);
		maCotisation.calculPrixCour(this);
		maCotisation.calculdejaPayerCour(this);
	}

	public void ajouterUnCours(Cours c) throws TropDeCoursExecption {
		try {
			if (c == null) {
				throw new NullPointerException();
			} else if (mesCours.contains(c)) {
				throw new DoublonCoursException();
			} else if (status.get().equals(NON_INSCRIT)) {
				throw new StatusException();
			} else if (status.get().equals(ELEVE_PLEIN_TARIF) && ((nbHeureCours.get()) + c.getNbHeure()) > 7.5) {
				throw new TropDeCoursExecption();
			} else if (status.get().equals(ELEVE_TARIF_REDUIT) && ((nbHeureCours.get()) + c.getNbHeure()) > 5.0) {
				throw new TropDeCoursExecption();
			}
			addCours(c);
		} catch (NullPointerException e) {
			System.out.println("Cours valeur null");
		} catch (DoublonCoursException e) {
		} catch (StatusException e) {
			System.out.println("On ne peux pas ajouter un cours a une personne non inscrit");

		}
	}
	
	public void payer(Integer valeur) {
		Integer dejaPayer = maCotisation.getDejaPayer() + valeur;
		Integer resteApayer = maCotisation.getResteAPayer() - valeur;
		maCotisation.setDejaPayer(dejaPayer, this);
		maCotisation.setResteAPayer(resteApayer);
	}

	@Override
	public String toString() {
		return "Personne [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", status=" + status + ", sexe=" + sexe
				+ ", mesCours=" + mesCours + ", nbHeureCours=" + nbHeureCours + ", maCotisation=" + maCotisation
				+ ", adresse=" + adresse + "]";
	}

}