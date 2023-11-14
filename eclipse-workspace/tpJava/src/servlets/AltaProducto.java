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

@WebServlet("/AltaProducto")
public class AltaProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AltaProducto() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Producto p = new Producto();
		
		ControladorProducto cp = new ControladorProducto();
		
		cp.alta(p);
		
		HttpSession misesion = request.getSession();
		misesion.setAttribute("p", p);
		
		response.sendRedirect("FormularioAltaProducto.jsp");
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
