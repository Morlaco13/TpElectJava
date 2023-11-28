package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entidades.Cliente;
import entidades.LineaVenta;
import entidades.Persona;
import entidades.Venta;
import logic.ControladorCliente;
import logic.ControladorLineaVenta;
import logic.ControladorVenta;

@WebServlet("/FinalizarCompra")
public class FinalizarCompra extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public FinalizarCompra() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Date date = new Date();
		HttpSession misession = request.getSession();
		Persona p = (Persona) misession.getAttribute("usuario");

		ControladorVenta cv = new ControladorVenta();
		ControladorCliente cc = new ControladorCliente();
		ControladorLineaVenta cl = new ControladorLineaVenta();
		
		Venta venta = (Venta) misession.getAttribute("venta");
		venta.setPer(p);
		venta.setFechaVentaActual();
		//FALTA ELIMINAR PRODUCTOS DE LA BASE DE DATOS
		venta = cv.alta(venta);//GUARDO LA VENTA EN LA BASE DE DATOS
		//Creo las lineaVenta en la BD
		ArrayList<LineaVenta> lineaventa = (ArrayList<LineaVenta>) venta.getLineas();
		for ( LineaVenta lv : lineaventa) {
			cl.alta(lv);
		}		
		
		misession.setAttribute("venta", venta);
		
		response.sendRedirect("CompraRealizada.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
