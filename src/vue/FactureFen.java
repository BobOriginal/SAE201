package vue;

import java.io.File;
import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class FactureFen extends Stage {

    private static modele.Personne lapersonne;

    private controleur.FactureControllerClass ctrl;

    public FactureFen(modele.Personne personne) throws IOException {

        lapersonne = personne;

        this.setTitle("Organizatore di Dance");
        this.setResizable(true);

        Scene laScene = new Scene(creerSceneGraph());
        this.setScene(laScene);
        this.close();
    }

    private Pane creerSceneGraph() throws IOException {
        File fichier;

        if (lapersonne.getEtatArchivage() == false) {
            fichier = new File("src/vue/full_facture.fxml");
        } else {
            fichier = new File("src/vue/");
        }
        FXMLLoader loader;
        loader = new FXMLLoader(fichier.toURI().toURL());
        Pane racine = loader.load();
        ctrl = loader.getController();

        ctrl.initialize(lapersonne);

        return racine;
    }

}
