package src.main.java.modelo.repositorio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class FabricaConexao
{
	protected Connection conn;
	
	public Connection abrirConexao()
	{
        
		try
		{
            Class.forName("org.postgresql.Driver");
			if(this.conn == null)
			{
				String url = "jdbc:postgresql://kesavan.db.elephantsql.com/qkmtmlxe";
				
				Properties props = new Properties();
				props.setProperty("user", "qkmtmlxe");
				props.setProperty("password", "NyFsf2_qXZsVrQ7cgcQz4v267AH1eBPS");
				props.setProperty("ssl", "false");
				
				this.conn = DriverManager.getConnection(url, props);
				
				System.out.println("Conexão aberta!");
			}
			else
			{
				System.out.println("Conexão já está aberta!");
			}
		}
		catch (Exception e)
		{
			System.out.println("Erro ao criar conexão! " + e.getMessage());
		}
		
		return this.conn;
	}
	
	public void fecharConexao()
	{
		try
		{
			if(this.conn != null)
			{
				this.conn.close();
				this.conn = null;
				System.out.println("Conexão fechada!");
			}
			else
			{
				System.out.println("Conexão não existe!");
			}
		}
		catch (Exception e)
		{
			System.out.println("Erro ao fechar conexão! " + e.getMessage());
		}
	}
}
