package modele;

import java.util.Iterator;

public class CotisationAnnuelle {
	
	
	private int id;
	private int annee;
	private Double total;
	private String typePaiment;
	private Double dejaPayer;
	private Double resteAPayer;
	private Personne personne;
	
	public CotisationAnnuelle(int annee, String typePaiment, Personne personne) {
		super();
		this.annee = annee;
		this.typePaiment = typePaiment;
		this.personne = personne;
		calculTotal();
		resteAPayer = total;
	}
	
	private void calculTotal() {
		Double res = Tarif.prixInscription;
		if(personne.getStatus() == Personne.ELEVE_PLEIN_TARIF) {
			Iterator<Cours> iter = personne.getMesCours().iterator();
			while(iter.hasNext()) {
				res = res + Tarif.prixCourPleinTarif.get(iter.next().getNbHeure());
			}
		}else if(personne.getStatus() == Personne.ELEVE_TARIF_REDUIT) {
			Iterator<Cours> iter = personne.getMesCours().iterator();
			while(iter.hasNext()) {
				res = res + Tarif.prixCourTarifReduit.get(iter.next().getNbHeure());
			}	
		}else {
			res = res + Tarif.prixNonInscrit;
		}
	}
	
	private void payer(Double prix) {
		resteAPayer -= prix; 
	}
	
}
