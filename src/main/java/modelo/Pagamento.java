package src.main.java.modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Pagamento {
	protected LocalDateTime dataPagto;
	protected Float valorPago;
	protected ArrayList<Compra> compras;

	/**
	 * Método construtor da classe.
	 */
	public Pagamento(LocalDateTime dataPagto, Float valorPago, ArrayList<Compra> compras) {
		this.dataPagto = dataPagto;
		this.valorPago = valorPago;
		this.compras = compras;
	}

	/* Métodos Getters e Setters */

	public Float getValorPago() {
		return valorPago;
	}

	public void setValorPago(Float valorPago) {
		this.valorPago = valorPago;
	}

	public LocalDateTime getDataPagto() {
		return dataPagto;
	}

	public void setDataPagto(LocalDateTime dataPagto) {
		this.dataPagto = dataPagto;
	}

	public ArrayList<Compra> getCompras() {
		return compras;
	}

	public void setCompras(ArrayList<Compra> compras) {
		this.compras = compras;
	}
}
