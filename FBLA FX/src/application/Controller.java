package application;

import javafx.fxml.FXML;
import javafx.stage.Stage;

public class Controller {

	public static Stage stage;
	
	@FXML
	private void setCredits() {
		Scenes.Credits.switchScene();
	}
	
	@FXML
	private void setTitleScreen() {
		Scenes.Title.switchScene();
	}
	
}
