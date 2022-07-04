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

        /*Produto[] produtos = new Produto[] {
            new Produto(1, "Arroz Guacira", 20.5f),
            new Produto(2, "Coca-Cola 2L", 7.5f),
            new Produto(3, "Feijão Jerimum 1kg", 11.25f),
            new Produto(4, "oleo de soja Maranguape 900ml", 9.50f),
            new Produto(5, "oleo de soja Silvana 900ml", 13.60f),
            new Produto(6, "Papel Higiênico Fofin 60m 6x2", 15f), 
            new Produto(7, "File de Frango Kg", 18f)
        };*/
        request.setAttribute("produtos", produtos);

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/produto/ver.jsp");
        rd.forward(request, response);
	}
}
