package br.com.alura.jdbc.testes;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.alura.jdbc.factory.ConnectionFactory;

public class TestaInsercaoComParametro {

	public static void main(String[] args) throws IOException, SQLException {
		String sql = "INSERT INTO produto (nome, descricao) VALUES (?, ?)";

		try (Connection conexao = ConnectionFactory.getInstancia().recuparaConexao()) {
			conexao.setAutoCommit(false);
			
			try (PreparedStatement stm = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
				adicionarVariavel("SmartTV", "45 Pol", stm);
				adicionarVariavel("Radio", "Radio de bateria", stm);
				conexao.commit();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Rollback executado");
				conexao.rollback();
			}
		}

	}

	private static void adicionarVariavel(String nome, String descricao, PreparedStatement stm) throws SQLException {
		if (nome.equals("Radio")) {
			throw new SQLException("Produto não pode ser cadastrado");
		}

		stm.setString(1, nome);
		stm.setString(2, descricao);
		stm.execute();

		try (ResultSet rst = stm.getGeneratedKeys()) {
			while (rst.next()) {
				Integer id = rst.getInt(1);
				System.out.println("O id criado foi " + id);
			}
		}
	}
}
