package br.com.alura.jdbc.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.alura.jdbc.modelo.Produto;

public class ProdutoDAO {

	private Connection connection;

	public ProdutoDAO(Connection connection) {
		this.connection = connection;
	}

	public void salvar(Produto produto) throws SQLException, IOException {
		String sql = "INSERT INTO produto (nome, descricao) VALUES (?, ?)";

		try (PreparedStatement stm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			stm.setString(1, produto.getNome());
			stm.setString(2, produto.getDescricao());

			stm.execute();

			try (ResultSet rs = stm.getGeneratedKeys()) {
				while (rs.next()) {
					produto.setId(rs.getInt(1));
				}
			}
		}

	}

	public List<Produto> listar() throws SQLException {
		String sql = "SELECT * FROM produto";

		List<Produto> produtos = new ArrayList<>();
		try (Statement stm = connection.createStatement(); 
			 ResultSet resultSet = stm.executeQuery(sql);) 
		{
			while (resultSet.next()) {
				Integer id = resultSet.getInt("id");
				String nome = resultSet.getString("nome");
				String descricao = resultSet.getString("descricao");
				produtos.add(new Produto(id, nome, descricao));
			}
		}

		return Collections.unmodifiableList(produtos);
	}
}
