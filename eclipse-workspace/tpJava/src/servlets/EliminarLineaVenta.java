package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entidades.LineaVenta;
import entidades.Producto;
import entidades.Venta;
import logic.ControladorLineaVenta;
import logic.ControladorProducto;

@WebServlet("/EliminarLineaVenta")
public class EliminarLineaVenta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EliminarLineaVenta() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<LineaVenta> lineas = new ArrayList<>();
		
		int idProducto = Integer.parseInt(request.getParameter("idProducto"));
		
		HttpSession misession = request.getSession();
		Venta venta = (Venta) request.getSession().getAttribute("venta");
		lineas = (ArrayList<LineaVenta>) venta.getLineas();
		
		lineas.removeIf(lv -> lv.getProd().getIdProducto() == idProducto);
		
		response.sendRedirect("Carrito.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
