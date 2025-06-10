package modele;

import java.io.IOException;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import vue.FenFacture;
import vue.FenArchiver;
import vue.FenCotisationAnnuelle;
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

	public void start(Stage f) throws Exception {
		fenCotisationAnnuelle = new FenCotisationAnnuelle();
		fenArchiver = new FenArchiver();
		fenFacture = new FenFacture();
		fenPrincipal = new FenPrincipale();
		fenEmail = new FenEmail();
		fenRappel = new FenRappel();
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

	public static void retourMenu() {

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

	public static void ouvrirArchiver(ActionEvent event) throws IOException {
		fenArchiver.show();
	}

	public static void fermerArchiver(ActionEvent event) throws IOException {
		fenArchiver.close();
	}

	public static void ouvrirFacture(ActionEvent event) throws IOException {
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
}
