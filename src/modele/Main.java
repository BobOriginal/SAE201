package modele;

import Exceptions.StatusException;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import vue.FactureFen;

public class Main extends Application {
	private static ObservableList<Personne> listPersonne = FXCollections.observableArrayList();
	public static ListeDesFacturesArchiver listeFacture;

	public void start(Stage f) throws Exception {
		f = new FactureFen(new Personne("Dupont", "Alice", "non inscrit", "12 rue des Lilas", "chèque", "F"));
		f.show();
	}

	public static void main(String args[]) {
		ListeDesFacturesArchiver listeFacture = new ListeDesFacturesArchiver();
		Application.launch();
	}

	public static ObservableList<Personne> getLesEmployes() {
		try {
			listPersonne.add(new Personne("Dupont", "Alice", "non inscrit", "12 rue des Lilas", "chèque", "F"));

			listPersonne
					.add(new Personne("Martin", "Lucas", "non inscrit", "34 avenue Victor Hugo", "espèces", "M"));

			listPersonne.add(new Personne("Lemoine", "Sophie", "non inscrit", "7 rue des Écoles",
					"carte bancaire", "F"));

			listPersonne.add(
					new Personne("Nguyen", "Thomas", "non inscrit", "25 boulevard Haussmann", "virement", "M"));

			listPersonne.add(
					new Personne("Durand", "Emma", "non inscrit", "19 rue de la Liberté", "chèque", "F"));

			listPersonne.add(
					new Personne("Petit", "Nathan", "non inscrit", "11 allée des Cerisiers", "espèces", "M"));

			listPersonne.add(new Personne("Leroy", "Camille", "non inscrit", "3 rue du Pont Neuf",
					"carte bancaire", "F"));

			listPersonne.add(
					new Personne("Roux", "Hugo", "non inscrit", "52 avenue de la République", "virement", "M"));

			listPersonne.add(
					new Personne("Moreau", "Jade", "non inscrit", "8 impasse des Jardins", "chèque", "F"));

			listPersonne.add(new Personne("Fournier", "Leo", "non inscrit", "14 rue du Stade", "espèces", "M"));

		} catch (StatusException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listPersonne;
	}
}
