package controlador;

import java.time.LocalDateTime;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import src.main.java.modelo.Compra;
import src.main.java.modelo.Produto;
import src.main.java.modelo.Cliente;

import java.util.ArrayList;

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
        ArrayList<Produto> produtosA = new ArrayList<Produto>();
        produtosA.add(new Produto(3, "Feijão Jerimum 1kg", 11.25f));
        produtosA.add(new Produto(6, "Papel Higiênico Fofin 60m 6x2", 15f));

        ArrayList<Produto> produtosB = new ArrayList<Produto>();
        produtosB.add(new Produto(4, "oleo de soja Maranguape 900ml", 9.50f));
        produtosB.add(new Produto(5, "oleo de soja Silvana 900ml", 13.60f));
        produtosB.add(new Produto(6, "Papel Higiênico Fofin 60m 6x2", 15f));

        ArrayList<Produto> produtosC = new ArrayList<Produto>();
        produtosC.add(new Produto(1, "Arroz Guacira", 20.5f));
        
		Compra a = new Compra(LocalDateTime.now(), (float) 5, produtosA, new Cliente("Dona Benedita de Oliveira", "709.598.660-60", "11958556473", null), null);
        Compra b = new Compra(LocalDateTime.now(), (float) 10, produtosB, new Cliente("Miguel Santana", "504.807.670-25", "99865-2618", null), null);
        Compra c = new Compra(LocalDateTime.now(), (float) 0, produtosC, new Cliente("Sandra de Oliveira", "274.090.820-20", "99664-9590", null), null);

        request.setAttribute("a", a);
        request.setAttribute("b", b);
        request.setAttribute("c", c);

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/compra/ver.jsp");
        rd.forward(request, response);
	}
}
