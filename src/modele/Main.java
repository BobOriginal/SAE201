package modele;

import javafx.application.Application;
import javafx.stage.Stage;
import vue.Fenetre;

public class Main extends Application {
	public void start(Stage f) throws Exception {
		f = new Fenetre();
		f.show();
	}

	public static void main(String args[]) {
		Application.launch();
	}
}
