package controleur;

import java.io.IOException;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import modele.InfoTabView;
import modele.Main;
import modele.Personne;

public class CtrlPrincipale {

    @FXML
    private TableView<InfoTabView> tvListePersonne;

    @FXML
    private Button Ouvrir_Cotisation;

    @FXML
    private Button Ouvrir_Facture;

    @FXML
    private Button Ouvrir_Rappel;

    @FXML
    private Button Ouvrir_Liste;

    @FXML
    private Button Quitter;

    @FXML
    private TableColumn<InfoTabView, Boolean> archiver;

    @FXML
    private TableColumn<InfoTabView, String> nom;

    @FXML
    private TableColumn<InfoTabView, String> prenom;

    @FXML
    private TableColumn<InfoTabView, Double> montantPaye;

    @FXML
    private TableColumn<InfoTabView, String> status;

    @FXML
    private TableColumn<InfoTabView, Double> montantDu;

    @FXML
    private Button Bouton_Archive;

    public void quitter() {
        System.out.println("Fenetre fermer correctement...");
        System.exit(0);
    }

    @FXML
    void rappel(ActionEvent event) throws IOException {
        Main.ouvrirRappel(event);
        Main.fermerPagePrincipale(event);
    }

    @FXML
    void ouvrirCotisations(ActionEvent event) throws IOException {
        Main.ouvrirCotisation(event);
        Main.fermerPagePrincipale(event);
    }

    @FXML
    void ouvrirFacturation(ActionEvent event) throws IOException {
        CtrlFacture.setEleve(tvListePersonne.getSelectionModel().getSelectedItem().getP());
        Main.ouvrirFacture(event);
        Main.fermerPagePrincipale(event);
    }

    @FXML
    void archive(ActionEvent event) throws IOException {
        Personne p = tvListePersonne.getSelectionModel().getSelectedItem().getP();
        if (p.getEtatArchivage()) {
            Main.ouvrirArchiver(event, p.getId());

        } else {
            Alert alert = new Alert(
                    AlertType.ERROR,
                    "Archive non crée allez la crée dans facturation");
            alert.show();
        }

    }

    public void initialize() {
        nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        tvListePersonne.getColumns().set(0, nom);
        prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        tvListePersonne.getColumns().set(1, prenom);
        status.setCellValueFactory(new PropertyValueFactory<>("status"));
        tvListePersonne.getColumns().set(2, status);
        montantDu.setCellValueFactory(new PropertyValueFactory<>("montant"));
        tvListePersonne.getColumns().set(3, montantDu);
        montantPaye.setCellValueFactory(new PropertyValueFactory<>("paiementEffectuer"));
        tvListePersonne.getColumns().set(4, montantPaye);

        tvListePersonne.setItems(Main.getLesInfo());
        tvListePersonne.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        BooleanBinding rien = Bindings.equal(tvListePersonne.getSelectionModel().selectedIndexProperty(), -1);
        Ouvrir_Facture.disableProperty().bind(Bindings.when(rien).then(true).otherwise(false));
        Bouton_Archive.disableProperty().bind(Bindings.when(rien).then(true).otherwise(false));
        Ouvrir_Liste.setDisable(true);
    }

}