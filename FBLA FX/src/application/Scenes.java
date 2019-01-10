package application;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public enum Scenes {
	Title(),
	Instructions(),
	Game(),
	End();

	private Scene scene;
	

	private Scenes() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../FXML/" + this + " Screen.fxml"));
			loader.setController(Controller.controllerMain);
			Parent root = loader.load();
			scene = new Scene(root, 800, 600);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		} catch (IOException e) {
			System.err.println("Wrong file name idiot!");
			System.out.println(e);
		}
	}
	
	public void switchScene() {
		Controller.stage.setScene(scene);
	}

}