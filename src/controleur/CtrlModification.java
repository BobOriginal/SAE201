package controleur;

import java.net.URL;
import java.util.Iterator;
import java.util.ResourceBundle;

import javafx.scene.control.TableView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import modele.Cours;
import modele.Personne;

public class CtrlModification {
	private static Personne laPersonne = null;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button ajouter;

    @FXML
    private Button supprimer;
    
    @FXML
    private TableView<Cours> lesCours;

    @FXML
    void ajouterCours(ActionEvent event) {

    }

    @FXML
    void supprimerCours(ActionEvent event) {

    }

    @FXML
	public
    void initialize() {
    	
    

    }
    public void metAjourTab(){
    	TableColumn<Cours, String> colonne1 = new TableColumn<Cours,String>("Cours");
		colonne1.setCellValueFactory(new PropertyValueFactory<Cours,String>("intituler"));
		lesCours.getColumns().set(0, colonne1);
		
		lesCours.setItems(CoursPersonne(laPersonne));
		lesCours.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    }

    public ObservableList<Cours> CoursPersonne(Personne p) {
    	ObservableList<Cours> mesCours = FXCollections.observableArrayList();
    	Iterator<Cours> iter = p.getMesCours().iterator();
    	System.out.print(p);
    	while(iter.hasNext()) {
    		mesCours.add(iter.next());
    		System.out.print(mesCours);
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

