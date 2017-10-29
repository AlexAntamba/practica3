package MaestroMateriales.Servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import MaestroMateriales.Beans.MaterialBean;
import MaestroMateriales.Service.MaterialService;


/**
 * Servlet implementation class LibroServlet
 */
public class MaterialServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MaterialServlet() {
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
		MaterialService service = new MaterialService();
		String destino = "/listaMateriales.jsp";
		
		// Accion Eliminar
		if (operacion != null && operacion.equals("buscar")){
			String nombre = request.getParameter("nombre");
			String tipo = request.getParameter("tipo");	
			request.setAttribute("Resultados", service.buscarMateriales(nombre, tipo));
			destino = "/buscarMateriales.jsp";
		} 
		
		if (operacion != null && operacion.equals("eliminar")){
			int codigo = Integer.parseInt(request.getParameter("codigo"));
			service.eliminar(codigo);
		} 
		
		// Operacion Modificar
		if (operacion != null && operacion.equals("modificar")   ) {
			String codigo = request.getParameter("codigo");
			if (codigo != null){
				MaterialBean mb = service.obtenerPorCodigo(Integer.parseInt(codigo));
				request.setAttribute("materialReq", mb);
				if (mb != null){
					destino = "/materialEdit.jsp";
				}
			}			
		} 
		ArrayList<MaterialBean> lista = service.obtenerTodos();
		sesion.setAttribute("listaMateriales", lista);
		
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
		// Accion Ingresar
		if (accion != null && accion.equals("ingresar")){
			MaterialService service = new MaterialService();
			MaterialBean material = new MaterialBean();
			ArrayList<MaterialBean> m = new ArrayList<MaterialBean>();
			m = service.codigo();
			material.setCodigo(m.size()+1);
			material.setNombre(request.getParameter("nombre"));
			material.setTipo(request.getParameter("tipo"));
			material.setDurabilidad(request.getParameter("durabilidad"));
			GregorianCalendar fecha = new GregorianCalendar();
			String fec="";
			fec = fecha.DAY_OF_MONTH+"/"+fecha.MONTH+"/"+fecha.get(fecha.YEAR);
			material.setFecreg(fec);
			material.setDetuso(request.getParameter("detuso"));
			material.setTipo(request.getParameter("tipo"));
			material.setStock(Integer.parseInt(request.getParameter("stock")));
			material.setEstado(1);
			
			service.ingresar(material);
			response.sendRedirect("material");
		} 
		
		// Accion Modificar
		else if (accion != null && accion.equals("modificar")){
			int codigo = Integer.parseInt(request.getParameter("codigo"));
			String nombre = request.getParameter("nombre");
			String tipo = request.getParameter("tipo");
			String durabilidad = request.getParameter("durabilidad");
			String detuso = request.getParameter("detuso");
			int stock = Integer.parseInt(request.getParameter("stock"));
			
			
			MaterialBean mb = new MaterialBean();
			mb.setCodigo(codigo);
			mb.setNombre(nombre);
			mb.setTipo(tipo);
			mb.setDurabilidad(durabilidad);
			mb.setDetuso(detuso);
			mb.setStock(stock);
			
			MaterialService service = new MaterialService();
			int cantRegAfec = service.modificar(mb);
			if (cantRegAfec == 1)
				response.sendRedirect("material");
		}
	}}

}
