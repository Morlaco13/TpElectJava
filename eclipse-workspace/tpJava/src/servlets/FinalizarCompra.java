package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entidades.Cliente;
import entidades.Persona;
import entidades.Venta;
import logic.ControladorCliente;
import logic.ControladorVenta;

@WebServlet("/FinalizarCompra")
public class FinalizarCompra extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public FinalizarCompra() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession misession = request.getSession();
		Persona p = (Persona) misession.getAttribute("usuario");

		ControladorVenta cv = new ControladorVenta();
		ControladorCliente cc = new ControladorCliente();	
		
		Venta venta = (Venta) misession.getAttribute("venta");
		venta.setCli(p);
		//FALTA ELIMINAR PRODUCTOS DE LA BASE DE DATOS
		cv.alta(venta);//GUARDO LA VENTA EN LA BASE DE DATOS
		System.out.println(venta.getIdVenta());
		
		misession.setAttribute("venta", venta);
		
		response.sendRedirect("CompraRealizada.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
