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
	private static FenCotisationAnnuelle fenCotisationAnnuelle;
	private static FactureFen fenFacture;
	private static PagePrincipaleFen fenPrincipal;
	private static PageEmailFen fenEmail;
	private static PageRappelFen fenRappel;
	
	public void start(Stage f) throws Exception {
		fenCotisationAnnuelle = new FenCotisationAnnuelle();
		//fenFacture = new FactureFen();
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
	
	static public ObservableList<InfoTabView> getLesInfoCours(){
		
		return Donnee.getLesInfoCours();
	}
	
	static public ObservableList<InfoTabView> getLesInfo(){
		return Donnee.getLesInfo();
	}
	public static void ouvrirRappel(ActionEvent event) throws IOException{
		fenRappel.show();
	}
	public static void ouvrirEmail(ActionEvent event) throws IOException{
		fenEmail.show();
	}
	public static void fermerRappel(ActionEvent event) throws IOException{
		fenRappel.close();
	}
	public static void fermerEmail(ActionEvent event) throws IOException{
		fenEmail.close();
	}
	public static void ouvrirFacture(ActionEvent event) throws IOException{
		fenFacture.show();
	}
	public static void fermerFacture(ActionEvent event) throws IOException{
		fenFacture.close();
	}
	public static void ouvrirMain(ActionEvent event)throws IOException{
		fenPrincipal.show();
	}
	public static void fermerMain(ActionEvent event) throws IOException{
		fenPrincipal.close();
	}
	public static void ouvrirCotisation(ActionEvent event) throws IOException{
		fenCotisationAnnuelle.show();
	}
	public static void fermerCotisation(ActionEvent event) throws IOException{
		fenCotisationAnnuelle.close();
	}
}
