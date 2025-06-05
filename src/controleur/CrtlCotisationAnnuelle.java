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
import modele.InfoTabView;

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

    @FXML
    private TableView<InfoTabView> listeCotisation;

    @FXML void initialize() {
    	Donnee.chargementDonnees();
    	TableColumn<InfoTabView, String> colonne1 = new TableColumn<InfoTabView,String>("Nom");
		colonne1.setCellValueFactory(new PropertyValueFactory<InfoTabView,String>("nom"));
		listeCotisation.getColumns().set(0, colonne1);
		TableColumn<InfoTabView, String> colonne2 = new TableColumn<InfoTabView,String>("Prenom");
		colonne2.setCellValueFactory(new PropertyValueFactory<InfoTabView, String>("prenom"));
		listeCotisation.getColumns().set(1, colonne2);
		TableColumn<InfoTabView, String> colonne3 = new TableColumn<InfoTabView,String>("Status");
		colonne3.setCellValueFactory(new PropertyValueFactory<InfoTabView, String>("status"));
		listeCotisation.getColumns().set(2, colonne3);
		TableColumn<InfoTabView, String> colonne4 = new TableColumn<InfoTabView,String>("Type de paiement");
		colonne4.setCellValueFactory(new PropertyValueFactory<InfoTabView, String>("typePaiement"));
		listeCotisation.getColumns().set(3, colonne4);
		TableColumn<InfoTabView, Boolean> colonne5 = new TableColumn<InfoTabView,Boolean>("A Payer");
		colonne5.setCellValueFactory(new PropertyValueFactory<InfoTabView, Boolean>("aPayer"));
		listeCotisation.getColumns().set(4, colonne5);
		TableColumn<InfoTabView, Double> colonne6 = new TableColumn<InfoTabView,Double>("Montant");
		colonne6.setCellValueFactory(new PropertyValueFactory<InfoTabView, Double>("montant"));
		listeCotisation.getColumns().set(5, colonne6);
		TableColumn<InfoTabView, String> colonne7 = new TableColumn<InfoTabView,String>("Paiement deja effectuer");
		colonne7.setCellValueFactory(new PropertyValueFactory<InfoTabView, String>("paimentEffectuer"));
		listeCotisation.getColumns().set(6, colonne7);
		
		
		listeCotisation.setItems(Donnee.getLesInfo());
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
