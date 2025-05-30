package modele;

import javafx.application.Application;
import javafx.stage.Stage;
import vue.FactureFen;

public class Main extends Application {
	public void start(Stage f) throws Exception {
		f = new FactureFen();
		f.show();
	}

	public static void main(String args[]) {
		Application.launch();
	}
}
