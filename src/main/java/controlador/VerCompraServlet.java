package controlador;

import java.time.LocalDateTime;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

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
		Compra a = new Compra(LocalDateTime.now(), (float) 5, null, null, null);
        Compra b = new Compra(LocalDateTime.now(), (float) 5, null, null, null);

        request.setAttribute("a", a);
        request.setAttribute("b", b);

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/compra/ver.jsp");
        rd.forward(request, response);
	}
}
