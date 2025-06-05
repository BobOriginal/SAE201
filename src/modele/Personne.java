package modele;

import java.util.ArrayList;
import java.util.Calendar;

import Exceptions.*;


public class Personne {
	final static String ELEVE_TARIF_REDUIT = "tarif reduit";
	final static String ELEVE_PLEIN_TARIF= "plein tarif";
	final static String NON_INSCRIT = "non inscrit";
	private int id;
	private String nom;
	private String prenom;
	private String status;
	private String sexe;
	private ArrayList<Cours> mesCours;	
	private Double nbHeureCours;
	private CotisationAnnuelle maCotisation;
	static int nbPersonne = 0;
	private String adresse;
	
	
	public Personne(String nom, String prenom, String status, String adresse, String typePaiment, String sexe) throws StatusException {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.sexe = sexe;
		nbHeureCours = 0.0 ;
		if(status == ELEVE_TARIF_REDUIT || 
		   status == ELEVE_PLEIN_TARIF	||
		   status == NON_INSCRIT) {
			this.status = status;
		}else {
			throw new StatusException();
		}
		id = nbPersonne++;
		mesCours = new ArrayList<Cours>();
		Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);
		maCotisation = new CotisationAnnuelle(year, typePaiment, this);
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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
		return nbHeureCours;
	}

	
	
	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	public CotisationAnnuelle getMaCotisation() {
		return maCotisation;
	}
	private void addCours(Cours c) {
		mesCours.add(c);
		nbHeureCours = nbHeureCours + c.getNbHeure();
		maCotisation.calculTotal(this);
		maCotisation.calculPrixCour(this);
		maCotisation.calculdejaPayerCour(this);
	}
	public void ajouterUnCours(Cours c) {
		try {
			if(c == null) {
				throw new NullPointerException();
			}else if(mesCours.contains(c)){
				throw new DoublonCoursException();
			}
			else if(status.equals(NON_INSCRIT)) {
				throw new StatusException();
			}
			else if(status.equals(ELEVE_PLEIN_TARIF) && nbHeureCours + c.getNbHeure() > 7.5) {
				throw new TropDeCoursExecption();
			}
			else if(status.equals(ELEVE_TARIF_REDUIT) && nbHeureCours + c.getNbHeure() > 5.0) {
				throw new TropDeCoursExecption();
			}
			addCours(c);
		}catch (NullPointerException e) {
			System.out.println("Cours valeur null");
		}catch (DoublonCoursException e) {
		}catch (StatusException e) {
			System.out.println("On ne peux pas ajouter un cours a une personne non inscrit");
		}catch (TropDeCoursExecption e) {
			
		}
	}
	
	public void payer(Integer valeur) {
		Integer dejaPayer = maCotisation.getDejaPayer()+valeur;
		Integer resteApayer = maCotisation.getResteAPayer()-valeur;
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
