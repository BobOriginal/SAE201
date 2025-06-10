
package controleur;

import java.io.IOException;
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
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.converter.NumberStringConverter;
import modele.Donnee;
import modele.Facture;
import modele.InfoTabView;
import modele.Main;

public class CtrlFacture {

    private modele.Personne personne;

    private String nomTampon;
    private String prenomTampon;
    private String adresseTampon;
    private int totalTampon;
    private String modePaiementTampon;
    private String codePostalTampon;
    private String dateTampon;
    private String villeTampon;
    private String sexeTampon;

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
    private TextField Total_Resumer;

    @FXML
    private Label Montant_Payer_Val;

    @FXML
    private Label Nom_Etudiant;

    @FXML
    private Label Numero_Val;

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
    private TableView<InfoTabView> Tableau;

    @FXML
    void AllerAuRappel(ActionEvent event) throws IOException {
        Main.ouvrirRappel(event);
        Main.fermerFacture(event);
    }

    @FXML
    void allerAuCotisation(ActionEvent event) throws IOException {
        Main.ouvrirCotisation(event);
        Main.fermerFacture(event);
    }

    @FXML
    void archiver(ActionEvent event) throws IOException {
        personne.setEtatArchivage(true);
        modele.Facture facture = new Facture(personne, Date_Val.getText());
        Donnee.listeFacture.ajouterArchive(facture);
        Numero_Val.setText(" " + facture.getNumero());

        Main.ouvrirPagePrincipale(event);
        Main.fermerFacture(event);
    }

    @FXML
    void changer_eleve(ActionEvent event) throws IOException {
        Main.ouvrirPagePrincipale(event);
        Main.fermerFacture(event);
    }

    @FXML
    void modifier(ActionEvent event) {
        nomTampon = personne.getNom();
        prenomTampon = personne.getPrenom();
        adresseTampon = personne.getAdresse();
        totalTampon = personne.getMaCotisation().getTotal();
        modePaiementTampon = personne.getMaCotisation().getTypePaiment();
        codePostalTampon = personne.getCodePostal();
        villeTampon = personne.getVille();
        dateTampon = personne.getMaCotisation().getDatePaiement();
        sexeTampon = personne.getSexe();
        // private String dateTampon;

        enableDisable(false);
    }

    @FXML
    void retourMenu(ActionEvent event) throws IOException {
        Main.ouvrirPagePrincipale(event);
        Main.fermerFacture(event);
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

        Date_Facture_Resumer.textProperty().bindBidirectional(e.getMaCotisation().DatePaiementProperty());
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

        NumberStringConverter converter = new NumberStringConverter();
        Bindings.bindBidirectional(Total_Resumer.textProperty(), personne.getMaCotisation().totalProperty(),
                converter);
        Total_Val.textProperty().bind(Bindings.convert(personne.getMaCotisation().totalProperty()));
        Montant_Payer_Val.textProperty().bind(Bindings.convert(personne.getMaCotisation().ResteApayerProperty()));
        Mode_Paiement_Resumer.textProperty().bindBidirectional(personne.getMaCotisation().typePaiementProperty());
        Mode_Paiement_Val.textProperty().bind(personne.getMaCotisation().typePaiementProperty());

        // Tableau pas encore fonctionnel
        TableColumn<InfoTabView, String> colonne1 = new TableColumn<InfoTabView, String>("Description");
        colonne1.setCellValueFactory(new PropertyValueFactory<InfoTabView, String>("cours"));
        Tableau.getColumns().set(0, colonne1);

        TableColumn<InfoTabView, String> colonne2 = new TableColumn<InfoTabView, String>("Nombre d'heure");
        colonne2.setCellValueFactory(new PropertyValueFactory<InfoTabView, String>("nbHeure"));
        Tableau.getColumns().set(1, colonne2);

        TableColumn<InfoTabView, String> colonne3 = new TableColumn<InfoTabView, String>("prix");
        colonne3.setCellValueFactory(new PropertyValueFactory<InfoTabView, String>("montantCour"));
        Tableau.getColumns().set(2, colonne3);

        Tableau.setItems(Main.getLesInfoCours());
        Tableau.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        if (sexeDestinataire.get().equals("Mr")) {
            Monsieur.setSelected(true);
        } else {
            Madame.setSelected(true);
        }

    }

    public void quitter() {
        System.out.println("Fenetre fermer correctement...");
        System.exit(0);
    }

    public void annuler(ActionEvent event) {

        personne.setNom(nomTampon);
        personne.setPrenom(prenomTampon);
        personne.setAdresse(adresseTampon);
        personne.getMaCotisation().setMontant(totalTampon);
        personne.getMaCotisation().setTypePaiement(modePaiementTampon);
        personne.setCodePostal(codePostalTampon);
        personne.setVille(villeTampon);
        personne.getMaCotisation().setDatePaiement(dateTampon);
        personne.setSexe(sexeTampon);

        enableDisable(true);

        if (sexeDestinataire.get().equals("Mr")) {
            Monsieur.setSelected(true);
        } else {
            Madame.setSelected(true);
        }
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
        Total_Resumer.setDisable(val);
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
