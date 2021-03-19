package br.com.alura.jdbc.view;

import java.awt.Container;
import java.util.Collections;
import java.util.List;

import javax.swing.JFrame;

import br.com.alura.jdbc.modelo.Categoria;
import br.com.alura.jdbc.modelo.Produto;
import br.com.alura.jdbc.view.components.buttons.AppButton;
import br.com.alura.jdbc.view.components.buttons.AppCleanButton;
import br.com.alura.jdbc.view.components.buttons.AppEditButton;
import br.com.alura.jdbc.view.components.buttons.AppEraseButton;
import br.com.alura.jdbc.view.components.buttons.AppSaveButton;
import br.com.alura.jdbc.view.components.combobox.AppComboBox;
import br.com.alura.jdbc.view.components.label.AppLabel;
import br.com.alura.jdbc.view.components.table.AppTable;
import br.com.alura.jdbc.view.components.textfield.AppTextField;

public class ProdutoCategoriaFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	private AppTextField textoNome, textoDescricao;
	private AppComboBox comboCategoria;
	private ViewController controller;

	public ProdutoCategoriaFrame(ViewController controller) {
		super("Produtos");
		this.controller = controller;
		Container container = getContentPane();

		AppLabel labelNome = new AppLabel("Nome do Produto", 10);
		AppLabel labelDescricao = new AppLabel("Descrição do Produto", 50);
		AppLabel labelCategoria = new AppLabel("Categoria do Produto", 90);

		textoNome = new AppTextField(25);
		textoDescricao = new AppTextField(65);

		comboCategoria = new AppComboBox(listarCategorias());

		AppTable tabela = new AppTable(this);
		
		AppButton botaoSalvar = new AppSaveButton("Salvar", 10, 145, this, tabela);
		AppButton botaoLimpar = new AppCleanButton("Limpar", 100, 145, this);
		AppButton botaoApagar = new AppEraseButton("Excluir", 10, 500, tabela);
		AppButton botaoEditar = new AppEditButton("Alterar", 100, 500, tabela);

		List.of(labelNome, labelDescricao, labelCategoria, textoNome, textoDescricao, comboCategoria, botaoSalvar,
				botaoLimpar, tabela, botaoApagar, botaoEditar)
			.forEach(e -> container.add(e));

		setLayout(null);
		setSize(800, 600);
		setVisible(true);
		setLocationRelativeTo(null);
	}

	private List<Categoria> listarCategorias() {
		return Collections.unmodifiableList(controller.listarCategorias());
	}

	public void limparCampos() {
		textoNome.setText("");
		textoDescricao.setText("");
		comboCategoria.setSelectedIndex(0);
	}

	public String getTextoNome() {
		return textoNome.getText();
	}

	public String getTextoDescricao() {
		return textoDescricao.getText();
	}

	Categoria getSelectedItem() {
		return comboCategoria.getSelectedItem();
	}

	public void salvar() {
		controller.salvar();
	}

	public List<Produto> listarProdutos() {
		return Collections.unmodifiableList(controller.listarProdutos());
	}

	public void alterarProduto(String nome, String descricao, Integer id) {
		controller.alterarProduto(nome, descricao, id);
	}

	public void deletarProduto(Integer id) {
		controller.deletarProduto(id);
	}
}
