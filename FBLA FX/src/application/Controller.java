package application;

import com.zoomiti.fbla.Question;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Controller {

	public static Stage stage;
	
	/*
	 * Game Screen Buttons / Labels
	 */
	@FXML
	private Label AQuestion;
	@FXML
	private Button AAnswerA;
	@FXML
	private Button AAnswerB;
	@FXML
	private Button AAnswerC;
	@FXML
	private Button AAnswerD;
	
	@FXML
	private Label BQuestion;
	@FXML
	private Button BAnswerA;
	@FXML
	private Button BAnswerB;
	@FXML
	private Button BAnswerC;
	@FXML
	private Button BAnswerD;
	
	@FXML
	private Label CQuestion;
	@FXML
	private Button CAnswerA;
	@FXML
	private Button CAnswerB;
	@FXML
	private Button CAnswerC;
	@FXML
	private Button CAnswerD;
	
	@FXML
	private Label DQuestion;
	@FXML
	private Button DAnswerA;
	@FXML
	private Button DAnswerB;
	@FXML
	private Button DAnswerC;
	@FXML
	private Button DAnswerD;
	
	@FXML
	private void setInstructions() {
		Scenes.Instructions.switchScene();
	}
	
	@FXML
	private void setTitleScreen() {
		Scenes.Title.switchScene();		
	}
	
	@FXML
	private void rightAnswer() {
		newQuestion(new Question("", "","","",""));
	}
	
	@FXML
	private void wrongAnswer() {
		
	}
	
	private void newQuestion(Question question) {
		
		switch ((int)(Math.random()*4)) {
			case 0:
				AQuestion.setText(question.question);
				AAnswerA.setText(question.answers[0]);
				AAnswerB.setText(question.answers[1]);
				AAnswerC.setText(question.answers[2]);
				AAnswerD.setText(question.answers[3]);
				Scenes.GameA.switchScene();
			break;
			case 1:
				BQuestion.setText(question.question);
				BAnswerA.setText(question.answers[1]);
				BAnswerB.setText(question.answers[0]);
				BAnswerC.setText(question.answers[2]);
				BAnswerD.setText(question.answers[3]);
				Scenes.GameB.switchScene();
			break;
			case 2:
				CQuestion.setText(question.question);
				CAnswerA.setText(question.answers[2]);
				CAnswerB.setText(question.answers[1]);
				CAnswerC.setText(question.answers[0]);
				CAnswerD.setText(question.answers[3]);
				Scenes.GameC.switchScene();
			break;
			case 3:
				DQuestion.setText(question.question);
				DAnswerA.setText(question.answers[3]);
				DAnswerB.setText(question.answers[1]);
				DAnswerC.setText(question.answers[2]);
				DAnswerD.setText(question.answers[0]);
				Scenes.GameD.switchScene();
			break;
		}
		
		
	}
	
}