package br.com.alura.jdbc.view.components.buttons;

import javax.swing.JButton;

public abstract class AppButton extends JButton {

	private static final long serialVersionUID = 1L;

	public AppButton(String nome, int x, int y) {
		super(nome);
		this.setBounds(x, y, 80, 20);
	}
}
