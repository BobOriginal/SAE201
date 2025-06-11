package controleur;

import java.io.IOException;
import java.util.Iterator;

import Exceptions.TropDeCoursExecption;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import modele.Cours;
import modele.InfoTabView;
import modele.Main;
import modele.Personne;

public class CtrlAjouterCours {
	private static Personne p;
	
	 @FXML
	    private Button bnAnnuler;
	
    @FXML
    private Button bnCotAnn;

    @FXML
    private Button bnValider;

    @FXML
    private TableView<Cours> lesCours;
    
    @FXML
    void annuler(ActionEvent event) throws IOException {
    	Main.fermerAjouterCours(event);
    	Main.ouvrirModification(event);
    }

    @FXML
    void valider(ActionEvent event) throws IOException {
    	Cours c = lesCours.getSelectionModel().getSelectedItem();
    	if(p.getMesCours().contains(c)) {
    		Alert alert = new Alert(
        			AlertType.ERROR,
        			"Cour deja ajouter"
        			);
        	alert.setTitle("Validation impossible");
        	alert.showAndWait();
    	}else {
    		try {
    			p.ajouterUnCours(c);
    			Main.fermerAjouterCours(event);
            	Main.ouvrirModification(event);
			} catch (TropDeCoursExecption e) {
				Alert alert = new Alert(
	        			AlertType.ERROR,
	        			"L'éleve assiste à trop de cour.\n"
	        			+ "il ne peux pas en suivre d'autre "
	        			);
	        	alert.setTitle("Validation");
	        	alert.showAndWait();
			}
    		
    	}
    }
    
    @FXML void initialize() {
    	
    	TableColumn<Cours, String> colonne1 = new TableColumn<Cours,String>("Cours");
		colonne1.setCellValueFactory(new PropertyValueFactory<Cours,String>("intituler"));
		lesCours.getColumns().set(0, colonne1);
		
		
		lesCours.setItems(Main.getLesCours());
		lesCours.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		
		//A FAIRE griser les boutons Modifier et Supprimer quand aucune sélection
		
		BooleanBinding rien =
				 Bindings.equal(lesCours.getSelectionModel().selectedIndexProperty()
				, -1);
		bnValider.disableProperty().bind(Bindings.when(rien).then(true).otherwise(false));

    }

    public ObservableList<Cours> CoursPersonne(Personne p) {
    	ObservableList<Cours> lesCour = FXCollections.observableArrayList();
    	Iterator<Cours> iter = Main.getLesCours().iterator();
    	while(iter.hasNext()) {
    		Cours cours = iter.next();
    		if(!p.getMesCours().contains(cours)) {
    			lesCour.add(cours);
    		}
    	}
    	
    	
    	return lesCour;
    }
    
    public void update() {
    	lesCours.setItems(CoursPersonne(p));
    }
    
	public static Personne getP() {
		return p;
	}

	public static void setP(Personne p) {
		CtrlAjouterCours.p = p;
	}
    
    

}
