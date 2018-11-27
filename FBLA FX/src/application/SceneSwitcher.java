package application;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneSwitcher {
	
	public static Stage stage;
	
	public static void setTitleScreen() {
		try {
			Parent root = FXMLLoader.load(SceneSwitcher.class.getResource("Title Screen.fxml"));
			Scene scene = new Scene(root, 400, 300);
			scene.getStylesheets().add(SceneSwitcher.class.getResource("application.css").toExternalForm());
			stage.setScene(scene);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void setCredits() {
		try {
			Parent root = FXMLLoader.load(SceneSwitcher.class.getResource("Credits Screen.fxml"));
			Scene scene = new Scene(root, 400, 300);
			scene.getStylesheets().add(SceneSwitcher.class.getResource("application.css").toExternalForm());
			stage.setScene(scene);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
