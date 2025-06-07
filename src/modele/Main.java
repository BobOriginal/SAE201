package modele;

import java.io.IOException;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import vue.FactureFen;
import vue.FenCotisationAnnuelle;
import vue.PageEmailFen;
import vue.PagePrincipaleFen;
import vue.PageRappelFen;

public class Main extends Application {
	static private ObservableList<Personne> listPersonne = FXCollections.observableArrayList();
	private static FenCotisationAnnuelle fenCotisationAnnuelle;
	private static FactureFen fenFacture;
	private static PagePrincipaleFen fenPrincipal;
	private static PageEmailFen fenEmail;
	private static PageRappelFen fenRappel;

	public void start(Stage f) throws Exception {
		fenCotisationAnnuelle = new FenCotisationAnnuelle();
		fenFacture = new FactureFen();
		fenPrincipal = new PagePrincipaleFen();
		fenEmail = new PageEmailFen();
		fenRappel = new PageRappelFen();
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
		Donnee.initTarif();
		Donnee.chargementDonnees();
		Donnee.chargementLesInfo();
		return Donnee.getLesInfo();
	}

	public static void retourMenu() {

	}

	public static void ouvrirRappel(ActionEvent event) throws IOException {
		fenRappel.show();
	}

	public static void ouvrirEmail(ActionEvent event) throws IOException {
		fenEmail.show();
	}

	public static void fermerRappel(ActionEvent event) throws IOException {
		fenRappel.close();
	}

	public static void fermerEmail(ActionEvent event) throws IOException {
		fenEmail.close();
	}
}
