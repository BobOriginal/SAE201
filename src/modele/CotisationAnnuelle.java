package modele;

import java.util.ArrayList;
import java.util.Iterator;

import Exceptions.PaimentExecption;

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

	void setDejaPayer(Double dejaPayer) {
		this.dejaPayer = dejaPayer;
	}

	void setResteAPayer(Double resteAPayer) {
		this.resteAPayer = resteAPayer;
	}
	
	
	
}
