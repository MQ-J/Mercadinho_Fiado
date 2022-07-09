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

import controlador.VerPagamentoServlet;

import java.io.IOException;

public class AlterarPagamentoServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
       
    public AlterarPagamentoServlet()
    {
        super();
    }
    
    protected void doGet(HttpServletRequest request,
    					 HttpServletResponse response) throws ServletException, IOException
    {

        PagamentoDAO fb = new PagamentoDAO();

        int id = Integer.parseInt(request.getParameter("id"));
        Float valor = Float.parseFloat(request.getParameter("valor"));

        int Pagamentos = fb.ApagarPagamentos(id, valor);

        VerPagamentoServlet ver = new VerPagamentoServlet();
        ver.doGet(request, response);
	}

    protected void doPost(HttpServletRequest request, 
                        HttpServletResponse response) throws ServletException, IOException
    {
		PagamentoDAO fb = new PagamentoDAO();

        Float valor = Float.parseFloat(request.getParameter("valor"));
        int id = Integer.parseInt(request.getParameter("idcompra"));
        int idOld = Integer.parseInt(request.getParameter("idcompraOld"));
        Float valorOld = Float.parseFloat(request.getParameter("valorOld"));

        int Pagamentos = fb.EditarPagamentos(valor, id, idOld, valorOld);

        VerPagamentoServlet ver = new VerPagamentoServlet();
        ver.doGet(request, response);
	}
}
