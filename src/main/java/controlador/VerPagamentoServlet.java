package controlador;

import java.time.LocalDateTime;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import src.main.java.modelo.Pagamento;

import java.io.IOException;

public class VerPagamentoServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
       
    public VerPagamentoServlet()
    {
        super();
    }
    
    protected void doGet(HttpServletRequest request,
    					 HttpServletResponse response) throws ServletException, IOException
    {
		Pagamento a = new Pagamento(LocalDateTime.now(), (float) 5, null);
        Pagamento b = new Pagamento(LocalDateTime.now(), (float) 5, null);

        request.setAttribute("a", a);
        request.setAttribute("b", b);

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/pagamento/ver.jsp");
        rd.forward(request, response);
	}
}
