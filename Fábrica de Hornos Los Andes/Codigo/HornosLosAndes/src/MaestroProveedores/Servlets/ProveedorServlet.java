package MaestroProveedores.Servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import MaestroProveedores.Beans.ProveedorBean;
import MaestroProveedores.Service.ProveedorService;


/**
 * Servlet implementation class ProveedorServlet
 */
public class ProveedorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProveedorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String operacion = request.getParameter("operacion");
		HttpSession sesion = request.getSession(false);
		if (sesion.getAttribute("beanUsuarioSes") == null){
			response.sendRedirect("login.html");
		}else{
		ProveedorService service = new ProveedorService();
		String destino = "/listaProveedores.jsp";
		
		// Accion Eliminar
		if (operacion != null && operacion.equals("buscar")){
			String nombre = request.getParameter("nombre");
			request.setAttribute("Resultados", service.buscarProveedores(nombre));
			destino = "/buscarProveedor.jsp";
		} 
		
		if (operacion != null && operacion.equals("eliminar")){
			int codigo = Integer.parseInt(request.getParameter("codigo"));
			service.eliminar(codigo);
		} 
		
		// Operacion Modificar
		if (operacion != null && operacion.equals("modificar")   ) {
			String codigo = request.getParameter("codigo");
			
			if (codigo != null){
				ProveedorBean mb = service.obtenerPorCodigo(Integer.parseInt(codigo));
				request.setAttribute("proveedorReq", mb);
				if (mb != null){
					destino = "/proveedorEdit.jsp";
				}
			}			
		} 
		else {			
			ArrayList<ProveedorBean> lista = service.obtenerTodos();
			sesion.setAttribute("listaProveedores", lista);
		}
		getServletContext().getRequestDispatcher(destino).forward(request, response);
	}}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String accion = request.getParameter("accion");
		HttpSession sesion = request.getSession(false);
		if (sesion.getAttribute("beanUsuarioSes") == null){
			response.sendRedirect("login.html");
		}else{
		if (accion != null && accion.equals("nuevo")){
			getServletContext().getRequestDispatcher("/proveedorNew.jsp").forward(request, response);
		} 
		
		// Accion Ingresar
		else if (accion != null && accion.equals("ingresar")){
			ProveedorService service = new ProveedorService();
			ProveedorBean proveedor = new ProveedorBean();
			ArrayList<ProveedorBean> m = new ArrayList<ProveedorBean>();
			m = service.codigo();
			proveedor.setCodigo(m.size()+1);
			proveedor.setNombre(request.getParameter("nombre"));
			proveedor.setDireccion(request.getParameter("direccion"));
			proveedor.setTelefono(request.getParameter("telefono"));
			proveedor.setEmail(request.getParameter("TextField"));
			proveedor.setCiudad(request.getParameter("ciudad"));
			GregorianCalendar fecha = new GregorianCalendar();
			String fec="";
			fec = fecha.DAY_OF_MONTH+"/"+fecha.MONTH+"/"+fecha.get(fecha.YEAR);
			proveedor.setFechainicio(fec);
			proveedor.setEstado(1);
			service.ingresar(proveedor);
			response.sendRedirect("proveedor");
		}
		
		// Accion Modificar
		else if (accion != null && accion.equals("modificar")){
			int codigo = Integer.parseInt(request.getParameter("codigo"));
			String nombre = request.getParameter("nombre");
			String direccion = request.getParameter("direccion");
			String telefono = request.getParameter("telefono");
			String email = request.getParameter("TextField");
			String ciudad = request.getParameter("ciudad");
			
			ProveedorBean h = new ProveedorBean();
			h.setCodigo(codigo);
			h.setNombre(nombre);
			h.setDireccion(direccion);
			h.setTelefono(telefono);
			h.setEmail(email);
			h.setCiudad(ciudad);
			
			ProveedorService service = new ProveedorService();
			int cantRegAfec = service.modificar(h);
			if (cantRegAfec == 1)
				response.sendRedirect("proveedor");
		}
	}}

}
