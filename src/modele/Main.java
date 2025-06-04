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
	static private ObservableList<Personne_Montant> listPersonne = FXCollections.observableArrayList();
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
	
	public static ObservableList<Personne_Montant> getLesEmployes() throws StatusException{
		try {
			listPersonne.add(new Personne_Montant(new Personne("test1", "test","non inscrit"),0.00,34.4));
			listPersonne.add(new Personne_Montant(new Personne("test2", "test","non inscrit"),32.45,0.00));
			listPersonne.add(new Personne_Montant(new Personne("test3", "test","non inscrit"),0.00,34.4));
			listPersonne.add(new Personne_Montant(new Personne("test4", "test","non inscrit"),32.45,0.00));
			listPersonne.add(new Personne_Montant(new Personne("test5", "test","non inscrit"),0.00,0.00));
			listPersonne.add(new Personne_Montant(new Personne("test6", "test","non inscrit"),32.45,34.4));
			listPersonne.add(new Personne_Montant(new Personne("test7", "test","non inscrit"),0.00,0.00));
			listPersonne.add(new Personne_Montant(new Personne("test8", "test","non inscrit"),32.45,34.4));
			listPersonne.add(new Personne_Montant(new Personne("test9", "test","non inscrit"),32.45,0.00));
			listPersonne.add(new Personne_Montant(new Personne("test10", "test","non inscrit"),0.00,34.4));
			listPersonne.add(new Personne_Montant(new Personne("test11", "test","non inscrit"),32.45,0.00));
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
