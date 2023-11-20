package servlets;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Persona;
import logic.Login;


@WebServlet("/Signin")
public class Signin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Signin() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Persona p = new Persona();
		Login ctrl = new Login();
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		//Deberia validar
		p.setEmail("email");
		p.setPassword("password");
		
		p = ctrl.validate(p);
		
		LinkedList<Persona> personas = ctrl.getAll();
		
		request.getSession().setAttribute("usuario", p);
		request.setAttribute("listaPersonas", personas);
		request.getRequestDispatcher("WEB-INF/UserManagement.jsp").forward(request, response);
	}

}
