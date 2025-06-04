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
	private ArrayList<Double> aPayers = new ArrayList<Double>();
	private Double dejaPayerCour;

	public CotisationAnnuelle(int annee, String typePaiment, Personne p) {
		super();
		this.annee = annee;
		this.typePaiment = typePaiment;
		if (typePaiment == PAIMENT_MULTIPLE) {
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
		if (p.getStatus().equals(Personne.ELEVE_PLEIN_TARIF)) {
			res = res + Tarif.prixCourPleinTarif.get(p.getNbHeureCours());
		} else if (p.getStatus().equals(Personne.ELEVE_TARIF_REDUIT)) {
			res = res + Tarif.prixCourTarifReduit.get(p.getNbHeureCours());
		} else {
			res = res + Tarif.prixNonInscrit;
		}
	}

	@SuppressWarnings("unlikely-arg-type")
	private void calculPrixCour(Personne p) {
		if (p.getStatus().equals(Personne.ELEVE_PLEIN_TARIF)) {
			Iterator<Cours> iter = p.getMesCours().iterator();
			while (iter.hasNext()) {
				prixCours.add(Tarif.prixCourPleinTarif.get(iter.next().getNbHeure()));
			}
		} else if (p.getStatus().equals(Personne.ELEVE_TARIF_REDUIT)) {
			Iterator<Cours> iter = p.getMesCours().iterator();
			while (iter.hasNext()) {
				prixCours.add(Tarif.prixCourTarifReduit.get(iter.next().getNbHeure()));
			}
		} else {
			prixCours = null;
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

	public Boolean aPayer() {
		return resteAPayer == 0;
	}

}