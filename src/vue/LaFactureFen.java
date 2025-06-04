package vue;

import java.io.File;
import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class LaFactureFen extends Stage {

    private controleur.LaFactureControllerClass ctrl;
    private static modele.Personne lapersonne;

    public LaFactureFen(modele.Personne personne) throws IOException {

        lapersonne = personne;

        System.out.println("Vous rentrer dans la facture" + lapersonne);
        this.setTitle("Facturation");
        this.setResizable(true);

        Scene laScene = new Scene(creerSceneGraph());
        this.setScene(laScene);
    }

    private Pane creerSceneGraph() throws IOException {

        File fichier = new File("src/vue/rendu_facture.fxml");
        FXMLLoader loader;
        loader = new FXMLLoader(fichier.toURI().toURL());
        Pane racine = loader.load();
        ctrl = loader.getController();

        ctrl.initialize(lapersonne);
        return racine;
    }

}
