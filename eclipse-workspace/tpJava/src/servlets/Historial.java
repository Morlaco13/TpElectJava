package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entidades.Persona;
import entidades.Venta;
import logic.ControladorVenta;

@WebServlet("/Historial")
public class Historial extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Historial() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Persona p = new Persona();
		ControladorVenta cv = new ControladorVenta();
		ArrayList<Venta> historialVentas = new ArrayList<>();
		
		historialVentas = cv.getHistIdPersona(Integer.parseInt(request.getParameter("idPersona")));
		
		HttpSession misession = request.getSession();
		misession.setAttribute("historialVentas", historialVentas);
		
		response.sendRedirect("MostrarHistorial.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
