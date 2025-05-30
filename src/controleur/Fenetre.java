package controleur;

import java.io.File;
import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Fenetre extends Stage {

	public Fenetre() throws IOException {
		this.setWidth(900);
		this.setHeight(635);
		Scene sc = new Scene(creerSceneGraph());
		this.setScene(sc);

	}

	private Pane creerSceneGraph() throws IOException {
		File fichier = new File("sources/full_facture.fxml");
		FXMLLoader loader;
		loader = new FXMLLoader(fichier.toURI().toURL());
		Pane racine = loader.load();
		return racine;
	}

}
