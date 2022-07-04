package controlador;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

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
		Cliente a = new Cliente("Maria josé de fátima", "759.603.690-28", "11908897656", null);
        Cliente b = new Cliente("Gabriel Luiz", "212.632.280-70", "11958556473", null);

        request.setAttribute("a", a);
        request.setAttribute("b", b);

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/cliente/ver.jsp");
        rd.forward(request, response);
	}
}
