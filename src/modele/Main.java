package modele;

import java.io.IOException;

import Exceptions.StatusException;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import vue.PageEmailFen;
import vue.PageRappelFen;

public class Main extends Application {
	static private ObservableList<Personne> listPersonne = FXCollections.observableArrayList();
	static private PageEmailFen fEmailFen;
	static private PageRappelFen fRappelFen;
	public void start(Stage f) throws Exception {
		fEmailFen = new PageEmailFen();
		fRappelFen = new PageRappelFen();

		fRappelFen.show();
	}

	public static void main(String args[]) {
		Application.launch();
	}
	
	public static ObservableList<Personne> getLesEmployes(){
		try {
			listPersonne.add(new Personne("test", "test","non inscrit"));
			listPersonne.add(new Personne("test", "test","non inscrit"));
			listPersonne.add(new Personne("test", "test","non inscrit"));
			listPersonne.add(new Personne("test", "test","non inscrit"));
			listPersonne.add(new Personne("test", "test","non inscrit"));
			listPersonne.add(new Personne("test", "test","non inscrit"));
			listPersonne.add(new Personne("test", "test","non inscrit"));
			listPersonne.add(new Personne("test", "test","non inscrit"));
			listPersonne.add(new Personne("test", "test","non inscrit"));
			listPersonne.add(new Personne("test", "test","non inscrit"));
        } catch (StatusException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return listPersonne;
	}
	public static void ouvrirRappel(ActionEvent event) throws IOException{
		fRappelFen.show();
	}
	public static void ouvrirEmail(ActionEvent event) throws IOException{
		fEmailFen.show();
	}
	public static void fermerRappel(ActionEvent event) throws IOException{
		fRappelFen.close();
	}
	public static void fermerEmail(ActionEvent event) throws IOException{
		fEmailFen.close();
	}
}
