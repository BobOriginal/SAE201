package modele;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import vue.FenCotisationAnnuelle;


public class Main extends Application {
	static private ObservableList<Personne> listPersonne = FXCollections.observableArrayList();
	private static FenCotisationAnnuelle fenCotisationAnnuelle;
	
	public void start(Stage f) throws Exception {
		fenCotisationAnnuelle = new FenCotisationAnnuelle();
		fenCotisationAnnuelle.show();
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
	
}
