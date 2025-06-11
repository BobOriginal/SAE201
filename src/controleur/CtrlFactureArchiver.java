package controleur;

import java.util.Iterator;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import modele.Cours;
import modele.InfoTabViewCours;
import modele.Personne;

public class CtrlFactureArchiver {

    private static modele.Facture facture;

    @FXML
    private Label Adr_Val;

    @FXML
    private Label Code_Postal_Val;

    @FXML
    private Label Date_Val;

    @FXML
    private Label Mode_Paiement_Val;

    @FXML
    private Label Montant_Payer_Val;

    @FXML
    private Label Numero_Val;

    @FXML
    private Label Sexe_Nom_Prenom_Val;

    @FXML
    private Label Total_Val;

    @FXML
    private Label Ville_Val;

    @FXML
    private TableView<InfoTabViewCours> Tableau;

    @FXML
    public void initialize() {

        TableColumn<InfoTabViewCours, String> colonne1 = new TableColumn<InfoTabViewCours, String>("Description");
        colonne1.setCellValueFactory(new PropertyValueFactory<InfoTabViewCours, String>("libelle"));
        Tableau.getColumns().set(0, colonne1);

        TableColumn<InfoTabViewCours, Double> colonne2 = new TableColumn<InfoTabViewCours, Double>("Nombre d'heure");
        colonne2.setCellValueFactory(new PropertyValueFactory<InfoTabViewCours, Double>("nbHeure"));
        Tableau.getColumns().set(1, colonne2);

        TableColumn<InfoTabViewCours, Double> colonne3 = new TableColumn<InfoTabViewCours, Double>("prix");
        colonne3.setCellValueFactory(new PropertyValueFactory<InfoTabViewCours, Double>("prix"));
        Tableau.getColumns().set(2, colonne3);

    }

    public void setFacture(modele.Facture f) {
        facture = f;
        Adr_Val.setText(facture.getPersonne().getAdresse());
        Code_Postal_Val.setText(facture.getPersonne().getCodePostal());
        Date_Val.setText(facture.getDate());
        Mode_Paiement_Val.setText(facture.getCotisation().getTypePaiment());
        Montant_Payer_Val.setText(facture.getCotisation().getTotal().toString());
        Numero_Val.setText("" + facture.getNumero());

        Sexe_Nom_Prenom_Val.setText(facture.getPersonne().getSexe() + " " +
                facture.getPersonne().getNom() + " " +
                facture.getPersonne().getPrenom());

        Total_Val.setText(facture.getCotisation().getTotal().toString());

    }

    public void updateTab() {
        Tableau.setItems(CoursPersonne(facture.getPersonne()));
        Tableau.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    }

    public ObservableList<InfoTabViewCours> CoursPersonne(Personne p) {
        ObservableList<InfoTabViewCours> mesCours = FXCollections.observableArrayList();
        Iterator<Cours> iter = p.getMesCours().iterator();
        // System.out.print(p);
        while (iter.hasNext()) {
            Cours c = iter.next();
            mesCours.add(new InfoTabViewCours(c, p));
        }
        return mesCours;
    }

}
