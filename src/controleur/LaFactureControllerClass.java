package controleur;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;

public class LaFactureControllerClass {
    @FXML
    private Label Adr_Val;

    @FXML
    private Label Code_Postal_Val;

    @FXML
    private Label Date_Val;

    @FXML
    private TableColumn<?, ?> Description_Col;

    @FXML
    private Label Mode_Paiement_Val;

    @FXML
    private Label Montant_Payer_Val;

    @FXML
    private TableColumn<?, ?> Nombre_Heure_Col;

    @FXML
    private Label Numero_Val;

    @FXML
    private TableColumn<?, ?> Prix_Col;

    @FXML
    private Label Sexe_Nom_Prenom_Val;

    @FXML
    private Label Total_Val;

    @FXML
    private Label Ville_Val;

    public void inizialize(modele.Personne p) {

    }

    private void setSexeNomPrenom(modele.Personne p) {
    }

}
