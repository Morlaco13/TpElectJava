package servlets;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entidades.Persona;
import logic.ControladorPersona;

@WebServlet("/BuscarTodosUsuarios")
public class BuscarTodosUsuarios extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BuscarTodosUsuarios() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Persona> pers = new LinkedList<>();
		
		ControladorPersona cp = new ControladorPersona();
		pers = cp.listar();
		
		HttpSession misesion = request.getSession();
		misesion.setAttribute("pers", pers);
		
		response.sendRedirect("MostrarPersonas.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String dni = request.getParameter("dni");
		String telefono = request.getParameter("telefono");
		String direccion = request.getParameter("direccion");
		String email = request.getParameter("email");
		String esAdmin = request.getParameter("esAdmin");
		String password = request.getParameter("password");
		
		doGet(request, response);
	}

}
