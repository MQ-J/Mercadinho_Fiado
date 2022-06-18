import java.util.ArrayList;

public class Cliente {
	protected String nome;
	private String cpf;
	protected String telefone;
	protected ArrayList<Compra> compras;

	/**
	 * Método construtor da classe.
	 */
	public Cliente(String nome, String cpf, String telefone, ArrayList<Compra> compras) {
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.compras = compras;
	}

	/* Métodos Getters e Setters */

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return this.cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String gettelefone() {
		return this.telefone;
	}

	public void settelefone(String telefone) {
		this.telefone = telefone;
	}

	public ArrayList<Compra> getCompras() {
		return this.compras;
	}

	public void setCompras(ArrayList<Compra> compras) {
		this.compras = compras;
	}

}