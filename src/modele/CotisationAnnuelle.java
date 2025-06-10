package modele;

import java.util.Iterator;

import java.util.ArrayList;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class CotisationAnnuelle {
	static final String PAIMENT_UNIQUE = "paiment unique";
	static final String PAIMENT_MULTIPLE = "paiment multiple";

	private int id;
	private int annee;
	private IntegerProperty total = new SimpleIntegerProperty();
	private StringProperty typePaiment = new SimpleStringProperty();
	private IntegerProperty dejaPayer = new SimpleIntegerProperty();
	private IntegerProperty resteAPayer = new SimpleIntegerProperty();
	private ArrayList<Boolean> aPayer3fois = new ArrayList<Boolean>(3);
	private ArrayList<Integer> prixCours = new ArrayList<Integer>();
	private ArrayList<Boolean> aPayersCours = new ArrayList<Boolean>();
	private IntegerProperty dejaPayerCour = new SimpleIntegerProperty();

	public CotisationAnnuelle(int annee, String typePaiment, Personne p) {
		this.annee = annee;
		this.typePaiment.set(typePaiment);
		if (typePaiment == PAIMENT_MULTIPLE) {
			aPayer3fois.add(false);
			aPayer3fois.add(false);
			aPayer3fois.add(false);
		}
		Donnee.initTarif();
		total.set(0);
		calculPrixCour(p);
		dejaPayer.set(0);
		resteAPayer.set(total.get());
	}

	void calculTotal(Personne p) {

		if (p.getStatus().equals(Personne.ELEVE_PLEIN_TARIF)) {
			if (Donnee.prixCourPleinTarif.get(p.getNbHeureCours()) == null) {
				System.out.println(p.getNbHeureCours());
			}
			total.set(Donnee.prixCourPleinTarif.get(p.getNbHeureCours()));

		} else if (p.getStatus().equals(Personne.ELEVE_TARIF_REDUIT)) {
			if (Donnee.prixCourTarifReduit.get(p.getNbHeureCours()) == null) {
				System.out.println(p.getNbHeureCours());
			}
			total.set(Donnee.prixCourTarifReduit.get(p.getNbHeureCours()));

		} else {
			total.set(Donnee.prixNonInscrit);
		}
		resteAPayer.set(total.get()-dejaPayer.get());
	}

	void calculPrixCour(Personne p) {
		if (p.getStatus() == Personne.ELEVE_PLEIN_TARIF) {
			Iterator<Cours> iter = p.getMesCours().iterator();
			while (iter.hasNext()) {
				prixCours.add(Donnee.prixCourPleinTarif.get(iter.next().getNbHeure()));
				aPayersCours.add(false);

			}
		} else if (p.getStatus() == Personne.ELEVE_TARIF_REDUIT) {
			Iterator<Cours> iter = p.getMesCours().iterator();
			while (iter.hasNext()) {
				prixCours.add(Donnee.prixCourTarifReduit.get(iter.next().getNbHeure()));
				aPayersCours.add(false);
			}
		} else {
			prixCours = null;
			aPayersCours = null;
		}
	}

	void calculdejaPayerCour(Personne p) {
		dejaPayerCour.set(dejaPayer.get());

		if (p.getStatus() != Personne.NON_INSCRIT) {
			Iterator<Integer> iter = prixCours.iterator();
			int i = 0;
			while (iter.hasNext()) {
				Integer prix = iter.next();
				i++;
				if (prix <= dejaPayerCour.get()) {
					dejaPayerCour.set(dejaPayerCour.get() - prix);
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
		return total.get();
	}

	public IntegerProperty totalProperty() {
		return total;
	}

	public String getTypePaiment() {
		return typePaiment.get();
	}

	public StringProperty typePaiementProperty() {
		return typePaiment;
	}

	public Integer getDejaPayer() {
		return dejaPayer.get();
	}

	public Integer getResteAPayer() {
		return resteAPayer.get();
	}

	public IntegerProperty ResteApayerProperty() {
		return resteAPayer;
	}

	public ArrayList<Boolean> getaPayer3fois() {
		return aPayer3fois;
	}

	void setDejaPayer(Integer dejaPayer, Personne p) {
		this.dejaPayer.set(dejaPayer);
		calculdejaPayerCour(p);
	}

	void setResteAPayer(Integer resteAPayer) {
		this.resteAPayer.set(resteAPayer);
	}

	public Boolean aPayer() {
		return resteAPayer.get() == 0;
	}

	public ArrayList<Integer> getPrixCours() {
		return prixCours;
	}

	public ArrayList<Boolean> getAPayersCours() {
		return aPayersCours;
	}

	public Integer getDejaPayerCour() {
		return dejaPayerCour.get();
	}
}