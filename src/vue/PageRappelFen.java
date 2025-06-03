package vue;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.io.File;
import java.io.IOException;

public class PageRappelFen extends Stage{
    private controleur.PagePrincpaleControllerClass ctrl;

    public PageRappelFen() throws IOException {

        this.setTitle("Organizatore di Dance");
        this.setResizable(true);
        Scene laScene = new Scene(creerSceneGraph());
        this.setScene(laScene);
    }

    private Pane creerSceneGraph() throws IOException {

        File fichier = new File("src/vue/page_rappel.fxml");
        FXMLLoader loader;
        loader = new FXMLLoader(fichier.toURI().toURL());
        Pane racine = loader.load();

        return racine;
    
    }
}
