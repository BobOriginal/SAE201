package modele;

import java.util.ArrayList;
import java.util.Calendar;

import Exceptions.DoublonCoursException;
import Exceptions.StatusException;

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
	private int nbHeureCours;
	private CotisationAnnuelle maCotisation;
	static int nbPersonne = 0;
	private String adresse;
	
	
	public Personne(String nom, String prenom, String status, String adresse, String typePaiment, String sexe) throws StatusException {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.sexe = sexe;
		if(status == ELEVE_TARIF_REDUIT || 
		   status == ELEVE_PLEIN_TARIF	||
		   status == NON_INSCRIT) {
			this.status = status;
		}else {
			throw new StatusException();
		}
		id = nbPersonne;
		nbPersonne++;
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
	
	public int getNbHeureCours() {
		return nbHeureCours;
	}

	private void addCours(Cours c) {
		mesCours.add(c);
		nbHeureCours = nbHeureCours + c.getNbHeure();
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

	public void ajouterUnCours(Cours c) {
		try {
			if(c == null) {
				throw new NullPointerException();
			}else if(mesCours.contains(c)){
				throw new DoublonCoursException();
			}
			addCours(c);
		}catch (NullPointerException e) {
			System.out.println("Cours valeur null");
		}catch (DoublonCoursException e) {
		}
	}
	
	public void payer(Double valeur) {
		Double dejaPayer = maCotisation.getDejaPayer()+valeur;
		Double resteApayer = maCotisation.getResteAPayer()-valeur;
		maCotisation.setDejaPayer(dejaPayer);
		maCotisation.setResteAPayer(resteApayer);
	}
	
	
}
