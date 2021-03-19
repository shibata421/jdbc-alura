package br.com.alura.jdbc.modelo;

public class Produto {

	private Integer id;
	private String nome;
	private String descricao;
	private Integer categoriaId;
	
	public Produto(String nome, String descricao) {
		this.nome = nome;
		this.descricao = descricao;
	}

	public Produto(Integer id, String nome, String descricao) {
		this(nome, descricao);
		this.id = id;
	}
	
	public Produto(String nome, String descricao, Integer categoriaId) {
		this(nome, descricao);
		this.categoriaId = categoriaId;
	}
	
	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return String.format("id: %d, nome: %s, descrição: %s", 
				id, nome, descricao);
	}

	public Integer getId() {
		return this.id;
	}

	public void setCategoriaId(Integer categoriaId) {
		this.categoriaId = categoriaId;
	}

	public Integer getCategoriaId() {
		return categoriaId;
	}
}
