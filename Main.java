import java.time.LocalDateTime;
import java.util.ArrayList;

import src.main.java.modelo.Cliente;
import src.main.java.modelo.Compra;
import src.main.java.modelo.Pagamento;
import src.main.java.modelo.Produto;

public class Main {
	public static void main(String[] args) {

		//inicializa array de compras como null (para criar cliente)
		ArrayList<Compra> compras = null;

		//cria cliente
		Cliente cli = new Cliente("Vagner", "12345678911", "(11) 9999-99999", compras);

		//cria produto
		Produto prod = new Produto(1, "Caixa de leite Itamilk", (float) 5);
		
		//inicializa array de produtos e pagamentos como null 
		//(gambiarra para criar compra, depois tenho q preencher essas listas)
		ArrayList<Produto> produtos = null;
		ArrayList<Pagamento> pagamento = null;
		
		//cria compra
		Compra buy = new Compra(LocalDateTime.now(), (float) 5, produtos, cli, pagamento);
		
		//cria pagamento (precisa de compra)
		Pagamento pagto = new Pagamento(LocalDateTime.now(), (float) 5, compras);

		System.out.println("Produtos disponiveis: " + prod.getNome());
		System.out.println("Clientes existentes: " + cli.getNome());
		System.out.println("O cliente " + cli.getNome() + 
		" fez uma compra em " + buy.getDataCompra());
		System.out.println("O cliente " + cli.getNome() + 
		" pagou a compra de <atrelar pagamento a compra> " +
		"em " + pagto.getDataPagto());
	}
}