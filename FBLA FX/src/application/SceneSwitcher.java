package application;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneSwitcher {
	
	public static final SceneSwitcher INSTANCE = new SceneSwitcher();
	
	public static Stage stage;
	
	public void setTitleScreen() {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("Title Screen.fxml"));
			Scene scene = new Scene(root, 400, 300);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setScene(scene);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
