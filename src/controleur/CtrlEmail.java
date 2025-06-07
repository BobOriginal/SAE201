package controleur;

import java.io.IOException;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import modele.Main;

public class CtrlEmail {

    @FXML
    private Button Ouvrir_Facture;

    @FXML
    private Button bnEnvoyer;

    @FXML
    private Button bnRappel;

    @FXML
    private Button bnAnnuler;

    @FXML
    private Button Ouvrir_Cotisation;

    @FXML
    private Button Quitter;

    @FXML
    private TextField tfObjet;

    @FXML
    private TextField tfDestinataires;

    @FXML
    private TextArea taContenu;

    @FXML
    void quitter(ActionEvent event) {
        System.out.println("Fenetre fermer correctement...");
        System.exit(0);
    }

    @FXML
    void envoyer(ActionEvent event) {

    }

    @FXML
    void annuler(ActionEvent event) throws IOException {
        Main.fermerEmail(event);
        Main.ouvrirRappel(event);
    }

    public void initialize() {
        BooleanBinding bool = tfObjet.textProperty().isEmpty().or(tfDestinataires.textProperty().isEmpty())
                .or(taContenu.textProperty().isEmpty());
        bnEnvoyer.disableProperty().bind(Bindings.when(bool).then(true).otherwise(false));
        bnRappel.setDisable(true);
    }
}
