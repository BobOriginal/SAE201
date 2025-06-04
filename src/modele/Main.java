package modele;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import vue.FenCotisationAnnuelle;
import vue.PagePrincipaleFen;

public class Main extends Application {
	static private ObservableList<Personne> listPersonne = FXCollections.observableArrayList();
	private static vue.PagePrincipaleFen fenPrincipale;
	private static vue.FenCotisationAnnuelle fenCotisationAnnuelle;
	
	public void start(Stage f) throws Exception {
		fenPrincipale = new PagePrincipaleFen();
		fenCotisationAnnuelle = new FenCotisationAnnuelle();
		fenCotisationAnnuelle.show();
	}

	public static void main(String args[]) {
		Application.launch();
	}
	
}
