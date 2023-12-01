package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entidades.Producto;
import logic.ControladorProducto;

@WebServlet("/FormularioModificarProducto")
public class FormularioModificarProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public FormularioModificarProducto() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession misession = request.getSession();
		
		Producto prod = (Producto) misession.getAttribute("p");
		
		misession.setAttribute("prod", prod);
		
		response.sendRedirect("FormularioModificarProducto.jsp");
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
