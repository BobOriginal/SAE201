package modele;

import javafx.application.Application;
import javafx.stage.Stage;
import vue.PagePrincipaleFen;

public class Main extends Application {
	public void start(Stage f) throws Exception {
		f = new PagePrincipaleFen();
		f.show();
	}

	public static void main(String args[]) {
		Application.launch();
	}
}
