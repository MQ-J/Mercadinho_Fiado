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

import java.io.IOException;

public class VerClienteServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
       
    public VerClienteServlet()
    {
        super();
    }
    
    protected void doGet(HttpServletRequest request,
    					 HttpServletResponse response) throws ServletException, IOException
    {

        ClienteDAO fb = new ClienteDAO();

        ArrayList<Cliente> clientes = fb.recuperarClientes();

        request.setAttribute("clientes", clientes);

        request.setAttribute("tituloPagina", "Meus Clientes");
        request.setAttribute("pathview", "/WEB-INF/views/cliente/ver.jsp");

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/template.jsp");
        rd.forward(request, response);
	}

    protected void doPost(HttpServletRequest request, 
                        HttpServletResponse response) throws ServletException, IOException
    {
		String cpf = request.getParameter("cpf");
        String nome = request.getParameter("nome");
        String phone = request.getParameter("phone");

		ClienteDAO fb = new ClienteDAO();

        int resultado = fb.novoCliente(cpf, nome, phone);

		doGet(request, response);
	}
}
