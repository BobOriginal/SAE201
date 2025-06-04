package modele;

import java.util.Iterator;

import Exceptions.StatusException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Donnee {
	static private ObservableList<Personne> 	lesPersonnes = FXCollections.observableArrayList();
	static private ObservableList<Cours> 	lesCours = FXCollections.observableArrayList();
	static private ObservableList<InfoTabView> 	lesInfo = FXCollections.observableArrayList();
	static public void chargementDonnees() { 
		try {
			lesPersonnes.add(new Personne("nomP1","prenomP1",Personne.ELEVE_PLEIN_TARIF,"Lannion",CotisationAnnuelle.PAIMENT_UNIQUE,"Mr"));
			lesPersonnes.add(new Personne("nomP2","prenomP2",Personne.ELEVE_TARIF_REDUIT,"Morlaix",CotisationAnnuelle.PAIMENT_MULTIPLE,"Mme"));
			lesPersonnes.add(new Personne("nomP3","prenomP3",Personne.ELEVE_PLEIN_TARIF,"Rennes",CotisationAnnuelle.PAIMENT_UNIQUE,"Mme"));
			lesPersonnes.add(new Personne("nomP4","prenomP4",Personne.ELEVE_PLEIN_TARIF,"Lannion",CotisationAnnuelle.PAIMENT_MULTIPLE,"Mr"));
			lesPersonnes.add(new Personne("nomP5","prenomP5",Personne.NON_INSCRIT,"Lannion",CotisationAnnuelle.PAIMENT_MULTIPLE,"Mme"));
			lesPersonnes.add(new Personne("nomP6","prenomP6",Personne.NON_INSCRIT,"Rennes",CotisationAnnuelle.PAIMENT_UNIQUE,"Mr"));
			lesPersonnes.add(new Personne("nomP7","prenomP7",Personne.ELEVE_TARIF_REDUIT,"Morlaix",CotisationAnnuelle.PAIMENT_UNIQUE,"Mme"));
			lesPersonnes.add(new Personne("nomP8","prenomP8",Personne.ELEVE_TARIF_REDUIT,"Angers",CotisationAnnuelle.PAIMENT_MULTIPLE,"Mr"));
			lesPersonnes.add(new Personne("nomP9","prenomP9",Personne.ELEVE_TARIF_REDUIT,"Angers",CotisationAnnuelle.PAIMENT_UNIQUE,"Mr"));
			lesPersonnes.add(new Personne("nomP10","prenomP10",Personne.ELEVE_PLEIN_TARIF,"Lannion",CotisationAnnuelle.PAIMENT_MULTIPLE,"Mme"));
			lesPersonnes.add(new Personne("nomP11","prenomP11",Personne.ELEVE_TARIF_REDUIT,"Rennes",CotisationAnnuelle.PAIMENT_MULTIPLE,"Mme"));
			lesPersonnes.add(new Personne("nomP12","prenomP12",Personne.NON_INSCRIT,"Morlaix",CotisationAnnuelle.PAIMENT_MULTIPLE,"Mr"));
			lesPersonnes.add(new Personne("nomP13","prenomP13",Personne.ELEVE_PLEIN_TARIF,"Lannion",CotisationAnnuelle.PAIMENT_UNIQUE,"Mme"));
			Iterator<Personne> iter1 = lesPersonnes.iterator();
			while(iter1.hasNext()) {
				Personne p = iter1.next();
			}
			
		} catch (StatusException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	public static ObservableList<Personne> getLesPersonnes() {
		return lesPersonnes;
	}
	public static ObservableList<Cours> getLesCours() {
		return lesCours;
	}
	
}
