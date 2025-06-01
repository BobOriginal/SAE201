package controleur;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;

public class PagePrincpaleControllerClass {

    @FXML
    private TableColumn<?, ?> Info_Paiement_Col;

    @FXML
    private TableColumn<?, ?> Nom_Eleve_Col;

    @FXML
    private Button Ouvrir_Cotisation;

    @FXML
    private Button Ouvrir_Facture;

    @FXML
    private Button Ouvrir_Rappel;

    @FXML
    private Button Quitter;

    public void quitter() {
        System.out.println("Fenetre fermer correctement...");
        System.exit(0);
    }

}
