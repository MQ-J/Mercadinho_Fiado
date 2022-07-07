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

// COMO FAZER INSERT OLHA AQUI ***********************************************************************

// package com.mkyong.jdbc.preparestatement.row;

// import java.math.BigDecimal;
// import java.sql.*;
// import java.time.LocalDateTime;

// public class RowInsert {

//     private static final String SQL_INSERT = "INSERT INTO EMPLOYEE (NAME, SALARY, CREATED_DATE) VALUES (?,?,?)";

//     public static void main(String[] args) {

//         try (Connection conn = DriverManager.getConnection(
//                 "jdbc:postgresql://127.0.0.1:5432/test", "postgres", "password");
//              PreparedStatement preparedStatement = conn.prepareStatement(SQL_INSERT)) {

//             preparedStatement.setString(1, "mkyong");
//             preparedStatement.setBigDecimal(2, new BigDecimal(799.88));
//             preparedStatement.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));

//             int row = preparedStatement.executeUpdate();

//             // rows affected
//             System.out.println(row); //1

//         } catch (SQLException e) {
//             System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
//         } catch (Exception e) {
//             e.printStackTrace();
//         }

//     }

// }

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
			System.out.println("Erro ao tentar recuperar os Clientes cadastrados. " + e.getMessage());
		}
		
		return rs;
	}

}
