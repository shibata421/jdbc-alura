package br.com.alura.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.alura.jdbc.modelo.Categoria;
import br.com.alura.jdbc.modelo.Produto;

public class ProdutoDAO {

	private Connection connection;

	public ProdutoDAO(Connection connection) {
		this.connection = connection;
	}

	public void salvar(Produto produto) {
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
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void salvarComCategoria(Produto produto) {
		String sql = "INSERT INTO produto (nome, descricao, categoria_id) VALUES (?, ?, ?)";

		try (PreparedStatement stm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			stm.setString(1, produto.getNome());
			stm.setString(2, produto.getDescricao());
			stm.setInt(3, produto.getCategoriaId());
			
			stm.execute();
			try (ResultSet rs = stm.getGeneratedKeys()) {
				while (rs.next()) {
					produto.setId(rs.getInt(1));
				}
			}
		}  catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Produto> listar() {
		String sql = "SELECT * FROM produto";

		try (PreparedStatement stm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			stm.execute();
			return transformarResultSetEmProduto(stm);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Produto> buscar(Categoria categoria) {
		String sql = "SELECT id, nome, descricao FROM produto WHERE categoria_id = ?";

		try (PreparedStatement stm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			stm.setInt(1, categoria.getId());
			stm.execute();
			return transformarResultSetEmProduto(stm);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void deletar(Integer id) {
		String sql = "DELETE FROM produto WHERE id = ?";
		try (PreparedStatement stm = connection.prepareStatement(sql)) {
			stm.setInt(1, id);
			stm.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void alterar(String nome, String descricao, Integer id) {
		String sql = "UPDATE produto SET nome = ?, descricao = ? WHERE id = ?";
		try (PreparedStatement stm = connection.prepareStatement(sql)) {
			stm.setString(1, nome);
			stm.setString(2, descricao);
			stm.setInt(3, id);
			stm.execute();
		}  catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	private List<Produto> transformarResultSetEmProduto(PreparedStatement stm) {
		try (ResultSet resultSet = stm.getResultSet()) {
			List<Produto> produtos = new ArrayList<>();

			while (resultSet.next()) {
				Integer id = resultSet.getInt("id");
				String nome = resultSet.getString("nome");
				String descricao = resultSet.getString("descricao");
				produtos.add(new Produto(id, nome, descricao));
			}
			
			return Collections.unmodifiableList(produtos);
		}  catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
