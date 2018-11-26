package com.zoomiti;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JComponent;

public class FontResizer implements ComponentListener {

	private final JComponent component;

	public FontResizer(JComponent component) {
		this.component = component;
	}

	@Override
	public void componentHidden(ComponentEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void componentMoved(ComponentEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void componentResized(ComponentEvent e) {
		final int height = component.getHeight();
		final int width = component.getWidth();

		component.setFont(new Font("Comic Sans MS", Font.PLAIN, (width + height) / 25));

	}

	@Override
	public void componentShown(ComponentEvent e) {
		// TODO Auto-generated method stub

	}

}
