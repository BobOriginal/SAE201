package controleur;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import modele.Personne;

public class FactureControllerClass {

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
    private Label Nom_Etudiant;

    @FXML
    public void initialize(Personne e) {
        Nom_Etudiant.setText(e.getNom() + " " + e.getPrenom());
        Nom_Resumer.setText("Régler par : " + e.getNom());
        Adresse_Resumer.setText("Addresse : ");
    }

    public void quitter() {
        System.out.println("Fenetre fermer correctement...");
        System.exit(0);
    }

    public void ouvrirFacture(ActionEvent event) {
        vue.FactureFen.ouvrirFacture();
    }
}
