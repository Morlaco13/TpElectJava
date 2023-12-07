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

@WebServlet("/ConfirmarModificacionUser")
public class ConfirmarModificacionUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ConfirmarModificacionUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Persona p = new Persona();
		ControladorPersona cp = new ControladorPersona();
		
		p.setIdPersona(Integer.parseInt(request.getParameter("id")));;	
		p.setNombre(request.getParameter("nombre"));
		p.setApellido(request.getParameter("apellido"));
		p.setDni(Integer.parseInt(request.getParameter("dni")));
		p.setDireccion(request.getParameter("direccion"));
		p.setTelefono(Integer.parseInt(request.getParameter("telefono")));
		p.setEmail(request.getParameter("email"));
		if ("1".equals(request.getParameter("admin"))) {
			p.setEsAdmin(false);			
		}else { p.setEsAdmin(true); }
		p.setPassword(request.getParameter("password"));
		
		cp.update(p);
		
		HttpSession misession = request.getSession();
		misession.setAttribute("p", p);
		
		response.sendRedirect("MostrarUserPorId.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
