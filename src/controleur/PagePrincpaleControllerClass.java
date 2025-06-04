package controleur;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import modele.Main;
import modele.Personne;

public class PagePrincpaleControllerClass {
    @FXML
    private TableView<Personne> tvListePersonne;
    @FXML
    private Button Ouvrir_Cotisation;

    @FXML
    private Button Ouvrir_Facture;

    @FXML
    private Button Ouvrir_Rappel;

    @FXML
    private Button Quitter;

    public void quitter() {
        System.out.println("Fenetre fermer correctement...");
        System.exit(0);
    }
    public void initialize(){
        TableColumn<Personne,String> colonne1 = new TableColumn<Personne,String>("Nom");
		colonne1.setCellValueFactory(new PropertyValueFactory<Personne,String>("nom"));
        tvListePersonne.getColumns().set(0,colonne1);
        TableColumn<Personne,String> colonne2 = new TableColumn<Personne,String>("Prénom");
		colonne2.setCellValueFactory(new PropertyValueFactory<Personne,String>("prenom"));
        tvListePersonne.getColumns().set(1,colonne2);
        TableColumn<Personne,String> colonne3 = new TableColumn<Personne,String>("Statut");
		colonne3.setCellValueFactory(new PropertyValueFactory<Personne,String>("status"));
        tvListePersonne.getColumns().set(2,colonne3);

        tvListePersonne.setItems(Main.getLesEmployes());
        tvListePersonne.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    }


}
