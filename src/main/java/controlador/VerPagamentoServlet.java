package controlador;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import src.main.java.modelo.repositorio.PagamentoDAO;
import java.util.ArrayList;

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
        // ArrayList<Compra> compraA =new ArrayList<Compra>();
        // compraA.add(new Compra(LocalDateTime.now(), (float) 10, null, new Cliente("Dona Benedita de Oliveira", "709.598.660-60", "11958556473", null), null));
        // ArrayList<Compra> compraB =new ArrayList<Compra>();
        // compraA.add(new Compra(LocalDateTime.now(), (float) 0, null, new Cliente("Sandra de Oliveira", "274.090.820-20", "99664-9590", null), null));
		
        // Pagamento a = new Pagamento(LocalDateTime.now(), (float) 28.1, compraA);
        // Pagamento b = new Pagamento(LocalDateTime.now(), (float) 20.5, compraB);

        // request.setAttribute("a", a);
        // request.setAttribute("b", b);

        PagamentoDAO fb = new PagamentoDAO();

        ArrayList<Pagamento> pagamentos = fb.recuperarPagamentos();

        request.setAttribute("pagamentos", pagamentos);

        request.setAttribute("tituloPagina", "Pagamentos");
        request.setAttribute("pathview", "/WEB-INF/views/pagamento/ver.jsp");

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/template.jsp");
        rd.forward(request, response);
	}
}
