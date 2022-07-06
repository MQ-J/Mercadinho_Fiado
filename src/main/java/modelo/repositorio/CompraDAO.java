package src.main.java.modelo.repositorio;

import src.main.java.modelo.Compra;
import src.main.java.modelo.Produto;
import src.main.java.modelo.Cliente;
import src.main.java.modelo.Pagamento;

import java.util.ArrayList;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CompraDAO extends FabricaConexao {

    public ArrayList<Compra> recuperarCompras() {

		ArrayList<Compra> resultado = null;

		ArrayList<Produto> produtos = null;
        Cliente clientes = null;
        ArrayList<Pagamento> pagamentos = null;
		
		try
		{
			String stmt = "select data, valorpendente from compras";
			
			PreparedStatement pStmt = super.abrirConexao().prepareStatement(stmt);
			ResultSet rs = pStmt.executeQuery();
			resultado = new ArrayList<Compra>();
			
			while(rs.next()) {
				Compra p = new Compra();

                LocalDateTime date = rs.getTimestamp("data").toLocalDateTime();
                p.setDataCompra(date);
                p.setValorPendente(rs.getFloat("valorpendente"));

                p.setProdutos(produtos); //usar o campo idproduto para pesquisar produto
                p.setCliente(clientes); //usar o campo cpfcliente para pesquisar cliente

                p.setPagamentos(pagamentos); //usar o campo idcompra para pesquisar os pagamentos
				
				resultado.add(p);
			}
			
			super.fecharConexao();
		}
		catch (Exception e)
		{
			System.out.println("Erro ao tentar recuperar as Compras cadastrados. " + e.getMessage());
		}
		
		return resultado;
	}

}
