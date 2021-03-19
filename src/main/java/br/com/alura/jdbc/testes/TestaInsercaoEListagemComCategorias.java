package br.com.alura.jdbc.testes;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.alura.jdbc.dao.CategoriaDAO;
import br.com.alura.jdbc.factory.ConnectionFactory;
import br.com.alura.jdbc.modelo.Categoria;
import br.com.alura.jdbc.modelo.Produto;

public class TestaInsercaoEListagemComCategorias {

	public static void main(String[] args) throws SQLException, IOException, URISyntaxException {
		try (Connection connection = ConnectionFactory.getInstancia().recuparaConexao();) {
			CategoriaDAO categoriaDao = new CategoriaDAO(connection);
			List<Categoria> categorias = categoriaDao.listarComProdutos();
			for(Categoria c : categorias){
				System.out.println(c.getNome());
				
				List<Produto> produtos = c.getProdutos();
				for(Produto produto : produtos) {
					System.out.println("	" + produto.getNome());
				}
			}
		}
	}
}
