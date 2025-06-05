package modele;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import vue.*;


public class Main extends Application {
	static private ObservableList<Personne> listPersonne = FXCollections.observableArrayList();
	private static PagePrincipaleFen fenPrincipale;
	private static FenCotisationAnnuelle fenCotisationAnnuelle;
	
	public void start(Stage f) throws Exception {
		Tarif.initTarif();
		Donnee.chargementDonnees();
		fenPrincipale = new PagePrincipaleFen();
		fenCotisationAnnuelle = new FenCotisationAnnuelle();
		fenCotisationAnnuelle.show();
	}

	public static void main(String args[]) {
		Application.launch();
	}
	
}
