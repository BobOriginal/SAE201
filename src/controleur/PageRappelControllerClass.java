package controleur;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import modele.Personne;

public class PageRappelControllerClass {

    @FXML
    private Button Ouvrir_Facture;

    @FXML
    private TableView<Personne> tvListePersonneImpayes;

    @FXML
    private Button Ouvrir_Rappel;

    @FXML
    private Button bnRappel;

    @FXML
    private Button Ouvrir_Cotisation;

    @FXML
    private TableColumn<Personne, String> nom;

    @FXML
    private TableColumn<Personne, String> prenom;

    @FXML
    private TableColumn<Personne, Double> montantPaye;

    @FXML
    private TableColumn<Personne, String> status;

    @FXML
    private TableColumn<Personne , Double> montantDu;

    @FXML
    private Button Quitter;

    @FXML
    void rappel(ActionEvent event) {

    }

    @FXML
    void quitter(ActionEvent event) {

    }

    public void initialize(){
		nom.setCellValueFactory(new PropertyValueFactory<Personne,String>("nom"));
        tvListePersonneImpayes.getColumns().set(0, nom);
		prenom.setCellValueFactory(new PropertyValueFactory<Personne,String>("prenom"));
        tvListePersonneImpayes.getColumns().set(1,prenom);
		status.setCellValueFactory(new PropertyValueFactory<Personne,String>("status"));
        tvListePersonneImpayes.getColumns().set(2,status);
		montantPaye.setCellValueFactory(new PropertyValueFactory<Personne,Double>("montantPaye"));
        tvListePersonneImpayes.getColumns().set(1,prenom);
		montantDu.setCellValueFactory(new PropertyValueFactory<Personne,Double>("montantDu"));
        tvListePersonneImpayes.getColumns().set(2,status);
    }
}
