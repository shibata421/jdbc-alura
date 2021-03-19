package br.com.alura.jdbc.view.components.label;

import java.awt.Color;

import javax.swing.JLabel;

public class AppLabel extends JLabel{

	private static final long serialVersionUID = 1L;

	public AppLabel(String nome, int y) {
		super(nome);
		this.setBounds(10, y, 240, 15);
		this.setForeground(Color.BLACK);
	}
}
