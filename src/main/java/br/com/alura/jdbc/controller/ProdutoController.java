package br.com.alura.jdbc.controller;

import java.sql.Connection;
import java.util.List;

import br.com.alura.jdbc.dao.ProdutoDAO;
import br.com.alura.jdbc.factory.ConnectionFactory;
import br.com.alura.jdbc.modelo.Produto;

public class ProdutoController {
	
	private ProdutoDAO produtoDao;

	public ProdutoController() {
		Connection connection = ConnectionFactory.getInstancia().recuparaConexao();
		this.produtoDao = new ProdutoDAO(connection);
	}

	public void deletar(Integer id) {
		produtoDao.deletar(id);
	}

	public void salvar(Produto produto) {
		produtoDao.salvarComCategoria(produto);		
	}

	public List<Produto> listar() {
		return produtoDao.listar();
	}

	public void alterar(String nome, String descricao, Integer id) {
		produtoDao.alterar(nome, descricao, id);
	}
}
