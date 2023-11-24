package servlets;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Administrador;
import entidades.Cliente;
import entidades.Persona;
import logic.ControladorAdministrador;
import logic.ControladorCliente;
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
		p.setEmail(email);
		p.setPassword(password);
		
		p = ctrl.validate(p);
		if ( p.isEsAdmin() != true ) {
			Cliente c = new Cliente();
			ControladorCliente cc = new ControladorCliente();
			c.setIdPersona(p.getIdPersona());
			c = cc.buscar(c);
			request.getSession().setAttribute("usuario", c);
		} else {
			Administrador a = new Administrador();
			ControladorAdministrador ca = new ControladorAdministrador();
			a.setIdPersona(p.getIdPersona());
			a = ca.buscar(a);
			request.getSession().setAttribute("usuario", a);
		}
		
		LinkedList<Persona> personas = ctrl.getAll();
		
		request.setAttribute("listaPersonas", personas);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
