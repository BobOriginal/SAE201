package modele;

import Exceptions.StatusException;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import vue.FactureFen;

public class Main extends Application {
	static private ObservableList<Personne> listPersonne = FXCollections.observableArrayList();

	public void start(Stage f) throws Exception {
		f = new FactureFen();
		f.show();
	}

	public static void main(String args[]) {
		Application.launch();
	}

	public static ObservableList<Personne> getLesEmployes() {
		try {
			listPersonne.add(new Personne("test", "test", "non inscrit"));
			listPersonne.add(new Personne("test", "test", "non inscrit"));
			listPersonne.add(new Personne("test", "test", "non inscrit"));
			listPersonne.add(new Personne("test", "test", "non inscrit"));
			listPersonne.add(new Personne("test", "test", "non inscrit"));
			listPersonne.add(new Personne("test", "test", "non inscrit"));
			listPersonne.add(new Personne("test", "test", "non inscrit"));
			listPersonne.add(new Personne("test", "test", "non inscrit"));
			listPersonne.add(new Personne("test", "test", "non inscrit"));
			listPersonne.add(new Personne("test", "test", "non inscrit"));
		} catch (StatusException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listPersonne;
	}
}
