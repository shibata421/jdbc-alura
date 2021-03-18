package br.com.alura.jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.alura.jdbc.dao.ProdutoDAO;
import br.com.alura.jdbc.modelo.Produto;

public class TestaInsercaoComProduto {

	public static void main(String[] args) throws SQLException, IOException {
		Produto comoda = new Produto("Cômoda", "Cômoda vertical");
		
		try(Connection connection = new ConnectionFactory().recuparaConexao()) {
			ProdutoDAO produtoDao = new ProdutoDAO(connection);
			produtoDao.salvar(comoda);
			List<Produto> produtos = produtoDao.listar();
			produtos.forEach(System.out::println);
		}		
	}
}
