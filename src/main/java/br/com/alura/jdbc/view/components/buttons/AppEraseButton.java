package br.com.alura.jdbc.view.components.buttons;

import br.com.alura.jdbc.view.components.table.AppTable;

public class AppEraseButton extends AppButton {

	private static final long serialVersionUID = 1L;
	private AppTable tabela;

	public AppEraseButton(String nome, int x, int y, AppTable tabela) {
		super(nome, x, y);
		this.tabela = tabela;
		this.addActionListener(e -> {
			deletar();
			limparTabela();
			preencherTabela();
		});
	}

	private void preencherTabela() {
		tabela.preencherTabela();
	}

	private void limparTabela() {
		tabela.limparTabela();
	}

	private void deletar() {
		tabela.deletar();
	}

}
