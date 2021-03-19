package br.com.alura.jdbc.testes;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.alura.jdbc.factory.ConnectionFactory;

public class TestaListagem {

	public static void main(String[] args) throws IOException, SQLException {

		String sql = "SELECT id, nome, descricao FROM produto";
		
		try (Connection connection = ConnectionFactory.getInstancia().recuparaConexao();
			 PreparedStatement stm = connection.prepareStatement(sql);) 	
		{
			stm.execute();
			try(ResultSet rst = stm.getResultSet()) {
				while (rst.next()) {
					Integer id = rst.getInt("id");
					String nome = rst.getString("nome");
					String descricao = rst.getString("descricao");
					
					System.out.println(id);
					System.out.println(nome);
					System.out.println(descricao);
				}				
			}
		}
	}
}
