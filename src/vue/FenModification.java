package vue;

import java.io.File;
import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class FenModification extends Stage {

    private controleur.CtrlModification ctrl;

    public FenModification() throws IOException {

        this.setTitle("Organizatore di Dance");
        this.setResizable(false);
        Scene laScene = new Scene(creerSceneGraph());
        this.setScene(laScene);
    }

    private Pane creerSceneGraph() throws IOException {

        File fichier = new File("./src/vue/page_modification_cot_ann.fxml");
        FXMLLoader loader;
        loader = new FXMLLoader(fichier.toURI().toURL());
        Pane racine = loader.load();

        ctrl = loader.getController();

        return racine;
    }

    public controleur.CtrlModification getCtrl() {
        return ctrl;
    }
}
