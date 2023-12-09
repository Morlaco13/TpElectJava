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

@WebServlet("/Perfil")
public class Perfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Perfil() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("El id es" + request.getParameter("idPersona"));
		Persona p = new Persona();
		ControladorPersona cp = new ControladorPersona();
		p.setIdPersona(Integer.parseInt(request.getParameter("idPersona")));
		p = cp.buscar(p);
		System.out.println(p.getNombre());
		
		request.getSession().setAttribute("p", p);
		
		response.sendRedirect("MostrarUserPorId.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		String idPersona = request.getParameter("idPersona");
		
		doGet(request, response);
	}

}
