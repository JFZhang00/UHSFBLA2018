package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Controller {

	public static Stage stage;
	
	@FXML
	private Button Play;
	
	@FXML
	private Button Instructions;
	
	
	@FXML
	private void setInstructions() {
		Scenes.Instructions.switchScene();
	}
	
	@FXML
	private void setTitleScreen() {
		Scenes.Title.switchScene();		
	}
	
}
