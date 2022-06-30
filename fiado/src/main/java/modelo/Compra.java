package modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;

import modelo.Produto;

public class Compra {
	protected LocalDateTime dataCompra;
	protected Float valorPendente;
	protected ArrayList<Produto> produtos;
	protected Cliente cliente;
	protected ArrayList<Pagamento> pagamentos;

	/**
	 * Método construtor da classe.
	 */
	public Compra(LocalDateTime dataCompra, Float valorPendente, ArrayList<Produto> produtos, 
			Cliente cliente, ArrayList<Pagamento> pagamentos) {
		this.dataCompra = dataCompra;
	}

	/* Métodos Getters e Setters */

	public LocalDateTime getDataCompra() {
		return dataCompra;
	}

	public void setDataCompra(LocalDateTime dataCompra) {
		this.dataCompra = dataCompra;
	}

	public Float getValorPendente() {
		return valorPendente;
	}

	public void setValorPendente(Float valorPendente) {
		this.valorPendente = valorPendente;
	}

	public ArrayList<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(ArrayList<Produto> produtos) {
		this.produtos = produtos;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public ArrayList<Pagamento> getPagamentos() {
		return pagamentos;
	}

	public void setPagamentos(ArrayList<Pagamento> pagamentos) {
		this.pagamentos = pagamentos;
	}
}