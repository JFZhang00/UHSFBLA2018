package com.zoomit.fbla;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class QuestionGame implements Serializable {

	private static final long serialVersionUID = -1835376843483532245L;
	public final Score[] HIGH_SCORES = { new Score("Luis", 300), new Score("Jason", 200), new Score("Nick", 100), null,
			null, null, null, null, null, null };

	private class Score {
		@SuppressWarnings("unused")
		public final String name;
		@SuppressWarnings("unused")
		public final int score;

		public Score(String name, int score) {
			this.name = name;
			this.score = score;
		}
	}

	@SuppressWarnings("unchecked")
	private final ArrayList<Question>[] questionBank = new ArrayList[5];

	public QuestionGame() {
		for (int i = 0; i < questionBank.length; i++) {
			questionBank[i] = new ArrayList<>();
		}

		try (Scanner questionReader = new Scanner(getClass().getResourceAsStream("QuestionBank.txt"))) {
			while (questionReader.hasNextLine()) {
				String currentLine = getNextUncommentedLine(questionReader);
				if (isInteger(currentLine, 10)) {
					int type = Integer.parseInt(currentLine) - 1;
					String question = getNextUncommentedLine(questionReader);
					String rightAnswer = getNextUncommentedLine(questionReader);
					String wrongAnswer1 = getNextUncommentedLine(questionReader);
					String wrongAnswer2 = getNextUncommentedLine(questionReader);
					String wrongAnswer3 = getNextUncommentedLine(questionReader);
					if (!(isInteger(question, 10) || isInteger(rightAnswer, 10) || isInteger(wrongAnswer1, 10)
							|| isInteger(wrongAnswer2, 10) || isInteger(wrongAnswer3, 10))
							&& !(question.isEmpty() || rightAnswer.isEmpty() || wrongAnswer1.isEmpty()
									|| wrongAnswer2.isEmpty() || wrongAnswer3.isEmpty())) {
						questionBank[type]
								.add(new Question(question, rightAnswer, wrongAnswer1, wrongAnswer2, wrongAnswer3));
					} else {
						System.err.println("Question in wrong format this may also have messed up the next question");
					}
				}
			}

		}
		System.out.println(Arrays.deepToString(questionBank));
	}

	private static String getNextUncommentedLine(Scanner scanner) {
		String str = "";
		do {
			if (!scanner.hasNextLine())
				return "";
			str = scanner.nextLine();
		} while (str.startsWith("//"));
		return str.substring(0, str.contains("//") ? str.indexOf("//") : str.length()).trim();
	}

	private static boolean isInteger(String s, int radix) {
		if (s.isEmpty())
			return false;
		for (int i = 0; i < s.length(); i++) {
			if (i == 0 && s.charAt(i) == '-') {
				if (s.length() == 1)
					return false;
				else
					continue;
			}
			if (Character.digit(s.charAt(i), radix) < 0)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		new QuestionGame();
	}

}
