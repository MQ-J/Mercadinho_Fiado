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

import controlador.VerProdutoServlet;

import java.io.IOException;

public class AlterarProdutoServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
       
    public AlterarProdutoServlet()
    {
        super();
    }
    
    protected void doGet(HttpServletRequest request,
    					 HttpServletResponse response) throws ServletException, IOException
    {

        ProdutoDAO fb = new ProdutoDAO();

        int id = Integer.parseInt(request.getParameter("id"));
        int produtos = fb.ApagarProdutos(id);

        VerProdutoServlet ver = new VerProdutoServlet();
        ver.doGet(request, response);
	}

    protected void doPost(HttpServletRequest request, 
                        HttpServletResponse response) throws ServletException, IOException
    {
		ProdutoDAO fb = new ProdutoDAO();

        String nome = request.getParameter("nome");
        Float valor = Float.parseFloat(request.getParameter("valor"));
        int id = Integer.parseInt(request.getParameter("id"));

        int produtos = fb.EditarProdutos(nome, valor, id);

        VerProdutoServlet ver = new VerProdutoServlet();
        ver.doGet(request, response);
	}
}
