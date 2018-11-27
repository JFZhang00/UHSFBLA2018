package com.zoomit.fbla;

import java.io.Serializable;

public class Question implements Serializable {

	private static final long serialVersionUID = -2166565667500993330L;
	public final String question;
	public final String[] answers;
	
	public Question(String question, String... answers) {
		this.question = question;
		if (answers.length != 4)
			throw new IllegalArgumentException("There must be 4 answers");
		this.answers = answers;
	}
	
	@Override
	public String toString() {
		return "{Q:" + question + ", A:" + answers[0] + ", B:" + answers[1] + ", C:" + answers[2] + ", D:" + answers[3] + "}";
	}
}
