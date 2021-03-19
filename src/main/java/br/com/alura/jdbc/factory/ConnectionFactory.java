package br.com.alura.jdbc.factory;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {

	private DataSource dataSource;
	private static final ConnectionFactory instancia = new ConnectionFactory();

	private ConnectionFactory() {
		Properties prop = new Properties();
		try {
			prop.load(getClass().getClassLoader().getResourceAsStream("conexao.properties"));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		String url = prop.getProperty("database.url");
		String user = prop.getProperty("database.user");
		String pwd = prop.getProperty("database.password");

		ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
		comboPooledDataSource.setJdbcUrl(url);
		comboPooledDataSource.setUser(user);
		comboPooledDataSource.setPassword(pwd);
		comboPooledDataSource.setMaxPoolSize(15);

		dataSource = comboPooledDataSource;
	}
	
	public static ConnectionFactory getInstancia() {
		return instancia;
	}

	public Connection recuparaConexao() {
		try {
			return dataSource.getConnection();			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
