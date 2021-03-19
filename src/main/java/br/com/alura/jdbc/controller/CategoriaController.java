package br.com.alura.jdbc.controller;

import java.sql.Connection;
import java.util.List;

import br.com.alura.jdbc.dao.CategoriaDAO;
import br.com.alura.jdbc.factory.ConnectionFactory;
import br.com.alura.jdbc.modelo.Categoria;

public class CategoriaController {
	
	private CategoriaDAO categoridaDao;
	
	public CategoriaController() {
		Connection connection = ConnectionFactory.getInstancia().recuparaConexao();
		this.categoridaDao = new CategoriaDAO(connection);
	}

	public List<Categoria> listar() {
		return categoridaDao.listar();
	}
}
