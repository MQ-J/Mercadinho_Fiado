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

        Cliente[] clientes = new Cliente[] {
            new Cliente("Sandra de Oliveira", "274.090.820-20", "99664-9590", null),
            new Cliente("Alice inácio", "825.229.150-37", "98088-5539", null),
            new Cliente("Felipe de Alencar", "212.632.280-70", "96976-7325", null),
            new Cliente("Gabriel Luiz", "064.867.170-41", "96781-1658", null),
            new Cliente("Miguel Santana", "504.807.670-25", "99865-2618", null),
            new Cliente("Maria Eudise", "012.740.520-84", "98163-3658", null),
            new Cliente("Marcos Ramos", "807.782.060-33", "98866-6185", null),
            new Cliente("Dona Benedita de Oliveira", "709.598.660-60", "11958556473", null),
            new Cliente("Arlindo dos Santos", "920.952.580-96", "97316-7694", null),
            new Cliente("Pedro Henrique", "320.926.740-56", "99961-2866", null),
            new Cliente("Denisson", "086.274.100-97", "98690-4360", null),
            new Cliente("Renan Domingues", "419.317.070-57", "97982-8225", null),
            new Cliente("Larissa Santos Sousa", "873.913.960-36", "99645-4879", null)
        };
        request.setAttribute("clientes", clientes);

        request.setAttribute("tituloPagina", "Meus Clientes");
        request.setAttribute("pathview", "/WEB-INF/views/cliente/ver.jsp");

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/template.jsp");
        rd.forward(request, response);
	}
}
