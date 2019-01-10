package application;

import com.zoomiti.fbla.Question;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Controller {

	private int score;
	private int questionNumber;
	private int multiplier;
	
	public static Stage stage;

	/*
	 * Game Screen Buttons / Labels
	 */
	@FXML
	private Label AScore;
	@FXML
	private Label AMultiplier;
	@FXML
	private Label AQuestionNumber;
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
	private Label BScore;
	@FXML
	private Label BMultiplier;
	@FXML
	private Label BQuestionNumber;
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
	private Label CScore;
	@FXML
	private Label CMultiplier;
	@FXML
	private Label CQuestionNumber;
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
	private Label DScore;
	@FXML
	private Label DMultiplier;
	@FXML
	private Label DQuestionNumber;
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
	private void playButton() {
		questionNumber = 1;
		score = 0;
		multiplier = 1;
	}

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
		questionNumber++;
		score += 10 * multiplier;
		multiplier += .25;
		if (questionNumber <= 10) {
			newQuestion(new Question("", "", "", "", ""));
		} else {
			
		}
	}

	@FXML
	private void wrongAnswer() {
		multiplier = 1;
		score -= 5;
	}

	private void newQuestion(Question question) {

		switch ((int) (Math.random() * 4)) {
		case 0:
			AScore.setText(score + "");
			AMultiplier.setText(multiplier + "x");
			AQuestionNumber.setText(questionNumber + "");
			AQuestion.setText(question.question);
			AAnswerA.setText(question.answers[0]);
			AAnswerB.setText(question.answers[1]);
			AAnswerC.setText(question.answers[2]);
			AAnswerD.setText(question.answers[3]);
			Scenes.GameA.switchScene();
			break;
		case 1:
			BScore.setText(score + "");
			BMultiplier.setText(multiplier + "x");
			BQuestionNumber.setText(questionNumber + "");
			BQuestion.setText(question.question);
			BAnswerA.setText(question.answers[1]);
			BAnswerB.setText(question.answers[0]);
			BAnswerC.setText(question.answers[2]);
			BAnswerD.setText(question.answers[3]);
			Scenes.GameB.switchScene();
			break;
		case 2:
			CScore.setText(score + "");
			CMultiplier.setText(multiplier + "x");
			CQuestionNumber.setText(questionNumber + "");
			CQuestion.setText(question.question);
			CAnswerA.setText(question.answers[2]);
			CAnswerB.setText(question.answers[1]);
			CAnswerC.setText(question.answers[0]);
			CAnswerD.setText(question.answers[3]);
			Scenes.GameC.switchScene();
			break;
		case 3:
			DScore.setText(score + "");
			DMultiplier.setText(multiplier + "x");
			DQuestionNumber.setText(questionNumber + "");
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