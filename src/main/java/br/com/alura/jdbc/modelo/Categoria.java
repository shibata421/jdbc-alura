package br.com.alura.jdbc.modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Categoria {

	private Integer id;
	private String nome;
	private List<Produto> produtos;

	public Categoria(Integer id, String nome) {
		this.nome = nome;
		this.id = id;
		produtos = new ArrayList<>();
	}

	public String getNome() {
		return nome;
	}
	
	public Integer getId() {
		return id;
	}

	public List<Produto> getProdutos() {
		return Collections.unmodifiableList(produtos);
	}

	public void adicionar(Produto produto) {
		this.produtos.add(produto);
	}

	@Override
	public String toString() {
		return nome;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
}
