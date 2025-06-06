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

    private controleur.FactureControllerClass ctrl;

    public FactureFen() throws IOException {

        this.setTitle("Organizatore di Dance");
        this.setResizable(true);

        Scene laScene = new Scene(creerSceneGraph());
        this.setScene(laScene);
        this.close();
    }

    private Pane creerSceneGraph() throws IOException {
        File fichier;
        fichier = new File("src/vue/full_facture.fxml");
        /*if (lapersonne.getEtatArchivage() == false) {
            
        } else {
            fichier = new File("src/vue/factureArchiver.fxml");
        }*/
        FXMLLoader loader;
        loader = new FXMLLoader(fichier.toURI().toURL());
        Pane racine = loader.load();
        ctrl = loader.getController();

        ctrl.initialize(lapersonne);

        return racine;
    }
    
    public void choisiPersonne(Personne p) {
    	lapersonne = p;
    }

}
