package Empleado.Servlets;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Empleado.Beans.EmpleadoBean;
import Empleado.Service.EmpleadoService;


/**
 * Servlet implementation class LibroServlet
 */
public class EmpleadoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpleadoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String operacion = request.getParameter("operacion");
		HttpSession sesion = request.getSession(false);
		if (sesion.getAttribute("beanUsuarioSes") == null){
			response.sendRedirect("login.html");
		}else{
		EmpleadoService service = new EmpleadoService();
		String destino = "/listaEmpleados.jsp";
		
		// Accion Eliminar
		if (operacion != null && operacion.equals("buscar")){
			String nombre = request.getParameter("nombre");
			String apellido = request.getParameter("apellido");	
			request.setAttribute("Resultados", service.buscarEmpleados(nombre, apellido));
			destino = "/buscarEmpleados.jsp";
		} 
		
		if (operacion != null && operacion.equals("eliminar")){
			int codigo = Integer.parseInt(request.getParameter("codigo"));
			service.eliminar(codigo);
		} 
		
		// Operacion Modificar
		if (operacion != null && operacion.equals("modificar")   ) {
			String codigo = request.getParameter("codigo");
			if (codigo != null){
				EmpleadoBean e = service.obtenerPorCodigo(Integer.parseInt(codigo));
				request.setAttribute("empleadoReq", e);
				if (e != null){
					destino = "/empleadoEdit.jsp";
				}
			}			
		} 
		else {			
			ArrayList<EmpleadoBean> lista = service.obtenerTodos();
			sesion.setAttribute("listaEmpleados", lista);
		}
		getServletContext().getRequestDispatcher(destino).forward(request, response);			
	}}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accion = request.getParameter("accion");
		HttpSession sesion = request.getSession(false);
		if (sesion.getAttribute("beanUsuarioSes") == null){
			response.sendRedirect("login.html");
		}else{
		if (accion != null && accion.equals("nuevo")){
			getServletContext().getRequestDispatcher("/empleadoNew.jsp").forward(request, response);
		} 
		
		// Accion Ingresar
		else if (accion != null && accion.equals("ingresar")){
			EmpleadoService service = new EmpleadoService();
			EmpleadoBean empleado = new EmpleadoBean();

			ArrayList<EmpleadoBean> m = new ArrayList<EmpleadoBean>();
			m = service.codigo();
			empleado.setCodigo(m.size()+1);
			empleado.setNombre(request.getParameter("nombre"));
			empleado.setApellido(request.getParameter("apellido"));
			empleado.setDireccion(request.getParameter("direccion"));
			empleado.setEmail(request.getParameter("TextField"));
			empleado.setTelefono(request.getParameter("telefono"));
			empleado.setEstado(1);
			
			service.ingresar(empleado);
			response.sendRedirect("empleado");
		} 
		
		// Accion Modificar
		else if (accion != null && accion.equals("modificar"))
		
		{
			int codigo = Integer.parseInt(request.getParameter("codigo"));
			String nombre = request.getParameter("nombre");
			String apellido = request.getParameter("apellido");
			String direccion = request.getParameter("direccion");
			String email = request.getParameter("TextField");
			String telefono = request.getParameter("telefono");
			
			EmpleadoBean e = new EmpleadoBean();
			e.setCodigo(codigo);
			e.setNombre(nombre);
			e.setApellido(apellido);
			e.setDireccion(direccion);
			e.setEmail(email);
			e.setTelefono(telefono);	
			
			EmpleadoService service = new EmpleadoService();
			int cantRegAfec = service.modificar(e);
			if (cantRegAfec == 1)
				response.sendRedirect("empleado");
		}
	}}

}
