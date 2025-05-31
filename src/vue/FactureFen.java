package vue;

import java.io.File;
import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public class FactureFen extends Fenetre {

    public FactureFen() throws IOException {
        this.setTitle("Liste des employés");
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

        ctrl.setEleve(null);
        return racine;
    }

}
