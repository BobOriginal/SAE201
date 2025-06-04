package modele;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Donnee {
	static private ObservableList<Personne> 	lesPersonnes = FXCollections.observableArrayList();
	static private ObservableList<Cours> 	lesCours = FXCollections.observableArrayList();
	static public void chargementDonnees() { 
		
	}
	public static ObservableList<Personne> getLesPersonnes() {
		return lesPersonnes;
	}
	public static ObservableList<Cours> getLesCours() {
		return lesCours;
	}
	
}
