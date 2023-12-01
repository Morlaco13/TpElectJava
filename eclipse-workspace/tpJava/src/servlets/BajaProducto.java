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

@WebServlet("/BajaProducto")
public class BajaProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BajaProducto() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Producto p = new Producto();
		
		p.setIdProducto(Integer.parseInt(request.getParameter("idProducto")));
		
		ControladorProducto cp = new ControladorProducto();
		p = cp.buscar(p);
		
		HttpSession misesion = request.getSession();
		misesion.setAttribute("p", p);
		
		cp.baja(p); //DA DE BAJA EL OBJETO
		
		response.sendRedirect("ProductoEliminado.jsp");
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
