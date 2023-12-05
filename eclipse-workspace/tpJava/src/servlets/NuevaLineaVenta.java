package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entidades.LineaVenta;
import entidades.Producto;
import logic.ControladorProducto;

@WebServlet("/NuevaLineaVenta")
public class NuevaLineaVenta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public NuevaLineaVenta() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idProducto = Integer.parseInt(request.getParameter("idProducto"));
	    int cantidad = Integer.parseInt(request.getParameter("cantidad"));
	    
	    LineaVenta nuevaLineaVenta = new LineaVenta();
	    Producto p = new Producto();
	    p.setIdProducto(idProducto);
	    ControladorProducto cp = new ControladorProducto();
	    p = cp.buscar(p); // Busco el producto
	    
	    nuevaLineaVenta.setProd(p);  //Lo guardo en la nuevalineaVenta
	    nuevaLineaVenta.setCant(cantidad); //Asigno cantidad
	    
	    // Almacenar en sesion nuevaLineaVenta
	    HttpSession session = request.getSession();
	    session.setAttribute("nuevaLineaVenta", nuevaLineaVenta);
	    
	    // Voy a viewProductos
	    response.sendRedirect("MostrarProducto.jsp");
		doGet(request, response);
	}

}
