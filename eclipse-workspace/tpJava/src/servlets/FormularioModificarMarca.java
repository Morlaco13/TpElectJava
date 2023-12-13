package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import entidades.Marca;
import logic.ControladorMarca;

@WebServlet("/FormularioModificarMarca")
public class FormularioModificarMarca extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FormularioModificarMarca() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Marca m = new Marca();
		ControladorMarca cm = new ControladorMarca();
		
		m.setIdMarca(Integer.parseInt(request.getParameter("idMarca")));
		m = cm.buscar(m);
		
		HttpSession misession = request.getSession();
		misession.setAttribute("m", m);
		
		request.getRequestDispatcher("FormularioModificarMarca.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
