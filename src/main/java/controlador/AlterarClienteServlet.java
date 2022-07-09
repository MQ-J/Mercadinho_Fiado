package controlador;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import src.main.java.modelo.repositorio.ClienteDAO;
import java.util.ArrayList;

import src.main.java.modelo.Cliente;

import controlador.VerClienteServlet;

import java.io.IOException;

public class AlterarClienteServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
       
    public AlterarClienteServlet()
    {
        super();
    }
    
    protected void doGet(HttpServletRequest request,
    					 HttpServletResponse response) throws ServletException, IOException
    {

        ClienteDAO fb = new ClienteDAO();

        String cpf = request.getParameter("cpf");

        int clientes = fb.ApagarClientes(cpf);

        VerClienteServlet ver = new VerClienteServlet();
        ver.doGet(request, response);
	}

    protected void doPost(HttpServletRequest request, 
                        HttpServletResponse response) throws ServletException, IOException
    {
		ClienteDAO fb = new ClienteDAO();

        String nome = request.getParameter("nome");
        String cpf = request.getParameter("cpf");
        String telefone = request.getParameter("phone");

        int clientes = fb.EditarClientes(nome, cpf, telefone);

        VerClienteServlet ver = new VerClienteServlet();
        ver.doGet(request, response);
	}
}
