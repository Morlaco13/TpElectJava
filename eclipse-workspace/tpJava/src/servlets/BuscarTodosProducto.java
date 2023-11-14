package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.LinkedList;
import java.util.List;

import entidades.Producto;
import logic.ControladorProducto;

@WebServlet("/BuscarTodosProducto")
public class BuscarTodosProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BuscarTodosProducto() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Producto> prods = new LinkedList<>();
		
		ControladorProducto cp = new ControladorProducto();
		prods = cp.listar();
		
		HttpSession misesion = request.getSession();
		misesion.setAttribute("prods", prods);
		
		response.sendRedirect("mostrarProductos.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String descripcion = request.getParameter("descripcion");
		String nombre = request.getParameter("nombre");
		String precio = request.getParameter("precio");
		String stock = request.getParameter("stock");
		String categoria = request.getParameter("categoria");
		String marca = request.getParameter("marca");
		
		doGet(request, response);
	}

}
