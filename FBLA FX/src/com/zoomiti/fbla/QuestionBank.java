package com.zoomiti.fbla;

import java.io.Serializable;
import java.util.ArrayList;

public class QuestionBank implements Serializable {

	private static final long serialVersionUID = -412640360961649501L;
	private final ArrayList<Question> questionsType0 = new ArrayList<>();
	private final ArrayList<Question> questionsType1 = new ArrayList<>();
	private final ArrayList<Question> questionsType2 = new ArrayList<>();
	private final ArrayList<Question> questionsType3 = new ArrayList<>();
	private final ArrayList<Question> questionsType4 = new ArrayList<>();

	public void add(int type, Question question) {
		switch (type) {
		case 0:
			questionsType0.add(question);
			break;
		case 1:
			questionsType1.add(question);
			break;
		case 2:
			questionsType2.add(question);
			break;
		case 3:
			questionsType3.add(question);
			break;
		case 4:
			questionsType4.add(question);
			break;
		default:
			throw new IllegalArgumentException("Type does not fall into range of 0-4");
		}
	}

	public Question get(int type, int index) {
		switch (type) {
		case 0:
			return questionsType0.get(index);
		case 1:
			return questionsType1.get(index);
		case 2:
			return questionsType2.get(index);
		case 3:
			return questionsType3.get(index);
		case 4:
			return questionsType4.get(index);
		default:
			throw new IllegalArgumentException("Type does not fall into range of 0-4");
		}
	}
	
	public Question getRandom() {
		return this.getRandom((int)(Math.random() *4));
	}
	
	public Question getRandom(int type) {
		return this.getRandom(type, 1, 1);
	}
	public Question getRandom(int type, int difficulty) {
		return this.getRandom(type, difficulty, 5);
	}
	public Question getRandom(int type, int difficulty, int numDifficulties) {
		if (difficulty > numDifficulties) {
			throw new IllegalArgumentException("Difficulty is higher than highest difficulty");
		}
		if (difficulty <= 0 || numDifficulties <= 0) {
			throw new IllegalArgumentException("Difficulties have to be a positive whole number");
		}
		ArrayList<Question> questions = null;
		
		switch (type) {
		case 0:
			questions = questionsType0;
			break;
		case 1:
			questions = questionsType1;
			break;
		case 2:
			questions = questionsType2;
			break;
		case 3:
			questions = questionsType3;
			break;
		case 4:
			questions = questionsType4;
			break;
		default:
			throw new IllegalArgumentException("Type does not fall into range of 0-4");
		}
		
		while (true) {
			Question question = questions.get((int)(Math.random()*questions.size()));
			if (question.getDifficulty() <= getAverageDifficulty(type)/numDifficulties *difficulty
					&& question.getDifficulty() >= getAverageDifficulty(type)/numDifficulties * (difficulty - 1)) {
				return question;
			}
			
		}
	}

	public double getAverageDifficulty(int type) {
		double sum = 0;
		switch (type) {
		case 0:
			for (Question question : questionsType0)
				sum += question.getDifficulty();
			return sum / questionsType0.size();
		case 1:
			for (Question question : questionsType1)
				sum += question.getDifficulty();
			return sum / questionsType0.size();
		case 2:
			for (Question question : questionsType2)
				sum += question.getDifficulty();
			return sum / questionsType0.size();
		case 3:
			for (Question question : questionsType3)
				sum += question.getDifficulty();
			return sum / questionsType0.size();
		case 4:
			for (Question question : questionsType0)
				sum += question.getDifficulty();
			return sum / questionsType0.size();
		default:
			throw new IllegalArgumentException("Type does not fall into range of 0-4");
		}
	}

	@Override
	public boolean equals(Object obj) {
		return obj instanceof QuestionBank 
				&& (((QuestionBank) obj).questionsType0.equals(this.questionsType0)
				&& ((QuestionBank) obj).questionsType1.equals(this.questionsType1)
				&& ((QuestionBank) obj).questionsType2.equals(this.questionsType2)
				&& ((QuestionBank) obj).questionsType3.equals(this.questionsType3)
				&& ((QuestionBank) obj).questionsType4.equals(this.questionsType4));
	}

	@Override
	public String toString() {
		return "[" + questionsType0 + ", " + questionsType1 + ", " + questionsType2 + ", " + questionsType3 + ", "
				+ questionsType4 + "]";
	}

	

}
