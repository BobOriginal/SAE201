package vue;

import java.io.File;
import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class FenArchiver extends Stage {

    public FenArchiver() throws IOException {

        this.setTitle("Organizatore di Dance");
        this.setResizable(true);

        Scene laScene = new Scene(creerSceneGraph());
        this.setScene(laScene);
        this.close();

    }

    private Pane creerSceneGraph() throws IOException {
        File fichier;

        fichier = new File("src/vue/page_archiver.fxml");

        FXMLLoader loader;
        loader = new FXMLLoader(fichier.toURI().toURL());
        Pane racine = loader.load();

        return racine;
    }
}
