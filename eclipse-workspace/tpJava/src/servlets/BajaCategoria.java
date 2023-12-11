package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entidades.Categoria;
import logic.ControladorCategoria;

@WebServlet("/BajaCategoria")
public class BajaCategoria extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BajaCategoria() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Categoria c = new Categoria();
		ControladorCategoria cc = new ControladorCategoria();
		
		c.setIdCategoria(Integer.parseInt(request.getParameter("idCategoria")));
		cc.baja(c);
		
		response.sendRedirect("CategoriaEliminada.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
