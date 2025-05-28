package modele;

import java.util.Iterator;

public class CotisationAnnuelle {
	private final Double PRIX_INSCRIPTION = 33.0;
	
	private int id;
	private int annee;
	private Double total;
	private String typePaiment;
	private Double resteAPayer;
	private Personne personne;
	
	public CotisationAnnuelle(int annee, String typePaiment, Personne personne) {
		super();
		this.annee = annee;
		this.typePaiment = typePaiment;
		this.personne = personne;
	}
	
	private void caLculTotal() {
		Double res = PRIX_INSCRIPTION;
		if(personne.getStatus() != Personne.NON_INSCRIT);{
			Iterator<Cours> iter = personne.getMesCours().iterator();
			while(iter.hasNext()) {
				if(personne.getStatus() == Personne.ELEVE_PLEIN_TARIF) {
					
				}
			}
		}
		
	}
	
}
