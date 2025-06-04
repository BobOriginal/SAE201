package modele;

import java.util.ArrayList;
import java.util.Iterator;

public class CotisationAnnuelle {
	static final String PAIMENT_UNIQUE = "paiment unique";
	static final String PAIMENT_MULTIPLE = "paiment multiple";
	
	private int id;
	private int annee;
	private Double total;
	private String typePaiment;
	private Double dejaPayer;
	private Double resteAPayer;
	private ArrayList<Boolean> aPayer3fois = new ArrayList<Boolean>(3);
	private ArrayList<Double> prixCours = new ArrayList<Double>();
	private ArrayList<Boolean> aPayersCours = new ArrayList<Boolean>();
	private Double dejaPayerCour;
	
	public CotisationAnnuelle(int annee, String typePaiment, Personne p) {
		super();
		this.annee = annee;
		this.typePaiment = typePaiment;
		if(typePaiment == PAIMENT_MULTIPLE) {
			aPayer3fois.add(false);
			aPayer3fois.add(false);
			aPayer3fois.add(false);
		}
		
		calculTotal(p);
		calculPrixCour(p);
		dejaPayer = 0.0;
		resteAPayer = total;
	}
	
	@SuppressWarnings("unlikely-arg-type")
	private void calculTotal(Personne p) {
		Double res = Tarif.prixInscription;
		if(p.getStatus() == Personne.ELEVE_PLEIN_TARIF) {
			res = res + Tarif.prixCourPleinTarif.get(p.getNbHeureCours());
		}else if(p.getStatus() == Personne.ELEVE_TARIF_REDUIT) {
			res = res + Tarif.prixCourTarifReduit.get(p.getNbHeureCours());
		}else {
			res = res + Tarif.prixNonInscrit;
		}
	}
	@SuppressWarnings("unlikely-arg-type")
	private void calculPrixCour(Personne p) {
		if(p.getStatus() == Personne.ELEVE_PLEIN_TARIF) {
			Iterator<Cours> iter = p.getMesCours().iterator();
			while(iter.hasNext()) {
				prixCours.add(Tarif.prixCourPleinTarif.get(iter.next().getNbHeure()));
				aPayersCours.add(false);
				
			}
		}else if(p.getStatus() == Personne.ELEVE_TARIF_REDUIT) {
			Iterator<Cours> iter = p.getMesCours().iterator();
			while(iter.hasNext()) {
				prixCours.add(Tarif.prixCourTarifReduit.get(iter.next().getNbHeure()));
				aPayersCours.add(false);
			}
		}else {
			prixCours = null;
			aPayersCours = null;
		}
	}
	private void calculdejaPayerCour(Personne p) {
		dejaPayerCour = dejaPayer;
		if(p.getStatus() != Personne.NON_INSCRIT ) {
			Iterator<Double> iter = prixCours.iterator();
			int i = 0;
			while(iter.hasNext()) {
				Double prix = iter.next();
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

	public Double getTotal() {
		return total;
	}

	public String getTypePaiment() {
		return typePaiment;
	}

	public Double getDejaPayer() {
		return dejaPayer;
	}

	public Double getResteAPayer() {
		return resteAPayer;
	}

	public ArrayList<Boolean> getaPayer3fois() {
		return aPayer3fois;
	}

	void setDejaPayer(Double dejaPayer, Personne p) {
		this.dejaPayer = dejaPayer;
		calculdejaPayerCour(p);
	}

	void setResteAPayer(Double resteAPayer) {
		this.resteAPayer = resteAPayer;
	}
	
	public Boolean aPayer() {
		return resteAPayer==0;
	}

	public ArrayList<Double> getPrixCours() {
		return prixCours;
	}

	public ArrayList<Boolean> getaPayersCours() {
		return aPayersCours;
	}

	public Double getDejaPayerCour() {
		return dejaPayerCour;
	}
	
	
	
	
}
