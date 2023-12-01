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

@WebServlet("/ConfirmarModificacion")
public class ConfirmarModificacion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ConfirmarModificacion() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		Producto p = new Producto();
		Categoria c = new Categoria();
		Marca m = new Marca();
		HttpSession misession = request.getSession();
		ControladorProducto cp = new ControladorProducto();
		ControladorCategoria cc = new ControladorCategoria();
		ControladorMarca cm = new ControladorMarca();

		c.setNombre(request.getParameter("categoria"));
		c = cc.buscarPorNombre(c);//NUEVO METODO
		
		m.setNombre(request.getParameter("marca"));
		m = cm.buscarPorNombre(m);//NUEVO METODO
		Producto prodAModificar = (Producto) misession.getAttribute("prod");
		
		p.setIdProducto(prodAModificar.getIdProducto());
		p.setDescripcion(request.getParameter("descripcion"));
		p.setNombre(request.getParameter("nombre"));
		p.setPrecio(Integer.parseInt(request.getParameter("precio")));
		p.setStock(Integer.parseInt(request.getParameter("stock")));
		p.setCat(c);
		p.setBrand(m);
		
		cp.update(p);
		
		response.sendRedirect("ProductoModificado.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//String id = request.getParameter("idProducto");
		String descripcion = request.getParameter("descripcion");
		String nombre = request.getParameter("nombre");
		String precio = request.getParameter("precio");
		String stock = request.getParameter("stock");
		String categoria = request.getParameter("categoria");
		String marca = request.getParameter("marca");
		
		doGet(request, response);
	}

}
