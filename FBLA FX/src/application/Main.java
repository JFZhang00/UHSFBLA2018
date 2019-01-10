package application;

import com.zoomiti.fbla.QuestionGame;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {
		Controller.stage = primaryStage;
		Controller.questionGame = new QuestionGame();
		
		Scenes.Title.switchScene();
		Scenes.setUpHanders();
		
		primaryStage.show();
	}

	@Override
	public void stop() throws Exception {
		super.stop();
		Controller.controllerMain.stop();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
