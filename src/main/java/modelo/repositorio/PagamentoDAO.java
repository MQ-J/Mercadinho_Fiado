package src.main.java.modelo.repositorio;

import src.main.java.modelo.Pagamento;
import src.main.java.modelo.Compra;

import java.util.ArrayList;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PagamentoDAO extends FabricaConexao {

    public ArrayList<Pagamento> recuperarPagamentos() {

		ArrayList<Pagamento> resultado = null;

		ArrayList<Compra> compras = null;
		
		try
		{
			String stmt = "select data, valorpago, id from pagamentos";
			
			PreparedStatement pStmt = super.abrirConexao().prepareStatement(stmt);
			ResultSet rs = pStmt.executeQuery();
			resultado = new ArrayList<Pagamento>();
			
			while(rs.next()) {
				Pagamento p = new Pagamento();

                LocalDateTime date = rs.getTimestamp("data").toLocalDateTime();
                p.setDataPagto(date);
                p.setValorPago(rs.getFloat("valorpago"));

                p.setCompras(compras); //usar o campo id para pesquisar compra
				
				resultado.add(p);
			}
			
			super.fecharConexao();
		}
		catch (Exception e)
		{
			System.out.println("Erro ao tentar recuperar os Pagamentos cadastrados. " + e.getMessage());
		}
		
		return resultado;
	}

}
