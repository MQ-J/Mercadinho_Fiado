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
		Produto p = new Produto(1, "Arroz", 30.5f);

        request.setAttribute("produto", p);

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/produto/ver.jsp");
        rd.forward(request, response);
	}
}