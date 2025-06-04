package vue;

import java.io.File;
import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import modele.Personne;

public class FactureFen extends Stage {

    private static modele.Personne lapersonne;
    private static modele.Personne personneTampon;

    private controleur.FactureControllerClass ctrl;

    public FactureFen(modele.Personne personne) throws IOException {

        lapersonne = personne;

        this.setTitle("Organizatore di Dance");
        this.setResizable(true);

        Scene laScene = new Scene(creerSceneGraph());
        this.setScene(laScene);
    }

    private Pane creerSceneGraph() throws IOException {

        File fichier = new File("src/vue/full_facture.fxml");
        FXMLLoader loader;
        loader = new FXMLLoader(fichier.toURI().toURL());
        Pane racine = loader.load();
        ctrl = loader.getController();

        personneTampon = lapersonne;
        ctrl.initialize(lapersonne);
        return racine;
    }

    public static Personne backUp() {
        return lapersonne = personneTampon;

    }
}
