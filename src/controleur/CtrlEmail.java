package controleur;

import java.io.IOException;
import java.util.regex.Pattern;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
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
    void envoyer(ActionEvent event) throws IOException {
    	Alert alertPopUp = new Alert(Alert.AlertType.INFORMATION);
        Alert alertEnvoyer = new Alert(Alert.AlertType.INFORMATION);
        if(!Pattern.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$",tfDestinataires.getText())) {
        	alertPopUp.setTitle("Erreur de regex dans le Destinataires !");
        	alertPopUp.setContentText("Mettez une paterne qui doit etre conforme à un email.");
        	alertPopUp.showAndWait();
        }
        else {
            alertEnvoyer.setTitle("Message!");
            alertEnvoyer.setContentText("Vous avez bien envoyé un rappel à l'élève");
            alertEnvoyer.showAndWait();
            tfDestinataires.setText(null);
            tfObjet.setText(null);
            taContenu.setText(null);
            Main.fermerEmail(event);
            Main.ouvrirRappel(event);
        }
    }

    @FXML
    void annuler(ActionEvent event) throws IOException {
        tfDestinataires.setText(null);
        tfObjet.setText(null);
        taContenu.setText(null);
        Main.fermerEmail(event);
        Main.ouvrirRappel(event);
    }
    public void initialize() {
        BooleanBinding bool = tfObjet.textProperty().isEmpty().or(tfDestinataires.textProperty().isEmpty())
                .or(taContenu.textProperty().isEmpty());
        bnEnvoyer.disableProperty().bind(Bindings.when(bool).then(true).otherwise(false));
        bnRappel.setDisable(true);
        Ouvrir_Cotisation.setDisable(true);
        Ouvrir_Facture.setDisable(true);
    }
    

}
