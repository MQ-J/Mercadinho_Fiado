package controlador;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import src.main.java.modelo.repositorio.CompraDAO;
import java.util.ArrayList;

import src.main.java.modelo.Compra;

import controlador.VerCompraServlet;

import java.io.IOException;

public class AlterarCompraServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
       
    public AlterarCompraServlet()
    {
        super();
    }
    
    protected void doGet(HttpServletRequest request,
    					 HttpServletResponse response) throws ServletException, IOException
    {

        CompraDAO fb = new CompraDAO();

        int id = Integer.parseInt(request.getParameter("id"));
        int compras = fb.ApagarCompras(id);

        VerCompraServlet ver = new VerCompraServlet();
        ver.doGet(request, response);
	}

    protected void doPost(HttpServletRequest request, 
                        HttpServletResponse response) throws ServletException, IOException
    {
		CompraDAO fb = new CompraDAO();

        String cpf = request.getParameter("cpf");
        Float valor = Float.parseFloat(request.getParameter("valor"));
        int idProd = Integer.parseInt(request.getParameter("idProd"));
        int id = Integer.parseInt(request.getParameter("id"));

        int compras = fb.EditarCompras(cpf, valor, idProd, id);

        VerCompraServlet ver = new VerCompraServlet();
        ver.doGet(request, response);
	}
}
