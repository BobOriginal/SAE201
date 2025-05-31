package vue;

import java.io.File;
import java.io.IOException;

import Exceptions.StatusException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import modele.Cours;
import modele.Personne;

public class FactureFen extends Fenetre {

    private Personne e1 = null;

    public FactureFen() throws IOException {
        this.setTitle("Organizatore di Dance");
        this.setResizable(true);
        Scene laScene = new Scene(creerSceneGraph());
        this.setScene(laScene);
    }

    private Pane creerSceneGraph() throws IOException {
        // Dans l'instruction suivante, indiquer le chemin complet du fichier fxml
        File fichier = new File("src/vue/full_facture.fxml");
        FXMLLoader loader;
        loader = new FXMLLoader(fichier.toURI().toURL());
        Pane racine = loader.load();
        ctrl = loader.getController();

        ctrl.setEleve(fauxEleveTest());
        return racine;
    }

    private Personne fauxEleveTest() {

        try {
            e1 = new Personne("Conan", "Tom", "plein tarif");
            e1.ajouterUnCours(new modele.CoursAvancer(2025, 4, "oui"));
            ctrl.setEleve(e1);
        } catch (StatusException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return e1;
    }

    public Personne getEleve() {
        return e1;
    }

}
