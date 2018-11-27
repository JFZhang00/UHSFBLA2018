package application;

import javafx.fxml.FXML;

public class Controller {

	@FXML
	private void setCredits() {
		SceneSwitcher.setCredits();
	}
	
	@FXML
	private void setTitleScreen() {
		SceneSwitcher.setTitleScreen();
	}
}
