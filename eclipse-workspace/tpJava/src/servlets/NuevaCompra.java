package servlets;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entidades.Categoria;
import entidades.Producto;
import logic.ControladorCategoria;
import logic.ControladorProducto;

@WebServlet("/NuevaCompra")
public class NuevaCompra extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public NuevaCompra() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Categoria> cats = new LinkedList<>();
		//CREAR NUEVA VENTA ACA PARA TENER A FUTURO Y PODER GUARDAR LAS nuevaLineaVenta
		ControladorCategoria cc = new ControladorCategoria();
		cats = cc.listar();
		
		HttpSession misesion = request.getSession();
		misesion.setAttribute("cats", cats);
		
		response.sendRedirect("CategoriasParaComprar.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
