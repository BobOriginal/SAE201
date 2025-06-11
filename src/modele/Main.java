package modele;

import java.io.IOException;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import vue.FenFacture;
import vue.FenModification;
import vue.FenAjouterCours;
import vue.FenArchiver;
import vue.FenCotisationAnnuelle;
import vue.FenCotisationAnnuelleCours;
import vue.FenEmail;
import vue.FenPrincipale;
import vue.FenRappel;

public class Main extends Application {
	static private ObservableList<Personne> listPersonne = FXCollections.observableArrayList();
	private static FenCotisationAnnuelle fenCotisationAnnuelle;
	private static FenFacture fenFacture;
	private static FenPrincipale fenPrincipal;
	private static FenEmail fenEmail;
	private static FenRappel fenRappel;
	private static FenArchiver fenArchiver;
	private static FenCotisationAnnuelleCours fenCotisationAnnuelleCours;
	private static FenModification fenModification;
	private static FenAjouterCours fenAjouterCours ;
	
	public void start(Stage f) throws Exception {
		fenCotisationAnnuelle = new FenCotisationAnnuelle();
		fenArchiver = new FenArchiver();
		fenFacture = new FenFacture();
		fenPrincipal = new FenPrincipale();
		fenEmail = new FenEmail();
		fenRappel = new FenRappel();
		fenCotisationAnnuelleCours = new FenCotisationAnnuelleCours();
		fenModification = new FenModification();
		fenAjouterCours = new FenAjouterCours();
		fenPrincipal.show();
	}

	public static void main(String args[]) {
		Donnee.initTarif();
		Donnee.chargementDonnees();
		Donnee.chargementLesInfo();
		Donnee.listeFacture = new ListeDesFacturesArchiver();
		Application.launch();
	}

	static public ObservableList<InfoTabView> getLesInfoCours() {
		return Donnee.getLesInfoCours();
	}

	static public ObservableList<InfoTabView> getLesInfo() {
		return Donnee.getLesInfo();
	}
	
	public static ObservableList<Cours> getLesCours() {
		return Donnee.getLesCours();
	}

	public static void ouvrirRappel(ActionEvent event) throws IOException {
		fenRappel.show();
	}

	public static void fermerRappel(ActionEvent event) throws IOException {
		fenRappel.close();
	}

	public static void ouvrirEmail(ActionEvent event) throws IOException {
		fenEmail.show();
	}

	public static void fermerEmail(ActionEvent event) throws IOException {
		fenEmail.close();
	}

	public static void ouvrirArchiver(ActionEvent event, int id) throws IOException {
		fenArchiver.getCtrl().setFacture(Donnee.listeFacture.trouverFacture(id));
		fenArchiver.show();
	}

	public static void fermerArchiver(ActionEvent event) throws IOException {
		fenArchiver.close();
	}

	public static void ouvrirFacture(ActionEvent event) throws IOException {
		fenFacture.getCtrl().updateTab();
		fenFacture.getCtrl().updateValue();
		fenFacture.show();
	}

	public static void fermerFacture(ActionEvent event) throws IOException {
		fenFacture.close();
	}

	public static void ouvrirPagePrincipale(ActionEvent event) throws IOException {
		fenPrincipal.show();

	}

	public static void fermerPagePrincipale(ActionEvent event) throws IOException {
		fenPrincipal.close();
	}

	public static void ouvrirCotisation(ActionEvent event) throws IOException {
		fenCotisationAnnuelle.show();
	}

	public static void fermerCotisation(ActionEvent event) throws IOException {
		fenCotisationAnnuelle.close();
	}

	public static void ouvrirCotisationCours(ActionEvent event) throws IOException {
		fenCotisationAnnuelleCours.show();
	}

	public static void fermerCotisationCours(ActionEvent event) throws IOException {
		fenCotisationAnnuelleCours.close();
	}

	public static void ouvrirModification(ActionEvent event) throws IOException {
		fenModification.getCtrl().metAjourTab();
		fenModification.show();
	}
	
	public static void fermerModification(ActionEvent event) throws IOException {
		fenModification.close();
	}


	public static void fermerAjouterCours(ActionEvent event) throws IOException {
		fenAjouterCours.close();
	}
	
	public static void ouvrirAjouterCours(ActionEvent event) throws IOException {
		fenAjouterCours.show();
	}

	

	public static void quitter(ActionEvent event) throws IOException {
		System.exit(0);
	}
}
