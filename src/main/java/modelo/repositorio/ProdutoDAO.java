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

}
