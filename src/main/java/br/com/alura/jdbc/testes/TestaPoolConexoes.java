package br.com.alura.jdbc.testes;

import java.io.IOException;
import java.sql.SQLException;

import br.com.alura.jdbc.factory.ConnectionFactory;

public class TestaPoolConexoes {

	public static void main(String[] args) throws SQLException, IOException {
		
		ConnectionFactory fabrica = ConnectionFactory.getInstancia();
		
		for(int i = 0; i < 20; i++) {
			fabrica.recuparaConexao();
			System.out.println(i + 1);
		}
	}
}
