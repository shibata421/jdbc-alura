package br.com.alura.jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercao {

	public static void main(String[] args) throws IOException, SQLException {

		String sql = "INSERT INTO produto (nome, descricao) VALUES ('Mouse', 'Mouse sem fio')";
		try (Connection conexao = new ConnectionFactory().recuparaConexao();
				PreparedStatement stm = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {
			stm.execute();

			try (ResultSet rst = stm.getGeneratedKeys()) {
				while (rst.next()) {
					Integer id = rst.getInt(1);
					System.out.println("O id criado foi " + id);
				}
			}

		}
	}
}
