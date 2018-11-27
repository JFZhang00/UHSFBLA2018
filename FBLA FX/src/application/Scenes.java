package application;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public enum Scenes {
	Title(),
	Credits();

	private Scene scene;

	private Scenes() {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("../FXML/" + this + " Screen.fxml"));
			scene = new Scene(root, 400, 300);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		} catch (IOException e) {
			System.err.println("Wrong file name idiot!");
		}
	}
	
	public void switchScene() {
		Controller.stage.setScene(scene);
	}

}
