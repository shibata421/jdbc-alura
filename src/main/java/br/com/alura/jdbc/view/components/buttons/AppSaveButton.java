package br.com.alura.jdbc.view.components.buttons;

import javax.swing.JOptionPane;

import br.com.alura.jdbc.view.ProdutoCategoriaFrame;
import br.com.alura.jdbc.view.components.table.AppTable;

public class AppSaveButton extends AppButton {

	private static final long serialVersionUID = 1L;
	private ProdutoCategoriaFrame mediator;
	private AppTable tabela;

	public AppSaveButton(String nome, int x, int y, ProdutoCategoriaFrame frame, AppTable tabela) {
		super(nome, x, y);
		this.mediator = frame;
		this.tabela = tabela;
		this.addActionListener(e -> {
			salvar();
			limparTabela();
			preencherTabela();
		});
	}

	private void salvar() {
		String nome = mediator.getTextoNome();
		String descricao = mediator.getTextoDescricao();

		if (!nome.equals("") && !descricao.equals("")) {
			mediator.salvar();
			JOptionPane.showMessageDialog(this, "Salvo com sucesso!");
			limpar();
		} else {
			JOptionPane.showMessageDialog(this, "Nome e Descrição devem ser informados.");
		}
	}

	private void limpar() {
		mediator.limparCampos();
	}

	private void limparTabela() {
		tabela.limparTabela();
	}

	private void preencherTabela() {
		tabela.preencherTabela();
	}
}
