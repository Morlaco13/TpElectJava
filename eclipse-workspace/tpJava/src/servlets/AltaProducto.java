package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entidades.Categoria;
import entidades.Marca;
import entidades.Producto;
import logic.ControladorCategoria;
import logic.ControladorMarca;
import logic.ControladorProducto;

@WebServlet("/AltaProducto")
public class AltaProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AltaProducto() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		Producto p = new Producto();
		Marca m = new Marca();
		Categoria c = new Categoria();
		ControladorProducto cp = new ControladorProducto();
		ControladorMarca cm = new ControladorMarca();
		ControladorCategoria cc = new ControladorCategoria();
		m.setIdMarca(Integer.parseInt(request.getParameter("marca")));
		p.setBrand(cm.buscar(m));
		c.setIdCategoria(Integer.parseInt(request.getParameter("categoria")));
		p.setCat(cc.buscar(c));
		
		p.setNombre(request.getParameter("nombre"));
		p.setDescripcion(request.getParameter("descripcion"));
		p.setPrecio(Integer.parseInt(request.getParameter("precio")));
		p.setStock(Integer.parseInt(request.getParameter("stock")));
		
		cp.alta(p);
		
		HttpSession misession = request.getSession();
		misession.setAttribute("p", p);
		
		response.sendRedirect("ProductoAgregado.jsp");
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
