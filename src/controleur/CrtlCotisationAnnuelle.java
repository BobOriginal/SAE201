package controleur;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import modele.Donnee;
import modele.Personne;

public class CrtlCotisationAnnuelle {


    @FXML
    private Button bnListeImpayer;

    @FXML
    private Button bnTrierCour;

    @FXML
    private Button bnSuprimer;

    @FXML
    private Button bnTriezNom;

    @FXML
    private Button bnAjouter;

    @FXML
    private Button bnModifier;


    private TableView<Personne> listeCotisation;

    @FXML void initialize() {
    	TableColumn<Personne, String> colonne1 = new TableColumn<Personne,String>("Nom");
		colonne1.setCellValueFactory(new PropertyValueFactory<Personne,String>("nom"));	
		listeCotisation.getColumns().set(0, colonne1);
		TableColumn<Personne, String> colonne2 = new TableColumn<Personne,String>("Prenom");
		colonne2.setCellValueFactory(new PropertyValueFactory<Personne, String>("prenom"));
		listeCotisation.getColumns().set(1, colonne2);


		
		listeCotisation.setItems(Donnee.getLesPersonnes());
		listeCotisation.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		
		//A FAIRE griser les boutons Modifier et Supprimer quand aucune sélection
		
		BooleanBinding rien =
				 Bindings.equal(listeCotisation.getSelectionModel().selectedIndexProperty()
				, -1);
		bnSuprimer.disableProperty().bind(Bindings.when(rien).then(true).otherwise(false));
		bnModifier.disableProperty().bind(Bindings.when(rien).then(true).otherwise(false));
    }
    
    @FXML
    void trierCour(ActionEvent event) {

    }

    @FXML
    void triezNom(ActionEvent event) {

    }

    @FXML
    void ajouter(ActionEvent event) {

    }

    @FXML
    void modifier(ActionEvent event) {

    }

    @FXML
    void suprimer(ActionEvent event) {

    }

    @FXML
    void listeImpayer(ActionEvent event) {

    }
    
    

}
