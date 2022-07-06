package controlador;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import src.main.java.modelo.repositorio.ProdutoDAO;
import java.util.ArrayList;

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

        ProdutoDAO fb = new ProdutoDAO();

        ArrayList<Produto> produtos = fb.recuperarProdutos();

        request.setAttribute("produtos", produtos);
        request.setAttribute("tituloPagina", "Ver Produtos Cadastrados");
        request.setAttribute("pathview", "/WEB-INF/views/produto/ver.jsp");

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/template.jsp");
        rd.forward(request, response);
	}
}
