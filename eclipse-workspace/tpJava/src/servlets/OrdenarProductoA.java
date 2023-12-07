package servlets;

import java.io.IOException;
import java.util.LinkedList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entidades.Producto;
import logic.ControladorProducto;

@WebServlet("/OrdenarProductoA")
public class OrdenarProductoA extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public OrdenarProductoA() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LinkedList<Producto> prods = new LinkedList<>();
		ControladorProducto cp = new ControladorProducto();
		
		prods = cp.listadoPorPrecioA();

		HttpSession misession = request.getSession();
		misession.setAttribute("prods", prods);
		
		response.sendRedirect("mostrarProductos.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
