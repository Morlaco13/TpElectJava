package servlets;

import java.io.IOException;
import java.util.LinkedList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entidades.Marca;
import logic.ControladorMarca;

@WebServlet("/BuscarMarcas")
public class BuscarMarcas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BuscarMarcas() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LinkedList<Marca> marcas = new LinkedList();
		ControladorMarca cm = new ControladorMarca();
		
		marcas = cm.listar();
		
		HttpSession misession = request.getSession();
		misession.setAttribute("marcas", marcas);
		
		response.sendRedirect("MostrarMarcas.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		String id = request.getParameter("id");
		String nombre = request.getParameter("nombre");
	
		doGet(request, response);
	}

}
