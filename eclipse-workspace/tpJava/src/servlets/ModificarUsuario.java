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

@WebServlet("/ModificarUsuario")
public class ModificarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ModificarUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Persona p = new Persona();
		ControladorPersona cp = new ControladorPersona();
		p.setIdPersona(Integer.parseInt(request.getParameter("id")));
		
		p = cp.buscar(p);
		HttpSession misession = request.getSession();
		misession.setAttribute("p", p);
		
		response.sendRedirect("FormularioModificarUsuario.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idPersona = request.getParameter("id");
		
		doGet(request, response);
	}

}
