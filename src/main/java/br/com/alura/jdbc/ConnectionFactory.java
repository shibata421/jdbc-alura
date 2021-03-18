package br.com.alura.jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {

	private DataSource dataSource;

	public ConnectionFactory() throws IOException {
		Properties prop = new Properties();
		prop.load(getClass().getClassLoader().getResourceAsStream("conexao.properties"));
		String url = prop.getProperty("database.url");
		String user = prop.getProperty("database.user");
		String pwd = prop.getProperty("database.password");

		ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
		comboPooledDataSource.setJdbcUrl(url);
		comboPooledDataSource.setUser(user);
		comboPooledDataSource.setPassword(pwd);

		this.dataSource = comboPooledDataSource;
	}

	public Connection recuparaConexao() throws SQLException {
		return this.dataSource.getConnection();
	}
}
