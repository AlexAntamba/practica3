package MaestroHornos.Servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import MaestroHornos.Beans.HornoBean;
import MaestroHornos.Service.HornoService;


/**
 * Servlet implementation class LibroServlet
 */
public class HornoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HornoServlet() {
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
		HornoService service = new HornoService();
		String destino = "/listaHornos.jsp";
		
		// Accion Eliminar
		if (operacion != null && operacion.equals("buscar")){
			String modelo = request.getParameter("modelo");
			request.setAttribute("Resultados", service.buscarHornos(modelo));
			destino = "/buscarHorno.jsp";
		} 
		
		if (operacion != null && operacion.equals("eliminar")){
			int codigo = Integer.parseInt(request.getParameter("codigo"));
			service.eliminar(codigo);
		} 
		
		// Operacion Modificar
		if (operacion != null && operacion.equals("modificar")   ) {
			String codigo = request.getParameter("codigo");
			
			if (codigo != null){
				HornoBean mb = service.obtenerPorCodigo(Integer.parseInt(codigo));
				request.setAttribute("hornoReq", mb);
				System.out.println(""+codigo+mb.getDescripcion());
				if (mb != null){
					destino = "/hornoEdit.jsp";
				}
			}			
		} 
		else {			
			ArrayList<HornoBean> lista = service.obtenerTodos();
			sesion.setAttribute("listaHornos", lista);
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
			getServletContext().getRequestDispatcher("/hornoNew.jsp").forward(request, response);
		} 
		
		// Accion Ingresar
		else if (accion != null && accion.equals("ingresar")){
			HornoService service = new HornoService();
			HornoBean horno = new HornoBean();

			ArrayList<HornoBean> m = new ArrayList<HornoBean>();
			m = service.codigo();
			horno.setCodigo(m.size()+1);
			horno.setModelo(request.getParameter("modelo"));
			horno.setGarantia(request.getParameter("garantia"));
			horno.setDescripcion(request.getParameter("descripcion"));
			GregorianCalendar fecha = new GregorianCalendar();
			String fec="";
			fec = fecha.DAY_OF_MONTH+"/"+fecha.MONTH+"/"+fecha.get(fecha.YEAR);
			horno.setFecreg(fec);
			horno.setDimensiones(request.getParameter("dimensiones"));
			horno.setStock(Integer.parseInt(request.getParameter("stock")));
			horno.setPrecio(Double.parseDouble(request.getParameter("precio")));
			horno.setEstado(1);
			
			service.ingresar(horno);
			response.sendRedirect("horno");
		} 
		
		// Accion Modificar
		else if (accion != null && accion.equals("modificar")){
			int codigo = Integer.parseInt(request.getParameter("codigo"));
			String modelo = request.getParameter("modelo");
			String garantia = request.getParameter("garantia");
			String descripcion = request.getParameter("descripcion");
			String dimensiones = request.getParameter("dimensiones");
			int stock = Integer.parseInt(request.getParameter("stock"));
			double precio = Double.parseDouble(request.getParameter("precio"));
			
			HornoBean h = new HornoBean();
			h.setCodigo(codigo);
			h.setModelo(modelo);
			h.setGarantia(garantia);
			h.setDescripcion(descripcion);
			h.setDimensiones(dimensiones);
			h.setStock(stock);
			h.setPrecio(precio);
			
			HornoService service = new HornoService();
			int cantRegAfec = service.modificar(h);
			if (cantRegAfec == 1)
				response.sendRedirect("horno");
		}
	}}

}
