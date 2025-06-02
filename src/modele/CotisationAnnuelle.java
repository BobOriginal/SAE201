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
	private Personne personne;
	private ArrayList<Boolean> aPayer3fois = new ArrayList<Boolean>(3);
	
	public CotisationAnnuelle(int annee, String typePaiment, Personne personne) {
		super();
		this.annee = annee;
		this.typePaiment = typePaiment;
		this.personne = personne;
		if(typePaiment == PAIMENT_MULTIPLE) {
			aPayer3fois.add(false);
			aPayer3fois.add(false);
			aPayer3fois.add(false);
		}
		calculTotal();
		resteAPayer = total;
	}
	
	private void calculTotal() {
		Double res = Tarif.prixInscription;
		if(personne.getStatus() == Personne.ELEVE_PLEIN_TARIF) {
			res = res + Tarif.prixCourPleinTarif.get(personne.getNbHeureCours());
		}else if(personne.getStatus() == Personne.ELEVE_TARIF_REDUIT) {
			res = res + Tarif.prixCourTarifReduit.get(personne.getNbHeureCours());
		}else {
			res = res + Tarif.prixNonInscrit;
		}
	}
	
	private void payer(Double prix) {
		resteAPayer -= prix; 
	}
	
	public void paimentDeLaCotisation(Double prix) {
		try {
			if(personne.getStatus() == Personne.ELEVE_PLEIN_TARIF) {
				if(typePaiment == PAIMENT_UNIQUE) {
					if(prix > total) {
						throw new Exceptions.PaimentTropEleverException();
					}else if(prix < total) {
						throw new Exceptions.PaimentTropBasException();
					}
					payer(prix);
				}else {
					int numDuPaiment = 1;
					Iterator<Boolean> iter = aPayer3fois.iterator();
					while(iter.hasNext() && iter.next() == true) {
						numDuPaiment++;
					}
					if(numDuPaiment == 1) {
						if(prix > Tarif.prixCourPleinTarif3fois.get(personne.getNbHeureCours()).getPremier_versement()) {
							throw new Exceptions.PaimentTropEleverException();
						}
						else if(prix < Tarif.prixCourPleinTarif3fois.get(personne.getNbHeureCours()).getPremier_versement()) {
							throw new Exceptions.PaimentTropBasException();
						}
						payer(prix);
						
					}else if(numDuPaiment == 2) {
						if(prix > Tarif.prixCourPleinTarif3fois.get(personne.getNbHeureCours()).getDeuxieme_versement()) {
							throw new Exceptions.PaimentTropEleverException();
						}
						else if(prix < Tarif.prixCourPleinTarif3fois.get(personne.getNbHeureCours()).getDeuxieme_versement()) {
							throw new Exceptions.PaimentTropBasException();
						}
						payer(prix);
					}else if(numDuPaiment == 3) {
						if(prix > Tarif.prixCourPleinTarif3fois.get(personne.getNbHeureCours()).getTroisieme_versement()) {
							throw new Exceptions.PaimentTropEleverException();
						}
						else if(prix < Tarif.prixCourPleinTarif3fois.get(personne.getNbHeureCours()).getTroisieme_versement()) {
							throw new Exceptions.PaimentTropBasException();
						}
						payer(prix);
					}
				}
			}else if(personne.getStatus() == Personne.ELEVE_TARIF_REDUIT) {
				if(typePaiment == PAIMENT_UNIQUE) {
					if(prix > total) {
						throw new Exceptions.PaimentTropEleverException();
					}else if(prix < total) {
						throw new Exceptions.PaimentTropBasException();
					}
					payer(prix);
				}else {
					int numDuPaiment = 1;
					Iterator<Boolean> iter = aPayer3fois.iterator();
					while(iter.hasNext() && iter.next() == true) {
						numDuPaiment++;
					}
					if(numDuPaiment == 1) {
						if(prix > Tarif.prixCourTarifReduit3fois.get(personne.getNbHeureCours()).getPremier_versement()) {
							throw new Exceptions.PaimentTropEleverException();
						}
						else if(prix < Tarif.prixCourTarifReduit3fois.get(personne.getNbHeureCours()).getPremier_versement()) {
							throw new Exceptions.PaimentTropBasException();
						}
						payer(prix);
						
					}else if(numDuPaiment == 2) {
						if(prix > Tarif.prixCourTarifReduit3fois.get(personne.getNbHeureCours()).getDeuxieme_versement()) {
							throw new Exceptions.PaimentTropEleverException();
						}
						else if(prix < Tarif.prixCourTarifReduit3fois.get(personne.getNbHeureCours()).getDeuxieme_versement()) {
							throw new Exceptions.PaimentTropBasException();
						}
						payer(prix);
					}else if(numDuPaiment == 3) {
						if(prix > Tarif.prixCourTarifReduit3fois.get(personne.getNbHeureCours()).getTroisieme_versement()) {
							throw new Exceptions.PaimentTropEleverException();
						}
						else if(prix < Tarif.prixCourTarifReduit3fois.get(personne.getNbHeureCours()).getTroisieme_versement()) {
							throw new Exceptions.PaimentTropBasException();
						}
						payer(prix);
					}
				}
			}else {
				if(prix > Tarif.prixNonInscrit) {
					throw new Exceptions.PaimentTropEleverException();
				}else if(prix < Tarif.prixNonInscrit) {
					throw new Exceptions.PaimentTropBasException();
				}
				payer(prix);
			}
		}catch (PaimentExecption e) {
			System.out.println("Paiment invalide");
		}
	}
	
}
