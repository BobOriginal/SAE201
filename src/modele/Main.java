package modele;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import vue.FactureFen;
import vue.FenCotisationAnnuelle;
import vue.PagePrincipaleFen;


public class Main extends Application {
	static private ObservableList<Personne> listPersonne = FXCollections.observableArrayList();
	private static FenCotisationAnnuelle fenCotisationAnnuelle;
	private static FactureFen fenFacture;
	private static PagePrincipaleFen fenPrincipal;
	
	public void start(Stage f) throws Exception {
		fenCotisationAnnuelle = new FenCotisationAnnuelle();
		fenFacture = new FactureFen();
		fenPrincipal = new PagePrincipaleFen();
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
		Donnee.initTarif();
		Donnee.chargementDonnees();
		Donnee.chargementLesInfo();
		return Donnee.getLesInfo();
	}
	
	public static void retourMenu() {
		
	}
}
