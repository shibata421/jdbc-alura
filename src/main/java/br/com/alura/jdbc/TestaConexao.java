package br.com.alura.jdbc;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class TestaConexao {

	public static void main(String[] args) throws IOException, SQLException  {

		Connection connection = new ConnectionFactory().recuparaConexao();

		System.out.println("Fechando conexão");
		connection.close();

	}
}
