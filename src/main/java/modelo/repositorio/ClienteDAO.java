package src.main.java.modelo.repositorio;

import src.main.java.modelo.Cliente;
import src.main.java.modelo.Compra;
import java.util.ArrayList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ClienteDAO extends FabricaConexao {

    public ArrayList<Cliente> recuperarClientes() {

		ArrayList<Cliente> resultado = null;
		ArrayList<Compra> compras = null;
		
		try
		{
			String stmt = "select nome, cpf, telefone from clientes";
			
			PreparedStatement pStmt = super.abrirConexao().prepareStatement(stmt);
			ResultSet rs = pStmt.executeQuery();
			resultado = new ArrayList<Cliente>();
			
			while(rs.next()) {
				Cliente p = new Cliente();
				p.setNome(rs.getString("nome"));
				p.setCpf(rs.getString("cpf"));
				p.settelefone(rs.getString("telefone"));
				p.setCompras(compras);
				
				resultado.add(p);
			}
			
			super.fecharConexao();
		}
		catch (Exception e)
		{
			System.out.println("Erro ao tentar recuperar os Clientes cadastrados. " + e.getMessage());
		}
		
		return resultado;
	}

	public int novoCliente(String cpf, String nome, String telefone) {
		
		int rs = 0;
		
		try
		{
			String stmt = "insert into clientes (cpf, nome, telefone) values (?, ?, ?)";
			
			PreparedStatement pStmt = super.abrirConexao().prepareStatement(stmt);

			pStmt.setString(1, cpf);
            pStmt.setString(2, nome);
            pStmt.setString(3, telefone);

			rs = pStmt.executeUpdate();
			
			super.fecharConexao();
		}
		catch (Exception e)
		{
			System.out.println("Erro ao tentar criar este Cliente. " + e.getMessage());
		}
		
		return rs;
	}

}
