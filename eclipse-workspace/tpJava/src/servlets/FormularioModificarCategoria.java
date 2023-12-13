package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entidades.Categoria;
import logic.ControladorCategoria;

@WebServlet("/FormularioModificarCategoria")
public class FormularioModificarCategoria extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FormularioModificarCategoria() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		Categoria c = new Categoria();
		ControladorCategoria cc = new ControladorCategoria();
		
		c.setIdCategoria(Integer.parseInt(request.getParameter("idCategoria")));
		c = cc.buscar(c);
		
		HttpSession misession = request.getSession();
		misession.setAttribute("c", c);
		
		request.getRequestDispatcher("FormularioModificarCategoria.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
