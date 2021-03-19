package br.com.alura.jdbc.view.components.buttons;

import br.com.alura.jdbc.view.components.table.AppTable;

public class AppEditButton extends AppButton {

	private static final long serialVersionUID = 1L;
	private AppTable tabela;

	public AppEditButton(String nome, int x, int y, AppTable tabela) {
		super(nome, x, y);
		this.tabela = tabela;
		this.addActionListener(e -> {
			alterar();
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

	private void alterar() {
		tabela.alterar();
	}
}
