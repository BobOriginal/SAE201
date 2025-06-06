package modele;

import java.util.ArrayList;
import java.util.Iterator;

public class CotisationAnnuelle {
	static final String PAIMENT_UNIQUE = "paiment unique";
	static final String PAIMENT_MULTIPLE = "paiment multiple";
	
	private int id;
	private int annee;
	private Integer total;
	private String typePaiment;
	private Integer dejaPayer;
	private Integer resteAPayer;
	private ArrayList<Boolean> aPayer3fois = new ArrayList<Boolean>(3);
	private ArrayList<Integer> prixCours = new ArrayList<Integer>();
	private ArrayList<Boolean> aPayersCours = new ArrayList<Boolean>();
	private Integer dejaPayerCour;
	
	public CotisationAnnuelle(int annee, String typePaiment, Personne p) {
		super();
		this.annee = annee;
		this.typePaiment = typePaiment;
		if(typePaiment == PAIMENT_MULTIPLE) {
			aPayer3fois.add(false);
			aPayer3fois.add(false);
			aPayer3fois.add(false);
		}
		Donnee.initTarif();
		total = 0;
		calculPrixCour(p);
		dejaPayer = 0;
		resteAPayer = total;
	}
	
	void calculTotal(Personne p) {
		
		if(p.getStatus().equals(Personne.ELEVE_PLEIN_TARIF)) {
			if(Donnee.prixCourPleinTarif.get(p.getNbHeureCours()) == null){
				System.out.println(p.getNbHeureCours());
			}
			total = Donnee.prixCourPleinTarif.get(p.getNbHeureCours());
		}else if(p.getStatus().equals(Personne.ELEVE_TARIF_REDUIT)) {
			if(Donnee.prixCourTarifReduit.get(p.getNbHeureCours()) == null){
				System.out.println(p.getNbHeureCours());
			}
			total = Donnee.prixCourTarifReduit.get(p.getNbHeureCours());
		}else {
			total = Donnee.prixNonInscrit;
		}
		
	}
	void calculPrixCour(Personne p) {
		if(p.getStatus() == Personne.ELEVE_PLEIN_TARIF) {
			Iterator<Cours> iter = p.getMesCours().iterator();
			while(iter.hasNext()) {
				prixCours.add(Donnee.prixCourPleinTarif.get(iter.next().getNbHeure()));
				aPayersCours.add(false);
				
			}
		}else if(p.getStatus() == Personne.ELEVE_TARIF_REDUIT) {
			Iterator<Cours> iter = p.getMesCours().iterator();
			while(iter.hasNext()) {
				prixCours.add(Donnee.prixCourTarifReduit.get(iter.next().getNbHeure()));
				aPayersCours.add(false);
			}
		}else {
			prixCours = null;
			aPayersCours = null;
		}
	}
	void calculdejaPayerCour(Personne p) {
		dejaPayerCour = dejaPayer;
		if(p.getStatus() != Personne.NON_INSCRIT ) {
			Iterator<Integer> iter = prixCours.iterator();
			int i = 0;
			while(iter.hasNext()) {
				Integer prix = iter.next();
				i++;
				if(prix <= dejaPayerCour) {
					dejaPayerCour = dejaPayerCour - prix;
					aPayersCours.set(i, true);
				}
			}
		}
	}
	
	public int getId() {
		return id;
	}

	public int getAnnee() {
		return annee;
	}

	public Integer getTotal() {
		return total;
	}

	public String getTypePaiment() {
		return typePaiment;
	}

	public Integer getDejaPayer() {
		return dejaPayer;
	}

	public Integer getResteAPayer() {
		return resteAPayer;
	}

	public ArrayList<Boolean> getaPayer3fois() {
		return aPayer3fois;
	}

	void setDejaPayer(Integer dejaPayer, Personne p) {
		this.dejaPayer = dejaPayer;
		calculdejaPayerCour(p);
	}

	void setResteAPayer(Integer resteAPayer) {
		this.resteAPayer = resteAPayer;
	}
	
	public Boolean aPayer() {
		return resteAPayer==0;
	}

	public ArrayList<Integer> getPrixCours() {
		return prixCours;
	}

	public ArrayList<Boolean> getAPayersCours() {
		return aPayersCours;
	}

	public Integer getDejaPayerCour() {
		return dejaPayerCour;
	}
	
	
	
	
}
