package br.com.cadastrocliente.dominio;

public class Estado {
	private int id;
	private String nome;
	private String uf;
	private int pais;
	public Estado() {
		super();
	}
	public Estado(int id, String nome, String uf, int pais) {
		super();
		this.id = id;
		this.nome = nome;
		this.uf = uf;
		this.pais = pais;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public int getPais() {
		return pais;
	}
	public void setPais(int pais) {
		this.pais = pais;
	}
	

}
