package controleur;

import java.io.IOException;

import Exceptions.StatusException;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import modele.Main;
import modele.Personne_Montant;

public class PageRappelControllerClass {

    @FXML
    private Button Ouvrir_Facture;

    @FXML
    private TableView<Personne_Montant> tvListePersonneImpayes;

    @FXML
    private Button Ouvrir_Rappel;

    @FXML
    private Button bnRappel;

    @FXML
    private Button Ouvrir_Cotisation;

    @FXML
    private TableColumn<Personne_Montant, String> nom;

    @FXML
    private TableColumn<Personne_Montant, String> prenom;

    @FXML
    private TableColumn<Personne_Montant, Double> montantPaye;

    @FXML
    private TableColumn<Personne_Montant, String> status;

    @FXML
    private TableColumn<Personne_Montant, Double> montantDu;

    @FXML
    private Button Quitter;

    @FXML
    void rappel(ActionEvent event) throws IOException {
        Main.ouvrirEmail(event);
        Main.fermerRappel(event);
    }

    @FXML
    void quitter(ActionEvent event) {
        System.out.println("Fenetre fermer correctement...");
        System.exit(0);
    }

    public void initialize() throws StatusException{

        // Permet d'ajouter les colonnes et un nom pour chaque en-tete 
		nom.setCellValueFactory(new PropertyValueFactory<Personne_Montant,String>("nom"));
        tvListePersonneImpayes.getColumns().set(0,nom);
		prenom.setCellValueFactory(new PropertyValueFactory<Personne_Montant,String>("prenom"));
        tvListePersonneImpayes.getColumns().set(1,prenom);
		status.setCellValueFactory(new PropertyValueFactory<Personne_Montant,String>("status"));
        tvListePersonneImpayes.getColumns().set(2,status);
		montantDu.setCellValueFactory(new PropertyValueFactory<Personne_Montant,Double>("montantDu"));
        tvListePersonneImpayes.getColumns().set(3,montantDu);
		montantPaye.setCellValueFactory(new PropertyValueFactory<Personne_Montant,Double>("montantPaye"));
        tvListePersonneImpayes.getColumns().set(4,montantPaye);

        // Ajouter dans la TableList les données de chaque élément qu'on a mis dans le main.
        tvListePersonneImpayes.setItems(Main.getLesEmployes());
        tvListePersonneImpayes.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        // Permet de griser lorsqu'on ne sélectionne rien
        BooleanBinding bool = Bindings.equal(tvListePersonneImpayes.getSelectionModel().selectedIndexProperty(),-1);
		bnRappel.disableProperty().bind(Bindings.when(bool).then(true).otherwise(false));

        Ouvrir_Rappel.setDisable(true);
    }
}
