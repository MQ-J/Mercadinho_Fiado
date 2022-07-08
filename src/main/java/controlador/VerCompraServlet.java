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

import java.io.IOException;

public class VerCompraServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
       
    public VerCompraServlet()
    {
        super();
    }
    
    protected void doGet(HttpServletRequest request,
    					 HttpServletResponse response) throws ServletException, IOException
    {

        CompraDAO fb = new CompraDAO();

        ArrayList<Compra> compras = fb.recuperarCompras();

        request.setAttribute("compras", compras);
        request.setAttribute("tituloPagina", "Compras Realizadas");
        request.setAttribute("pathview", "/WEB-INF/views/compra/ver.jsp");

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/template.jsp");
        rd.forward(request, response);
	}

    protected void doPost(HttpServletRequest request, 
                        HttpServletResponse response) throws ServletException, IOException
    {
        int id = Integer.parseInt(request.getParameter("idProd"));
        String cpf = request.getParameter("cpf");
        Float valor = Float.parseFloat(request.getParameter("valor"));
        int idCompra = Integer.parseInt(request.getParameter("idCompra"));

		CompraDAO fb = new CompraDAO();

        int resultado = fb.novaCompra(id, cpf, valor, idCompra);

		doGet(request, response);
	}
}
