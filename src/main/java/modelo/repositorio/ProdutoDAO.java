package src.main.java.modelo.repositorio;

import src.main.java.modelo.Produto;
import java.util.ArrayList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ProdutoDAO extends FabricaConexao {

    public ArrayList<Produto> recuperarProdutos() {

		ArrayList<Produto> resultado = null;
		
		try
		{
			String stmt = "select id, nome, valor from produtos";
			
			PreparedStatement pStmt = super.abrirConexao().prepareStatement(stmt);
			ResultSet rs = pStmt.executeQuery();
			resultado = new ArrayList<Produto>();
			
			while(rs.next()) {
				Produto p = new Produto();
				p.setid(rs.getInt("id"));
				p.setNome(rs.getString("nome"));
                p.setValor(rs.getFloat("valor"));
				
				resultado.add(p);
			}
			
			super.fecharConexao();
		}
		catch (Exception e)
		{
			System.out.println("Erro ao tentar recuperar as Produtos cadastradas. " + e.getMessage());
		}
		
		return resultado;
	}

	public int novoProduto(int id, String nome, Float valor) {
		
		int rs = 0;
		
		try
		{
			String stmt = "insert into produtos (id, nome, valor) values (?, ?, ?)";
			
			PreparedStatement pStmt = super.abrirConexao().prepareStatement(stmt);

			pStmt.setInt(1, id);
            pStmt.setString(2, nome);
            pStmt.setFloat(3, valor);

			rs = pStmt.executeUpdate();
			
			super.fecharConexao();
		}
		catch (Exception e)
		{
			System.out.println("Erro ao tentar criar este Produto. " + e.getMessage());
		}
		
		return rs;
	}

	public int ApagarProdutos(int id) {
		
		int rs = 0;
		
		try
		{
			String stmt = "delete from produtos where id=?";
			
			PreparedStatement pStmt = super.abrirConexao().prepareStatement(stmt);

			pStmt.setInt(1, id);

			rs = pStmt.executeUpdate();
			
			super.fecharConexao();
		}
		catch (Exception e)
		{
			System.out.println("Erro ao tentar criar este Produto. " + e.getMessage());
		}
		
		return rs;
	}

}
