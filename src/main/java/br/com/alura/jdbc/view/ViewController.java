package br.com.alura.jdbc.view;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import javax.swing.JFrame;

import br.com.alura.jdbc.controller.CategoriaController;
import br.com.alura.jdbc.controller.ProdutoController;
import br.com.alura.jdbc.modelo.Categoria;
import br.com.alura.jdbc.modelo.Produto;

public class ViewController {

	private ProdutoCategoriaFrame frame;
	private ProdutoController produtoController;
	private CategoriaController categoriaController;

	public ViewController() throws SQLException, IOException {
		this.produtoController = new ProdutoController();
		this.categoriaController = new CategoriaController();

		this.frame = new ProdutoCategoriaFrame(this);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void salvar() {
		Categoria categoria = frame.getSelectedItem();
		String nome = frame.getTextoNome();
		String descricao = frame.getTextoDescricao();
		Produto produto = new Produto(nome, descricao, categoria.getId());
		produtoController.salvar(produto);
	}

	public List<Categoria> listarCategorias() {
		return Collections.unmodifiableList(categoriaController.listar());
	}

	public List<Produto> listarProdutos() {
		return Collections.unmodifiableList(produtoController.listar());
	}

	public void deletarProduto(int id) {
		produtoController.deletar(id);
	}

	public void alterarProduto(String nome, String descricao, Integer id) {
		produtoController.alterar(nome, descricao, id);
	}
}
