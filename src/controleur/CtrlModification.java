package controleur;

import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.ResourceBundle;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.SimpleStringProperty;
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
import modele.Main;
import modele.Personne;

public class CtrlModification {
	private static Personne laPersonne = null;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button bnAjouter;

    @FXML
    private Button bnSupprimer;
    
    @FXML
    private Button bnCotAnn;

    
    @FXML
    private TableView<Cours> lesCours;
    
    @FXML
    private Label eleve;

    @FXML
    void ajouterCours(ActionEvent event) throws IOException {
    	CtrlAjouterCours.setP(laPersonne);
    	Main.fermerModification(event);
    	Main.ouvrirAjouterCours(event);
    }
    @FXML
    void cotAnn(ActionEvent event) throws IOException {
    	Main.fermerModification(event);
    	Main.ouvrirCotisation(event);
    }

    @FXML
    void supprimerCours(ActionEvent event) {
    	Alert alert = new Alert(
    			AlertType.CONFIRMATION,
    			"Voulez-vous vraiment supprimer ce cour?",
    			ButtonType.YES,
    			ButtonType.NO
    			);
    	alert.setTitle("Confirmation de suppression");
    	if(alert.showAndWait().get() == ButtonType.YES) {
    		laPersonne.retirerCour(lesCours.getSelectionModel().getSelectedItem());
    		lesCours.setItems(CoursPersonne(laPersonne));

    	}
    }

    @FXML
	public
    void initialize() {
    	BooleanBinding rien =
				 Bindings.equal(lesCours.getSelectionModel().selectedIndexProperty()
				, -1);
    	bnSupprimer.disableProperty().bind(Bindings.when(rien).then(true).otherwise(false));
    

    }
    public void metAjourTab(){
    	TableColumn<Cours, String> colonne1 = new TableColumn<Cours,String>("Cours");
		colonne1.setCellValueFactory(new PropertyValueFactory<Cours,String>("intituler"));
		lesCours.getColumns().set(0, colonne1);
		
		lesCours.setItems(CoursPersonne(laPersonne));
		lesCours.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
	
		 eleve.textProperty().bind(new SimpleStringProperty("Cours de l\'éléve "+getlaPersonne().getNom()+" : "));
    }

    public ObservableList<Cours> CoursPersonne(Personne p) {
    	ObservableList<Cours> mesCours = FXCollections.observableArrayList();
    	Iterator<Cours> iter = p.getMesCours().iterator();
    	//System.out.print(p);
    	while(iter.hasNext()) {
    		mesCours.add(iter.next());
    		//System.out.print(mesCours);
    	}
    	return mesCours;
    }

	public static Personne getlaPersonne() {
		return laPersonne;
	}

	public static void setlaPersonne(Personne p) {
		CtrlModification.laPersonne = p;
		
	}

	
}

