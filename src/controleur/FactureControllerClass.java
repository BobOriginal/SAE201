package controleur;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.StringBinding;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import modele.Personne;
import vue.FactureFen;

public class FactureControllerClass {

    private modele.Personne personne;
    private String nomTampon;
    private String adresseTampon;
    private String montantTampon;
    private String montantPayerTampon;
    private String resteApayerTampon;
    private String modePaiementTampon;

    @FXML
    private Label Adr_Val;

    @FXML
    private TextField Adresse_Resumer;

    @FXML
    private Button Archiver_Button;

    @FXML
    private Button Changer_Eleve_Button;

    @FXML
    private Label Code_Postal_Val;

    @FXML
    private Button Cotisation_Button;

    @FXML
    private Label Date_Val;

    @FXML
    private TableColumn<?, ?> Description_Col;

    @FXML
    private Button Facturation_Button;

    @FXML
    private Button Liste_Inscrit;

    @FXML
    private TextField Mode_Paiement_Resumer;

    @FXML
    private Label Mode_Paiement_Val;

    @FXML
    private Button Modifier_Button;

    @FXML
    private TextField Montant_Payer_Resumer;

    @FXML
    private Label Montant_Payer_Val;

    @FXML
    private TextField Montant_Resumer;

    @FXML
    private Label Nom_Etudiant;

    @FXML
    private TableColumn<?, ?> Nombre_Heure_Col;

    @FXML
    private Label Numero_Val;

    @FXML
    private TableColumn<?, ?> Prix_Col;

    @FXML
    private Button Quitter_Button;

    @FXML
    private Button Rappel_Button;

    @FXML
    private TextField Regler_Par_Resumer;

    @FXML
    private TextField Reste_Payer_Resumer;

    @FXML
    private Label Sexe_Nom_Prenom_Val;

    @FXML
    private Label Total_Val;

    @FXML
    private Label Ville_Val;

    @FXML
    private Button Annuler_Button;

    @FXML
    private Button Enregistrer_Button;

    @FXML
    void AllerAuRappel(ActionEvent event) {

    }

    @FXML
    void allerAuCotisation(ActionEvent event) {

    }

    @FXML
    void archiver(ActionEvent event) {

    }

    @FXML
    void changer_eleve(ActionEvent event) {

    }

    @FXML
    void modifier(ActionEvent event) {

        nomTampon = Nom_Etudiant.getText();
        adresseTampon = Adr_Val.getText();
        montantPayerTampon = Montant_Payer_Val.getText();
        modePaiementTampon = Mode_Paiement_Val.getText();

        Annuler_Button.setDisable(false);
        Enregistrer_Button.setDisable(false);
        Regler_Par_Resumer.setDisable(false);
        Adresse_Resumer.setDisable(false);
        Montant_Resumer.setDisable(false);
        Montant_Payer_Resumer.setDisable(false);
        Reste_Payer_Resumer.setDisable(false);
        Mode_Paiement_Resumer.setDisable(false);
    }

    @FXML
    void retourMenu(ActionEvent event) {

    }

    @FXML
    public void initialize(modele.Personne e) {
        personne = e;

        Annuler_Button.setDisable(true);
        Enregistrer_Button.setDisable(true);
        Regler_Par_Resumer.setDisable(true);
        Adresse_Resumer.setDisable(true);
        Montant_Resumer.setDisable(true);
        Montant_Payer_Resumer.setDisable(true);
        Reste_Payer_Resumer.setDisable(true);
        Mode_Paiement_Resumer.setDisable(true);

        Nom_Etudiant.textProperty().bind(e.getNom());
        Adr_Val.textProperty().bind(e.getAdresse());
        Code_Postal_Val.textProperty().bind(Bindings.convert(e.getCodePostal()));
        Ville_Val.textProperty().bind(e.getVille());

        Regler_Par_Resumer.textProperty().bindBidirectional(e.getNom());
        Adresse_Resumer.textProperty().bindBidirectional(e.getAdresse());

        StringBinding sexeNomPrenomBinding = Bindings.createStringBinding(
                () -> e.getSexe() + " " + e.getNom() + " " + e.getPrenom());

        Sexe_Nom_Prenom_Val.textProperty().bind(sexeNomPrenomBinding);
    }

    public void quitter() {
        System.out.println("Fenetre fermer correctement...");
        System.exit(0);
    }

    public void annuler(ActionEvent event) {
        personne.setNom(nomTampon);
        personne.setAdresse(adresseTampon);

        Annuler_Button.setDisable(true);
        Enregistrer_Button.setDisable(true);
        Regler_Par_Resumer.setDisable(true);
        Adresse_Resumer.setDisable(true);
        Montant_Resumer.setDisable(true);
        Montant_Payer_Resumer.setDisable(true);
        Reste_Payer_Resumer.setDisable(true);
        Mode_Paiement_Resumer.setDisable(true);
    }

    public void enregistrer() {
        Annuler_Button.setDisable(true);
        Enregistrer_Button.setDisable(true);
        Regler_Par_Resumer.setDisable(true);
        Adresse_Resumer.setDisable(true);
        Montant_Resumer.setDisable(true);
        Montant_Payer_Resumer.setDisable(true);
        Reste_Payer_Resumer.setDisable(true);
        Mode_Paiement_Resumer.setDisable(true);
    }

}
