package servlets;

import java.io.IOException;
import java.util.LinkedList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import entidades.Categoria;
import logic.ControladorCategoria;

@WebServlet("/BuscarCategorias")
public class BuscarCategorias extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BuscarCategorias() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LinkedList<Categoria> categorias = new LinkedList();
		ControladorCategoria cc = new ControladorCategoria();
		
		categorias = cc.listar();
		
		HttpSession misession = request.getSession();
		misession.setAttribute("categorias", categorias);
		
		response.sendRedirect("MostrarCategorias.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		String id = request.getParameter("id");
		String nombre = request.getParameter("nombre");
	
		doGet(request, response);
	}

}
