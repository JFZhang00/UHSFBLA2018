package com.zoomiti;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Main {

	public static final JFrame window = new JFrame("FBLA Game");
	public static Font font = new Font("Comic Sans MS", Font.PLAIN, 20);

	public static void main(String[] args) {
		final JPanel panel = new JPanel(new BorderLayout());
		
		final JLabel title = new JLabel("FBLA Game");
		title.setFont(font);
		title.addComponentListener(new FontResizer(title));
		title.setHorizontalAlignment(JLabel.CENTER);
		panel.add(title, BorderLayout.NORTH);

		final JButton button = new JButton("Play");
		button.setFont(font);
		button.addComponentListener(new FontResizer(button));
		panel.add(button, BorderLayout.CENTER);

		window.add(panel);
		window.setSize(800, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
	}

}
