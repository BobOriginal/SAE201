package vue;

import java.io.File;
import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public class FactureFen extends Fenetre {

    public FactureFen() throws IOException {
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
        return racine;
    }

}
