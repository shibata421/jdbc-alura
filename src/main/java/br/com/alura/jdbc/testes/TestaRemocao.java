package br.com.alura.jdbc.testes;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.alura.jdbc.factory.ConnectionFactory;

public class TestaRemocao {

	public static void main(String[] args) throws IOException, SQLException {
		
		String sql = "DELETE FROM produto WHERE id > ?";
		try(Connection conexao = ConnectionFactory.getInstancia().recuparaConexao();
			PreparedStatement stm = conexao.prepareStatement(sql);)
		{
			stm.setInt(1, 2);
			stm.execute();
			
			int modifiedLines = stm.getUpdateCount();
			System.out.println("Quantidade de linhas modificadas: " + modifiedLines);
		}		
	}
}
