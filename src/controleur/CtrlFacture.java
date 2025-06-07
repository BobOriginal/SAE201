package controleur;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.StringBinding;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import modele.Donnee;
import modele.Facture;
import modele.Main;

public class CtrlFacture {

    private modele.Personne personne;
    private String nomTampon;
    private String adresseTampon;
    private String montantTampon;
    private String montantPayerTampon;
    private String resteApayerTampon;
    private String modePaiementTampon;

    private StringProperty sexeDestinataire = new SimpleStringProperty();
    private StringProperty nomDestinataire = new SimpleStringProperty();
    private StringProperty prenomDestinataire = new SimpleStringProperty();
    private StringProperty espace = new SimpleStringProperty(" ");

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
    private TextField Prenom_Resumer;

    @FXML
    private TextField Ville_Resumer;

    @FXML
    private TextField Code_Postal_Resumer;

    @FXML
    private TextField Date_Facture_Resumer;

    @FXML
    private RadioButton Monsieur;

    @FXML
    private RadioButton Madame;

    @FXML
    void AllerAuRappel(ActionEvent event) {

    }

    @FXML
    void allerAuCotisation(ActionEvent event) {

    }

    @FXML
    void archiver(ActionEvent event) {
        personne.setEtatArchivage(true);
        modele.Facture facture = new Facture(personne);
        Donnee.listeFacture.ajouterArchive(facture);
        Numero_Val.setText(" " + facture.getNumero());
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

        enableDisable(false);
    }

    @FXML
    void retourMenu(ActionEvent event) {

        Main.retourMenu();

    }

    @FXML
    public void initialize(modele.Personne e) {
        personne = e;

        enableDisable(true);

        Nom_Etudiant.textProperty().bind(e.nomProperty());
        Regler_Par_Resumer.textProperty().bindBidirectional(e.nomProperty());
        Prenom_Resumer.textProperty().bindBidirectional(e.prenomProperty());

        Adr_Val.textProperty().bind(e.adresseProperty());
        Adresse_Resumer.textProperty().bindBidirectional(e.adresseProperty());

        Code_Postal_Val.textProperty().bind(Bindings.convert(e.codePostalProperty()));
        Code_Postal_Resumer.textProperty().bindBidirectional(e.codePostalProperty());

        Ville_Val.textProperty().bind(e.villeProperty());
        Ville_Resumer.textProperty().bindBidirectional(e.villeProperty());

        Date_Facture_Resumer.setText(aujourdhui());
        Date_Val.textProperty().bindBidirectional(Date_Facture_Resumer.textProperty());

        sexeDestinataire.bindBidirectional(e.sexeProperty());
        nomDestinataire.bindBidirectional(e.nomProperty());
        prenomDestinataire.bindBidirectional(e.prenomProperty());

        StringBinding value = (StringBinding) sexeDestinataire
                .concat(espace
                        .concat(nomDestinataire
                                .concat(espace
                                        .concat(prenomDestinataire))));

        Sexe_Nom_Prenom_Val.textProperty().bind(value);

        Montant_Payer_Resumer.textProperty().bind(personne.getMaCotisation().getTotal());
    }

    public void quitter() {
        System.out.println("Fenetre fermer correctement...");
        System.exit(0);
    }

    public void annuler(ActionEvent event) {
        personne.setNom(nomTampon);
        personne.setAdresse(adresseTampon);

        enableDisable(true);
    }

    public String aujourdhui() {
        // Merci a developpez.net, j'avais la flemme
        return LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }

    public void enregistrer() {
        enableDisable(true);
    }

    public void modifierGenre() {
        sexeDestinataire.set(sexeDestinataire.get().equals("Mme") ? "Mr" : "Mme");
    }

    public void enableDisable(boolean val) {
        Monsieur.setDisable(val);
        Madame.setDisable(val);
        Annuler_Button.setDisable(val);
        Enregistrer_Button.setDisable(val);
        Regler_Par_Resumer.setDisable(val);
        Adresse_Resumer.setDisable(val);
        Montant_Payer_Resumer.setDisable(val);
        Mode_Paiement_Resumer.setDisable(val);
        Prenom_Resumer.setDisable(val);
        Ville_Resumer.setDisable(val);
        Prenom_Resumer.setDisable(val);
        Code_Postal_Resumer.setDisable(val);
        Date_Facture_Resumer.setDisable(val);

        Archiver_Button.setDisable(!val);
        Modifier_Button.setDisable(!val);
    }

}
