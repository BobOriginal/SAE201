package vue;

import java.io.File;
import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class FenFacture extends Stage {

    private static modele.Personne lapersonne;

    private controleur.CtrlFacture ctrl;

    public FenFacture() throws IOException {

        lapersonne = modele.Donnee.getUnePersonne(0);

        this.setTitle("Organizatore di Dance");
        this.setResizable(false);

        Scene laScene = new Scene(creerSceneGraph());
        this.setScene(laScene);
        this.close();
    }

    private Pane creerSceneGraph() throws IOException {
        File fichier;

        fichier = new File("src/vue/page_facture_2.fxml");

        FXMLLoader loader;
        loader = new FXMLLoader(fichier.toURI().toURL());
        Pane racine = loader.load();
        ctrl = loader.getController();
        ctrl.initialize(lapersonne);

        return racine;
    }

}
