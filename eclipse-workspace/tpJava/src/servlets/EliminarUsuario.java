package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Persona;
import logic.ControladorPersona;

@WebServlet("/EliminarUsuario")
public class EliminarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EliminarUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Persona p = new Persona();
		ControladorPersona cp = new ControladorPersona();
		
		p.setIdPersona(Integer.parseInt(request.getParameter("id")));
		cp.baja(p);
		
		response.sendRedirect("UsuarioEliminado.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
