package controleur;

import java.io.File;
import java.io.IOException;

import Exceptions.EtudiantNullException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class FactureControllerClass {

    private modele.Personne etudiant;

    @FXML
    private Label Adresse_Resumer;

    @FXML
    private Button Archiver_Button;

    @FXML
    private Button Changer_Eleve_Button;

    @FXML
    private Button Cotisation_Button;

    @FXML
    private Button Cree_Button;

    @FXML
    private Button Facturation_Button;

    @FXML
    private Button Liste_Inscrit;

    @FXML
    private Label Mode_Paiement_Resumer;

    @FXML
    private Button Modifier_Button;

    @FXML
    private Label Montant_Payer_Resumer;

    @FXML
    private Label Montant_Resumer;

    @FXML
    private Label Nom_Resumer;

    @FXML
    private Button Quitter_Button;

    @FXML
    private Button Rappel_Button;

    @FXML
    private Label Reste_Resumer;

    @FXML
    public void initialize() {
        // Cree_Button.setDisable(true);
        Archiver_Button.setDisable(true);
    }

    public void setEleve(modele.Personne p) {
        try {

            if (p != null) {
                etudiant = p;
            } else {

                throw new EtudiantNullException();
            }
        } catch (EtudiantNullException e) {
            System.out.println(e);
            // A terme, faire en sorte qu'il ramène a la pafe principale
        }
    }

    public void quitter() {
        System.out.println("Fenetre fermer correctement...");
        System.exit(0);
    }

    public void ouvrirFacture(ActionEvent event) {
        try {

            File fichier = new File("src/vue/rendu_facture.fxml");
            FXMLLoader fxmlLoader;
            fxmlLoader = new FXMLLoader(fichier.toURI().toURL());
            Parent root = fxmlLoader.load();

            Stage stage = new Stage();
            stage.setTitle("Nouvelle Fenêtre");
            stage.setScene(new Scene(root, 620, 877));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
