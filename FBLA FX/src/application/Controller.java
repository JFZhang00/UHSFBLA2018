package application;

import com.zoomiti.fbla.Question;
import com.zoomiti.fbla.QuestionGame;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Controller {

	public final static Controller controllerMain = new Controller();
	public static Stage stage;

	/*
	 * Game Screen Buttons / Labels
	 */
	@FXML
	private Label Score;
	@FXML
	private Label Multiplier;
	@FXML
	private Label Question;
	@FXML
	private Button AnswerA;
	@FXML
	private Button AnswerB;
	@FXML
	private Button AnswerC;
	@FXML
	private Button AnswerD;

	@FXML
	private Label FinalScore;

	private int score;
	private int questionNumber;
	private int multiplier;
	private QuestionGame questionGame;
	private boolean initialized = false;
	
	private EventHandler<Event> rightAnswer = event -> {
		questionNumber++;
		score += 10 * multiplier;
		multiplier += 1;
		updateSore();
		if (questionNumber <= 10) {
			newQuestion(questionGame.questionBank.getRandom());
		} else {
			FinalScore.setText(score + " points!");
			Scenes.End.switchScene();
		}
	};
	private EventHandler<Event> wrongAnswer = event -> {
		multiplier = 1;
		score -= 5;
		updateSore();
	};

	@FXML
	private void playButton() {
		questionNumber = 1;
		score = 0;
		multiplier = 1;
		questionGame = new QuestionGame();
		newQuestion(questionGame.questionBank.getRandom());

		if (!initialized)
			setUpWrapping();

	}

	private void setUpWrapping() {
		Question.setWrapText(true);
		AnswerA.setWrapText(true);
		AnswerB.setWrapText(true);
		AnswerC.setWrapText(true);
		AnswerD.setWrapText(true);
		initialized = true;
	}

	@FXML
	private void setInstructions() {
		Scenes.Instructions.switchScene();
	}

	@FXML
	private void setTitleScreen() {
		Scenes.Title.switchScene();
	}

	private void updateSore() {
		Score.setText(score + "");
		Multiplier.setText(multiplier + "x");
	}

	private void newQuestion(Question question) {
		updateSore();
		Question.setText(questionNumber + ") " + question.question);
		switch ((int) (Math.random() * 4)) {
		case 0:
			AnswerA.setText(question.answers[0]);
			AnswerB.setText(question.answers[1]);
			AnswerC.setText(question.answers[2]);
			AnswerD.setText(question.answers[3]);
			AnswerA.setOnMouseClicked(rightAnswer);
			AnswerB.setOnMouseClicked(wrongAnswer);
			AnswerC.setOnMouseClicked(wrongAnswer);
			AnswerD.setOnMouseClicked(wrongAnswer);
			break;
		case 1:
			AnswerA.setText(question.answers[1]);
			AnswerB.setText(question.answers[0]);
			AnswerC.setText(question.answers[2]);
			AnswerD.setText(question.answers[3]);
			AnswerA.setOnMouseClicked(wrongAnswer);
			AnswerB.setOnMouseClicked(rightAnswer);
			AnswerC.setOnMouseClicked(wrongAnswer);
			AnswerD.setOnMouseClicked(wrongAnswer);
			break;
		case 2:
			AnswerA.setText(question.answers[2]);
			AnswerB.setText(question.answers[1]);
			AnswerC.setText(question.answers[0]);
			AnswerD.setText(question.answers[3]);
			AnswerA.setOnMouseClicked(wrongAnswer);
			AnswerB.setOnMouseClicked(wrongAnswer);
			AnswerC.setOnMouseClicked(rightAnswer);
			AnswerD.setOnMouseClicked(wrongAnswer);
			break;
		case 3:
			Question.setText(question.question);
			AnswerA.setText(question.answers[3]);
			AnswerB.setText(question.answers[1]);
			AnswerC.setText(question.answers[2]);
			AnswerD.setText(question.answers[0]);
			AnswerA.setOnMouseClicked(wrongAnswer);
			AnswerB.setOnMouseClicked(wrongAnswer);
			AnswerC.setOnMouseClicked(wrongAnswer);
			AnswerD.setOnMouseClicked(rightAnswer);
			break;
		}
		Scenes.Game.switchScene();

	}

}