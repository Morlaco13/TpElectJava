package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Marca;
import logic.ControladorMarca;


@WebServlet("/AltaMarca")
public class AltaMarca extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public AltaMarca() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Marca m = new Marca();
		ControladorMarca cm = new ControladorMarca();
		
		m.setNombre(request.getParameter("nombre"));
		cm.alta(m);
		
		response.sendRedirect("MarcaAgregada.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nombre = request.getParameter("nombre");
		
		doGet(request, response);
	}

}
