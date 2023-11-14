package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entidades.Persona;
import logic.ControladorPersona;

@WebServlet("/BuscarUsuarioDni")
public class BuscarUsuarioDni extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public BuscarUsuarioDni() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Persona p = new Persona();
		
		p.setDni(Integer.parseInt(request.getParameter("dni")));
		
		ControladorPersona cp = new ControladorPersona();
		p = cp.getByDni(p);
		
		HttpSession misesion = request.getSession();
		misesion.setAttribute("p", p);
		
		response.sendRedirect("MostrarUserPorId.jsp");
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
