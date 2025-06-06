package vue;

import java.io.File;
import java.io.IOException;

import Exceptions.StatusException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import modele.Cours;
import modele.Personne;

public class PagePrincipaleFen extends Stage{

    public PagePrincipaleFen() throws IOException {

        this.setTitle("Organizatore di Dance");
        this.setResizable(true);
        Scene laScene = new Scene(creerSceneGraph());
        this.setScene(laScene);
    }

    private Pane creerSceneGraph() throws IOException {

        File fichier = new File("src/vue/page_principale.fxml");
        FXMLLoader loader;
        loader = new FXMLLoader(fichier.toURI().toURL());
        Pane racine = loader.load();

        return racine;
    }
}
