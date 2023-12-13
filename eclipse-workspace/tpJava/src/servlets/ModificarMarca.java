package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entidades.Marca;
import logic.ControladorMarca;

@WebServlet("/ModificarMarca")
public class ModificarMarca extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ModificarMarca() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Marca m = new Marca();
		ControladorMarca cm = new ControladorMarca();
		
		m.setIdMarca(Integer.parseInt(request.getParameter("idMarca")));
		m.setNombre(request.getParameter("nombre"));
		cm.update(m);
		
		response.sendRedirect("MarcaModificada.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
