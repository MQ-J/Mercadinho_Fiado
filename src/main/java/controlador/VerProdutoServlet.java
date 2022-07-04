package controlador;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import src.main.java.modelo.Produto;

import java.io.IOException;

public class VerProdutoServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
       
    public VerProdutoServlet()
    {
        super();
    }
    
    protected void doGet(HttpServletRequest request,
    					 HttpServletResponse response) throws ServletException, IOException
    {
		Produto arroz = new Produto(1, "Arroz Guacira", 20.5f);
        Produto cocaCola = new Produto(2, "Coca-Cola 2L", 7.5f);

        request.setAttribute("arroz", arroz);
        request.setAttribute("cocaCola", cocaCola);

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/produto/ver.jsp");
        rd.forward(request, response);
	}
}
