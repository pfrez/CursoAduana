package controller;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.model.Cliente;
import cl.model.ServicioLocal;

/**
 * Servlet implementation class Controller
 */
@WebServlet(name = "control.do", urlPatterns = { "/control.do" })
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private ServicioLocal servicio;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void inicio(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String bt = request.getParameter("boton");
		
		if(bt.equals("guardar"))
			this.guardar(request, response);
		if(bt.equals("eliminar"))
			this.eliminar(request, response);	
		if(bt.equals("actualizar"))
			this.actualizar(request, response);

	}

	protected void guardar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String rut = request.getParameter("rut");
		
		Cliente cli = new Cliente(nombre, apellido,rut);
		servicio.addCliente(cli);
		
		response.sendRedirect("index.jsp");
	}
	
	protected void eliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String rut =request.getParameter("rut");
		servicio.eliminar(rut);
		
		response.sendRedirect("index.jsp");
	}
	
	protected void actualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String rut = request.getParameter("rut");
		Cliente clie = new Cliente(nombre, apellido, rut);
		servicio.actualizar(clie);
		
		response.sendRedirect("index.jsp");
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.inicio(request, response);
	}

}
