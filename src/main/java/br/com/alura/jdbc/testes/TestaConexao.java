package br.com.alura.jdbc.testes;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import br.com.alura.jdbc.factory.ConnectionFactory;

public class TestaConexao {

	public static void main(String[] args) throws IOException, SQLException  {

		Connection connection = ConnectionFactory.getInstancia().recuparaConexao();

		System.out.println("Fechando conexão");
		connection.close();

	}
}
