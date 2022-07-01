package src.main.java.modelo;


public class Produto {


	protected int id;


	protected String nome;


	protected Float valor;

	/**
	 * Método construtor da classe.
	 */
	public Produto(int id, String nome, Float valor) {
		this.id = id;
		this.nome = nome;
		this.valor = valor;
	}

	public Produto() {}

	/* Métodos Getters e Setters */

	public int getid() {
		return id;
	}

	public void setid(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Float getValor() {
		return valor;
	}

	public void setValor(Float valor) {
		this.valor = valor;
	}
}
