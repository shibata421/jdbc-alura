package br.com.alura.jdbc.view.components.buttons;

import br.com.alura.jdbc.view.ProdutoCategoriaFrame;

public class AppCleanButton extends AppButton {

	private static final long serialVersionUID = 1L;
	private ProdutoCategoriaFrame frame;

	public AppCleanButton(String nome, int x, int y, ProdutoCategoriaFrame frame) {
		super(nome, x, y);
		this.frame = frame;
		this.addActionListener(e ->	limparCampos());
	}

	private void limparCampos() {
		frame.limparCampos();
	}

}
