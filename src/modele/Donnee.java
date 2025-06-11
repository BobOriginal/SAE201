package modele;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;

import Exceptions.StatusException;
import Exceptions.TropDeCoursExecption;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Donnee {
	static private ObservableList<Personne> lesPersonnes = FXCollections.observableArrayList();
	static private ObservableList<Cours> lesCours = FXCollections.observableArrayList();
	static private ObservableList<InfoTabView> lesInfo = FXCollections.observableArrayList();
	static private ObservableList<InfoTabView> lesInfoCours = FXCollections.observableArrayList();
	static HashMap<Double, Integer> prixCourPleinTarif = new HashMap<Double, Integer>();
	static HashMap<Double, Integer> prixCourTarifReduit = new HashMap<Double, Integer>();
	static HashMap<Double, Paiement3fois> prixCourPleinTarif3fois = new HashMap<Double, Paiement3fois>();
	static HashMap<Double, Paiement3fois> prixCourTarifReduit3fois = new HashMap<Double, Paiement3fois>();
	static Integer prixNonInscrit = 44;
	static Integer prixInscription = 33;
	public static ListeDesFacturesArchiver listeFacture;
	static Integer Total = 0;
	static Integer dejaPayer = 0;
	static Integer restAPayer = 0;

	static public void chargementDonnees() {
		try {

			Personne p1 = new Personne("nomP1", "prenomP1", Personne.ELEVE_PLEIN_TARIF, "3 rues le long",
					CotisationAnnuelle.PAIMENT_UNIQUE, "Mr", "Lannion", "22300");
			Personne p2 = new Personne("nomP2", "prenomP2", Personne.ELEVE_TARIF_REDUIT, "16 rue torquéo",
					CotisationAnnuelle.PAIMENT_UNIQUE, "Mme", "Lannion", "22300");
			Personne p3 = new Personne("nomP3", "prenomP3", Personne.ELEVE_PLEIN_TARIF, "24 avenue du grand cru",
					CotisationAnnuelle.PAIMENT_UNIQUE, "Mme", "Lannion", "22300");
			Personne p4 = new Personne("nomP4", "prenomP4", Personne.ELEVE_PLEIN_TARIF, "42 boulevard de l'octet",
					CotisationAnnuelle.PAIMENT_UNIQUE, "Mr", "Lannion", "22300");
			Personne p5 = new Personne("nomP5", "prenomP5", Personne.NON_INSCRIT, "26 rue jean jean jean",
					CotisationAnnuelle.PAIMENT_UNIQUE, "Mme", "Lannion", "22300");
			Personne p6 = new Personne("nomP6", "prenomP6", Personne.NON_INSCRIT, "256 rue dépassement mémoire",
					CotisationAnnuelle.PAIMENT_UNIQUE, "Mr", "Lannion", "22300");
			Personne p7 = new Personne("nomP7", "prenomP7", Personne.ELEVE_TARIF_REDUIT, "33 rue de l'expédition",
					CotisationAnnuelle.PAIMENT_UNIQUE, "Mme", "Lannion", "22300");
			Personne p8 = new Personne("nomP8", "prenomP8", Personne.ELEVE_TARIF_REDUIT, "123 rue de pas d'idée",
					CotisationAnnuelle.PAIMENT_UNIQUE, "Mr", "Lannion", "22300");
			Personne p9 = new Personne("nomP9", "prenomP9", Personne.ELEVE_TARIF_REDUIT, "321 rue eédi'd sap ed eur",
					CotisationAnnuelle.PAIMENT_UNIQUE, "Mr", "Lannion", "22300");
			Personne p10 = new Personne("nomP10", "prenomP10", Personne.ELEVE_PLEIN_TARIF, "16 avenue st marin",
					CotisationAnnuelle.PAIMENT_UNIQUE, "Mme", "Lannion", "22300");
			Personne p11 = new Personne("nomP11", "prenomP11", Personne.ELEVE_TARIF_REDUIT, "20 rue d'Dhennin",
					CotisationAnnuelle.PAIMENT_UNIQUE, "Mme", "Lannion", "22300");
			Personne p12 = new Personne("nomP12", "prenomP12", Personne.NON_INSCRIT, "19 rue du Mace",
					CotisationAnnuelle.PAIMENT_UNIQUE, "Mr", "Lannion", "22300");
			Personne p13 = new Personne("nomP13", "prenomP13", Personne.ELEVE_PLEIN_TARIF, "21 rue du Conan",
					CotisationAnnuelle.PAIMENT_UNIQUE, "Mme", "Lannion", "22300");

			CoursDebutant c1 = new CoursDebutant(2025, 2.0, "c1");
			CoursIntermediare c2 = new CoursIntermediare(2025, 4.5, "c2");
			CoursAvancer c3 = new CoursAvancer(2025, 3.0, "c3");
			CoursDebutant c4 = new CoursDebutant(2025, 2.0, "c4");
			CoursIntermediare c5 = new CoursIntermediare(2025, 1.0, "c5");
			
			lesCours.add(c1);
			lesCours.add(c2);
			lesCours.add(c3);
			lesCours.add(c4);
			lesCours.add(c5);
			
				try {
					p1.ajouterUnCours(c1);
				} catch (TropDeCoursExecption e) {
					// TODO Auto-generated catch block
					
				}
				try {
					p1.ajouterUnCours(c2);
				} catch (TropDeCoursExecption e) {
					// TODO Auto-generated catch block
					
				}
				try {
					p2.ajouterUnCours(c5);
				} catch (TropDeCoursExecption e) {
					// TODO Auto-generated catch block
					
				}
				try {
					p3.ajouterUnCours(c4);
				} catch (TropDeCoursExecption e) {
					// TODO Auto-generated catch block
					
				}
				try {
					p3.ajouterUnCours(c4);
				} catch (TropDeCoursExecption e) {
					// TODO Auto-generated catch block
					
				}
				try {
					p4.ajouterUnCours(c2);
				} catch (TropDeCoursExecption e) {
					// TODO Auto-generated catch block
					
				}
				try {
					p5.ajouterUnCours(c1);
				} catch (TropDeCoursExecption e) {
					// TODO Auto-generated catch block
					
				}
				try {
					p6.ajouterUnCours(c2);
				} catch (TropDeCoursExecption e) {
					// TODO Auto-generated catch block
					
				}
				try {
					p6.ajouterUnCours(c5);
				} catch (TropDeCoursExecption e) {
					// TODO Auto-generated catch block
					
				}
				try {
					p7.ajouterUnCours(c4);
				} catch (TropDeCoursExecption e) {
					// TODO Auto-generated catch block
					
				}
				try {
					p7.ajouterUnCours(c3);
				} catch (TropDeCoursExecption e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					p7.ajouterUnCours(c2);
				} catch (TropDeCoursExecption e) {
					// TODO Auto-generated catch block
					
				}
				try {
					p8.ajouterUnCours(c1);
				} catch (TropDeCoursExecption e) {
					// TODO Auto-generated catch block
					
				}
				try {
					p9.ajouterUnCours(c2);
				} catch (TropDeCoursExecption e) {
					// TODO Auto-generated catch block
					
				}
				try {
					p9.ajouterUnCours(c5);
				} catch (TropDeCoursExecption e) {
					// TODO Auto-generated catch block
					
				}
				try {
					p9.ajouterUnCours(c4);
				} catch (TropDeCoursExecption e) {
					// TODO Auto-generated catch block
					
				}
				try {
					p10.ajouterUnCours(c4);
				} catch (TropDeCoursExecption e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					p10.ajouterUnCours(c2);
				} catch (TropDeCoursExecption e) {
					// TODO Auto-generated catch block
					
				}
				try {
					p11.ajouterUnCours(c2);
				} catch (TropDeCoursExecption e) {
					// TODO Auto-generated catch block
					
				}
				try {
					p11.ajouterUnCours(c5);
				} catch (TropDeCoursExecption e) {
					// TODO Auto-generated catch block
					
				}
				try {
					p12.ajouterUnCours(c4);
				} catch (TropDeCoursExecption e) {
					// TODO Auto-generated catch block
					
				}
				try {
					p13.ajouterUnCours(c4);
				} catch (TropDeCoursExecption e) {
					// TODO Auto-generated catch block
					
				}
				try {
					p13.ajouterUnCours(c2);
				} catch (TropDeCoursExecption e) {
					// TODO Auto-generated catch block
					
				}
			
			

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

		} catch (StatusException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	static public void chargementLesInfo() {
		Iterator<Personne> iter1 = lesPersonnes.iterator();
		while (iter1.hasNext()) {
			Personne p = iter1.next();
			lesInfo.add(new InfoTabView(p));
			int i = 0;
			for (i = 0; i < p.getMesCours().size(); i++) {
				lesInfoCours.add(new InfoTabView(p, i));
			}
		}
		triInfo();
		triInfoCour();
	}

	protected static void initTarif() {
		prixCourPleinTarif.put(0.75, 91);
		prixCourPleinTarif.put(1.00, 112);
		prixCourPleinTarif.put(1.25, 133);
		prixCourPleinTarif.put(1.5, 150);
		prixCourPleinTarif.put(1.75, 168);
		prixCourPleinTarif.put(2.00, 185);
		prixCourPleinTarif.put(2.25, 199);
		prixCourPleinTarif.put(2.5, 213);
		prixCourPleinTarif.put(2.75, 227);
		prixCourPleinTarif.put(3.00, 241);
		prixCourPleinTarif.put(3.25, 255);
		prixCourPleinTarif.put(3.5, 269);
		prixCourPleinTarif.put(3.75, 279);
		prixCourPleinTarif.put(4.00, 290);
		prixCourPleinTarif.put(4.25, 300);
		prixCourPleinTarif.put(4.5, 310);
		prixCourPleinTarif.put(4.75, 321);
		prixCourPleinTarif.put(5.00, 331);
		prixCourPleinTarif.put(5.50, 352);
		prixCourPleinTarif.put(6.00, 372);
		prixCourPleinTarif.put(6.50, 393);
		prixCourPleinTarif.put(7.00, 413);
		prixCourPleinTarif.put(7.5, 434);

		prixCourTarifReduit.put(0.75, 74);
		prixCourTarifReduit.put(1.00, 83);
		prixCourTarifReduit.put(1.25, 101);
		prixCourTarifReduit.put(1.5, 110);
		prixCourTarifReduit.put(1.75, 122);
		prixCourTarifReduit.put(2.00, 134);
		prixCourTarifReduit.put(2.25, 146);
		prixCourTarifReduit.put(2.5, 158);
		prixCourTarifReduit.put(2.75, 167);
		prixCourTarifReduit.put(3.00, 176);
		prixCourTarifReduit.put(3.25, 185);
		prixCourTarifReduit.put(3.5, 194);
		prixCourTarifReduit.put(3.75, 200);
		prixCourTarifReduit.put(4.00, 206);
		prixCourTarifReduit.put(4.25, 212);
		prixCourTarifReduit.put(4.5, 214);
		prixCourTarifReduit.put(5.00, 226);

	}

	public static ObservableList<Personne> getLesPersonnes() {
		return lesPersonnes;
	}

	public static Personne getUnePersonne(int i) {
		return lesPersonnes.get(i);
	}

	public static ObservableList<InfoTabView> getLesInfo() {
		return lesInfo;
	}

	static ObservableList<InfoTabView> getLesInfoCours() {
		return lesInfoCours;
	}

	private void addPleinTarif(Double nombreHeur, Integer prix) {
		prixCourPleinTarif.put(nombreHeur, prix);
	}

	private void addTarifReduit(Double nombreHeur, Integer prix) {
		prixCourTarifReduit.put(nombreHeur, prix);
	}

	private void removePleinTarif(Double nombreHeur) {
		prixCourPleinTarif.remove(nombreHeur);
	}

	private void removeTarifReduit(Double nombreHeur) {
		prixCourTarifReduit.remove(nombreHeur);
	}

	public static void removeInfo(InfoTabView itv) {
		lesInfo.remove(itv);
	}

	public static void afficheInfo() {
		Iterator<InfoTabView> iter = lesInfo.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}

	}

	public static void afficheInfoCours() {
		Iterator<InfoTabView> iter = lesInfoCours.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
	}

	public static int total() {
		int total = 0;
		Iterator<InfoTabView> iter = lesInfo.iterator();
		while (iter.hasNext()) {
			total = total + iter.next().getMontant();
		}
		return total;
	}

	public static int dejaPayer() {
		int total = 0;
		Iterator<InfoTabView> iter = lesInfo.iterator();
		while (iter.hasNext()) {
			total = total + iter.next().getDejaPayer();
		}
		return total;
	}

	public static int resteAPayer() {
		return total() - dejaPayer();
	}

	public static Integer getTotal() {
		return Total;
	}

	public static void setTotal(Integer total) {
		Total = total;
	}

	public static Integer getDejaPayer() {
		return dejaPayer;
	}

	public static void setDejaPayer(Integer dejaPayer) {
		Donnee.dejaPayer = dejaPayer;
	}

	public static Integer getRestAPayer() {
		return restAPayer;
	}

	public static void setRestAPayer(Integer restAPayer) {
		Donnee.restAPayer = restAPayer;
	}

	private static void triInfo() {
		Comparator<InfoTabView> myComparator = new comparator.LesInfoComparator();
		lesInfo.sort(myComparator);
	}

	private static void triInfoCour() {
		Comparator<InfoTabView> myComparator = new comparator.LesInfoCoursComparator();
		lesInfoCours.sort(myComparator);
	}

	public static ObservableList<Cours> getLesCours() {
		return lesCours;
	}
	
	

}
