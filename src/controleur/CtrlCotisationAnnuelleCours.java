package controleur;

import java.io.IOException;
import java.util.Iterator;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import modele.Cours;
import modele.Donnee;
import modele.InfoTabView;
import modele.Main;
import modele.Personne;

public class CtrlCotisationAnnuelleCours {


	@FXML
    private Label Reste_a_payer;

    @FXML
    private Label Total_deja_payer;

    @FXML
    private Label Total_prevu;

    @FXML
    private Button bnFacturation;

    @FXML
    private Button bnListeImpayer;

    @FXML
    private Button bnListeInscrit;

    @FXML
    private Button bnModifier;

    @FXML
    private Button bnQuitter;

    @FXML
    private Button bnRappel;

    @FXML
    private Button bnSuprimer;

    @FXML
    private Button bnTrierCour;

    @FXML
    private Button bnTriezNom;

    @FXML
    private TableView<InfoTabView> listeCotisation;
    
    @FXML
    private TableView<Cours> tabCour;


    @FXML
    private Button bnSelectioner;

    @FXML
    void changeTab(ActionEvent event) {
    	Cours c = tabCour.getSelectionModel().getSelectedItem();
    	updateTrie(c);
    }
    
   
    
    private void updateTrie(Cours c) {
    	ObservableList<InfoTabView> lesInfo = FXCollections.observableArrayList();
    	Iterator<InfoTabView> iter = Main.getLesInfoCours().iterator();
    	while(iter.hasNext()) {
    		InfoTabView info = iter.next();
    		if(info.getCours().equals(c.getIntituler())) {
    			lesInfo.add(info);
    		}
    	}
    	
    	listeCotisation.setItems(lesInfo);
    }
    
    @FXML
    void listeInscrit(ActionEvent event) throws IOException{
    	Main.fermerCotisationCours(event);
    	Main.ouvrirPagePrincipale(event);
    	
    }
    
    @FXML
    void quitter(ActionEvent event) throws IOException {
    	Main.quitter(event);
    }

    @FXML
    void rappel(ActionEvent event) throws IOException {
    	Main.fermerCotisationCours(event);
    	Main.ouvrirRappel(event);
    }

    @FXML
    void facturation(ActionEvent event) throws IOException {
    	controleur.CtrlFacture.setEleve(listeCotisation.getSelectionModel().getSelectedItem().getP());
    	Main.fermerCotisation(event);
    	Main.ouvrirFacture(event);
    }


    @FXML void initialize() {
    	
    	Total_prevu.textProperty().bind(Bindings.concat(Donnee.total()+"€"));
    	Total_deja_payer.textProperty().bind(Bindings.concat(Donnee.dejaPayer()+"€"));
    	Reste_a_payer.textProperty().bind(Bindings.concat(Donnee.resteAPayer()+"€"));
    	
    	TableColumn<InfoTabView, String> colonne1 = new TableColumn<InfoTabView,String>("Cours");
		colonne1.setCellValueFactory(new PropertyValueFactory<InfoTabView,String>("cours"));
		listeCotisation.getColumns().set(0, colonne1);
		
		TableColumn<InfoTabView, String> colonne2 = new TableColumn<InfoTabView,String>("Nom");
		colonne2.setCellValueFactory(new PropertyValueFactory<InfoTabView, String>("nom"));
		listeCotisation.getColumns().set(1, colonne2);
		
		TableColumn<InfoTabView, String> colonne3 = new TableColumn<InfoTabView,String>("Prenom");
		colonne3.setCellValueFactory(new PropertyValueFactory<InfoTabView, String>("prenom"));
		listeCotisation.getColumns().set(2, colonne3);
		
		TableColumn<InfoTabView, String> colonne4 = new TableColumn<InfoTabView,String>("Status");
		colonne4.setCellValueFactory(new PropertyValueFactory<InfoTabView, String>("Status"));
		listeCotisation.getColumns().set(3, colonne4);
		
		TableColumn<InfoTabView, String> colonne5 = new TableColumn<InfoTabView,String>("Type de paiement");
		colonne5.setCellValueFactory(new PropertyValueFactory<InfoTabView, String>("typePaiement"));
		listeCotisation.getColumns().set(4, colonne5);
		
		TableColumn<InfoTabView, Boolean> colonne6 = new TableColumn<InfoTabView,Boolean>("A Payer");
		colonne6.setCellValueFactory(new PropertyValueFactory<InfoTabView, Boolean>("aPayerCour"));
		listeCotisation.getColumns().set(5, colonne6);
		
		TableColumn<InfoTabView, Double> colonne7 = new TableColumn<InfoTabView,Double>("Montant");
		colonne7.setCellValueFactory(new PropertyValueFactory<InfoTabView, Double>("montantCour"));
		listeCotisation.getColumns().set(6, colonne7);
		
		TableColumn<InfoTabView, String> colonne8 = new TableColumn<InfoTabView,String>("Paiement deja effectuer");
		colonne8.setCellValueFactory(new PropertyValueFactory<InfoTabView, String>("paiementEffectuerCour"));
		listeCotisation.getColumns().set(7, colonne8);
		
		listeCotisation.setItems(Main.getLesInfoCours());
		listeCotisation.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		
		//A FAIRE griser les boutons Modifier et Supprimer quand aucune sélection
		
		BooleanBinding rien =
				 Bindings.equal(listeCotisation.getSelectionModel().selectedIndexProperty()
				, -1);
		bnSuprimer.disableProperty().bind(Bindings.when(rien).then(true).otherwise(false));
		bnModifier.disableProperty().bind(Bindings.when(rien).then(true).otherwise(false));
		bnFacturation.disableProperty().bind(Bindings.when(rien).then(true).otherwise(false));
		
		
		//tabCours
		
		TableColumn<Cours, String> colonne1Cour = new TableColumn<Cours,String>("Cours");
		colonne1Cour.setCellValueFactory(new PropertyValueFactory<Cours,String>("intituler"));
		tabCour.getColumns().set(0, colonne1Cour);
		
		tabCour.setItems(Main.getLesCours());
		tabCour.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		
		BooleanBinding rien2 =
				 Bindings.equal(tabCour.getSelectionModel().selectedIndexProperty()
				, -1);
		bnSelectioner.disableProperty().bind(Bindings.when(rien2).then(true).otherwise(false));
		
		
    }
    
    @FXML
    void trierCour(ActionEvent event) throws IOException {
    	Main.fermerCotisation(event);
    	Main.ouvrirCotisationCours(event);
    }

    @FXML
    void triezNom(ActionEvent event) throws IOException {
    	Main.fermerCotisationCours(event);
    	Main.ouvrirCotisation(event);
    }

   
    @FXML
    void modifier(ActionEvent event) throws IOException {
    	Personne p = listeCotisation.getSelectionModel().getSelectedItem().getP();
    	if(p.getStatus().equals(Personne.NON_INSCRIT)) {
    		Alert alert = new Alert(
        			AlertType.ERROR,
        			"Cette personne n'assite a aucun cour"
        			);
        	alert.setTitle("Modification impossible");
        	alert.show();
    	}
    	else {
    		CtrlModification.setlaPersonne(p);
        	Main.fermerCotisationCours(event);
        	Main.ouvrirModification(event);
    	}
    }

    @FXML
    void suprimer(ActionEvent event) {
   
        	Alert alert = new Alert(
        			AlertType.CONFIRMATION,
        			"Voulez-vous vraiment supprimer cet cotisation annuelle elle ne pourras pas etre recrée ?",
        			ButtonType.YES,
        			ButtonType.NO
        			);
        	alert.setTitle("Confirmation de suppression");
        	if(alert.showAndWait().get() == ButtonType.YES) {
        		Donnee.removeInfo(listeCotisation.getSelectionModel().getSelectedItem());
        	}
        
    }

    @FXML
    void listeImpayer(ActionEvent event) throws IOException {
    	Main.fermerCotisationCours(event);
    	Main.ouvrirRappel(event);
    }
}
