package br.com.alura.jdbc.dao;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.alura.jdbc.modelo.Categoria;
import br.com.alura.jdbc.modelo.Produto;

public class CategoriaDAO {

	private Connection connection;

	public CategoriaDAO(Connection connection) {
		this.connection = connection;
	}

	public List<Categoria> listar() {
		String sql = "SELECT * FROM categoria";
		try (Statement stm = connection.createStatement(); 
			 ResultSet rs = stm.executeQuery(sql);) 
		{
			List<Categoria> categorias = new ArrayList<>();
			
			while (rs.next()) {
				Integer id = rs.getInt("id");
				String nome = rs.getString("nome");
				categorias.add(new Categoria(id, nome));
			}
			
			return Collections.unmodifiableList(categorias);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Categoria> listarComProdutos() throws IOException, URISyntaxException, SQLException {
		List<Categoria> categorias = new ArrayList<>();
		
		URI sqlUri = getClass().getClassLoader().getResource("categoriaJoinProduto.sql").toURI();
		String sql = Files.readString(Path.of(sqlUri));

		System.out.println(sql);
		try (Statement stm = connection.createStatement(); 
			 ResultSet rs = stm.executeQuery(sql);) 
		{
			while (rs.next()) {
				String produtoNome = rs.getString("nome");
				String produtoDescricao = rs.getString("descricao");
				Produto produto = new Produto(produtoNome, produtoDescricao);

				Integer categoriaId = rs.getInt("id");
				String categoriaNome = rs.getString("categoria");
				Categoria categoria = new Categoria(categoriaId, categoriaNome);

				categorias.stream().filter(cat -> cat.equals(categoria)).findAny()
						.ifPresentOrElse(cat -> cat.adicionar(produto), () -> {
							categorias.add(categoria);
							categoria.adicionar(produto);
						});

//				if(!categorias.contains(categoria)) {
//					categoria.adicionar(produto);
//					categorias.add(categoria);
//				} else {
//					int id = categorias.indexOf(categoria);
//					categorias.get(id).adicionar(produto);
//				}
			}

		}
		return Collections.unmodifiableList(categorias);
	}

}
