package modele;

import java.util.Iterator;

import Exceptions.StatusException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Donnee {
	static private ObservableList<Personne> 	lesPersonnes = FXCollections.observableArrayList();
	static private ObservableList<InfoTabView> 	lesInfo = FXCollections.observableArrayList();
	static private ObservableList<InfoTabView> 	lesInfoCours = FXCollections.observableArrayList();
	static public void chargementDonnees() { 
		try {
			
			Personne p1 = new Personne("nomP1","prenomP1",Personne.ELEVE_PLEIN_TARIF,"Lannion",CotisationAnnuelle.PAIMENT_UNIQUE,"Mr");
			Personne p2 = new Personne("nomP2","prenomP2",Personne.ELEVE_TARIF_REDUIT,"Morlaix",CotisationAnnuelle.PAIMENT_UNIQUE,"Mme");
			Personne p3 = new Personne("nomP3","prenomP3",Personne.ELEVE_PLEIN_TARIF,"Rennes",CotisationAnnuelle.PAIMENT_UNIQUE,"Mme");
			Personne p4 = new Personne("nomP4","prenomP4",Personne.ELEVE_PLEIN_TARIF,"Lannion",CotisationAnnuelle.PAIMENT_UNIQUE,"Mr");
			Personne p5 = new Personne("nomP5","prenomP5",Personne.NON_INSCRIT,"Lannion",CotisationAnnuelle.PAIMENT_UNIQUE,"Mme");
			Personne p6 = new Personne("nomP6","prenomP6",Personne.NON_INSCRIT,"Rennes",CotisationAnnuelle.PAIMENT_UNIQUE,"Mr");
			Personne p7 = new Personne("nomP7","prenomP7",Personne.ELEVE_TARIF_REDUIT,"Morlaix",CotisationAnnuelle.PAIMENT_UNIQUE,"Mme");
			Personne p8 = new Personne("nomP8","prenomP8",Personne.ELEVE_TARIF_REDUIT,"Angers",CotisationAnnuelle.PAIMENT_UNIQUE,"Mr");
			Personne p9 = new Personne("nomP9","prenomP9",Personne.ELEVE_TARIF_REDUIT,"Angers",CotisationAnnuelle.PAIMENT_UNIQUE,"Mr");
			Personne p10 = new Personne("nomP10","prenomP10",Personne.ELEVE_PLEIN_TARIF,"Lannion",CotisationAnnuelle.PAIMENT_UNIQUE,"Mme");
			Personne p11 = new Personne("nomP11","prenomP11",Personne.ELEVE_TARIF_REDUIT,"Rennes",CotisationAnnuelle.PAIMENT_UNIQUE,"Mme");
			Personne p12 = new Personne("nomP12","prenomP12",Personne.NON_INSCRIT,"Morlaix",CotisationAnnuelle.PAIMENT_UNIQUE,"Mr");
			Personne p13 = new Personne("nomP13","prenomP13",Personne.ELEVE_PLEIN_TARIF,"Lannion",CotisationAnnuelle.PAIMENT_UNIQUE,"Mme");
			
			CoursDebutant c1 = new CoursDebutant(2025, 2.0, "c1");
			CoursIntermediare c2 = new CoursIntermediare(2025, 4.5, "c2");
			CoursAvancer c3 = new CoursAvancer(2025, 3.0, "c3");
			CoursDebutant c4 = new CoursDebutant(2025, 2.0, "c4");
			CoursIntermediare c5 = new CoursIntermediare(2025, 1.0, "c5");
		
			
			p1.ajouterUnCours(c1);
			p1.ajouterUnCours(c2);
			p2.ajouterUnCours(c5);
			p3.ajouterUnCours(c4);
			p3.ajouterUnCours(c4);
			p4.ajouterUnCours(c2);
			p5.ajouterUnCours(c1);
			p6.ajouterUnCours(c2);
			p6.ajouterUnCours(c5);
			p7.ajouterUnCours(c4);
			p7.ajouterUnCours(c3);
			p7.ajouterUnCours(c2);
			p8.ajouterUnCours(c1);
			p9.ajouterUnCours(c2);
			p9.ajouterUnCours(c5);
			p9.ajouterUnCours(c4);
			p10.ajouterUnCours(c4);
			p10.ajouterUnCours(c2);
			p11.ajouterUnCours(c2);
			p11.ajouterUnCours(c5);
			p12.ajouterUnCours(c4);
			p13.ajouterUnCours(c4);
			p13.ajouterUnCours(c2);
			
			
			lesPersonnes.add(p1);
			lesPersonnes.add(p2);
			lesPersonnes.add(p3);
			lesPersonnes.add(p4);
			lesPersonnes.add(p5);
			lesPersonnes.add(p6);
			lesPersonnes.add(p7);
			lesPersonnes.add(p8);
			lesPersonnes.add(p9);
			lesPersonnes.add(p10);
			lesPersonnes.add(p11);
			lesPersonnes.add(p12);
			lesPersonnes.add(p13);
			Iterator<Personne> iter1 = lesPersonnes.iterator();
			
			while(iter1.hasNext()) {
				Personne p = iter1.next();
				lesInfo.add(new InfoTabView(p));
				int i = 0;
				for(i = 0; i < p.getMesCours().size();i++) {
					lesInfoCours.add(new InfoTabView(p, i));
				}
			}
		} catch (StatusException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public static ObservableList<Personne> getLesPersonnes() {
		return lesPersonnes;
	}



	public static ObservableList<InfoTabView> getLesInfo() {
		return lesInfo;
	}



	static ObservableList<InfoTabView> getLesInfoCours() {
		return lesInfoCours;
	}
	
	
}
