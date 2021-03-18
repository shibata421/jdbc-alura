package br.com.alura.jdbc;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestaRemocao {

	public static void main(String[] args) throws IOException, SQLException {
		
		String sql = "DELETE FROM produto WHERE id > ?";
		try(Connection conexao = new ConnectionFactory().recuparaConexao();
			PreparedStatement stm = conexao.prepareStatement(sql);)
		{
			stm.setInt(1, 2);
			stm.execute();
			
			int modifiedLines = stm.getUpdateCount();
			System.out.println("Quantidade de linhas modificadas: " + modifiedLines);
		}		
	}
}
