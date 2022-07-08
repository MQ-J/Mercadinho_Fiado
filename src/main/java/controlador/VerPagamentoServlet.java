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
        PagamentoDAO fb = new PagamentoDAO();

        ArrayList<Pagamento> pagamentos = fb.recuperarPagamentos();

        request.setAttribute("pagamentos", pagamentos);

        request.setAttribute("tituloPagina", "Pagamentos");
        request.setAttribute("pathview", "/WEB-INF/views/pagamento/ver.jsp");

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/template.jsp");
        rd.forward(request, response);
	}

    protected void doPost(HttpServletRequest request, 
                        HttpServletResponse response) throws ServletException, IOException
    {
        int idcompra = Integer.parseInt(request.getParameter("idcompra"));
        Float valor = Float.parseFloat(request.getParameter("valor"));

		PagamentoDAO fb = new PagamentoDAO();

        int resultado = fb.novoPagamento(idcompra, valor);

		doGet(request, response);
	}
}
