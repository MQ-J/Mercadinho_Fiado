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
        ArrayList<Pagamento> pagamentos = null;
		
		try
		{
			String stmt = "SELECT data, valorpendente, nome, idproduto FROM compras c INNER JOIN clientes p ON p.cpf = c.cpfcliente";
			
			PreparedStatement pStmt = super.abrirConexao().prepareStatement(stmt);
			ResultSet rs = pStmt.executeQuery();
			resultado = new ArrayList<Compra>();
			
			while(rs.next()) {
				Compra p = new Compra();

                LocalDateTime date = rs.getTimestamp("data").toLocalDateTime();
                p.setDataCompra(date);                                          //coloca a data e o valor pendente na compra
                p.setValorPendente(rs.getFloat("valorpendente"));

				String PROD = "select nome, valor from produtos where id=?";
				PreparedStatement getPROD = super.abrirConexao().prepareStatement(PROD);
				getPROD.setInt(1, rs.getInt("idproduto"));
				ResultSet queryproduto = getPROD.executeQuery();                  //pesquisa o produto usando o idproduto
				super.fecharConexao();

				ArrayList<Produto> produtos = new ArrayList<Produto>();
				while(queryproduto.next()) {
					Produto produto = new Produto();
					produto.setNome(queryproduto.getString("nome"));
					produto.setValor(queryproduto.getFloat("valor"));      //instancia novo produto
					produtos.add(produto);
					p.setProdutos(produtos); //correlaciona produto
				}

				Cliente cliente = new Cliente();
				cliente.setNome(rs.getString("nome")); //correlaciona o cliente
                p.setCliente(cliente);

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

	public int novaCompra(int id, String cpf, Float valor, int idCompra) {
		
		int rs = 0;
		
		try
		{
			String stmt = "insert into compras (data, valorpendente, idproduto, cpfcliente, idcompra) values (now(), ?, ?, ?, ?)";
			
			PreparedStatement pStmt = super.abrirConexao().prepareStatement(stmt);

            pStmt.setFloat(1, valor);
			pStmt.setInt(2, id);
			pStmt.setString(3, cpf);
			pStmt.setInt(4, idCompra);

			rs = pStmt.executeUpdate();
			
			super.fecharConexao();
		}
		catch (Exception e)
		{
			System.out.println("Erro ao tentar criar esta Compra. " + e.getMessage());
		}
		
		return rs;
	}

}
