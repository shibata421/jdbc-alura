package br.com.alura.jdbc;

import java.io.IOException;
import java.sql.SQLException;

public class TestaPoolConexoes {

	public static void main(String[] args) throws SQLException, IOException {
		
		ConnectionFactory fabrica = new ConnectionFactory();
		
		for(int i = 0; i < 20; i++) {
			fabrica.recuparaConexao();
			System.out.println(i + 1);
		}
	}
}
