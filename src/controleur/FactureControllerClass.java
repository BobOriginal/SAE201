package controleur;

import Exceptions.EtudiantNullException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

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
        Cree_Button.setDisable(true);
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

}
