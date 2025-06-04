package controleur;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import modele.Main;

public class PageEmailControllerClass {

    @FXML
    private Button Ouvrir_Facture;

    @FXML
    private Button bnEnvoyer;

    @FXML
    private Button Ouvrir_Rappel;

    @FXML
    private Button bnAnnuler;

    @FXML
    private Button Ouvrir_Cotisation;

    @FXML
    private Button Quitter;

    @FXML
    void quitter(ActionEvent event) {

    }

    @FXML
    void envoyer(ActionEvent event) {

    }

    @FXML
    void annuler(ActionEvent event) throws IOException {
        Main.fermerEmail(event);
        Main.ouvrirRappel(event);
    }

}

