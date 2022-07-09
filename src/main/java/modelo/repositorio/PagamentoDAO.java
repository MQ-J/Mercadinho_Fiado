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

				ArrayList<Compra> compras = new ArrayList<Compra>();
				Compra c = new Compra();
				c.setIdCompra(rs.getInt("id"));
				compras.add(c);
                p.setCompras(compras); //correlaciona compras usando Id
				
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

	public int novoPagamento(int idcompra, Float valor) {
		
		int rs = 0;
		
		try
		{
			String stmt = "insert into pagamentos (data, valorpago, id) values (now(), ?, ?)";
			
			PreparedStatement pStmt = super.abrirConexao().prepareStatement(stmt);

            pStmt.setFloat(1, valor);
			pStmt.setInt(2, idcompra);

			rs = pStmt.executeUpdate();
			
			super.fecharConexao();
		}
		catch (Exception e)
		{
			System.out.println("Erro ao tentar criar este Pagamento. " + e.getMessage());
		}
		
		return rs;
	}

}
