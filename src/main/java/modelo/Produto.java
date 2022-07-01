package src.main.java.modelo;

@Entity
@Table(name = "produtos")
public class Produto {

	@Id
	protected int id;

	@Column(length = 255, nullable = false)
	protected String nome;

	@Column(precision=10, scale=2)
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
