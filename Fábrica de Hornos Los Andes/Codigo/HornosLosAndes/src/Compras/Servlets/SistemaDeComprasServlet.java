package Compras.Servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import Compras.Beans.DetalleOrdenDeCompraBean;
import Compras.Beans.OrdenDeCompraBean;
import Compras.Beans.SistemaDeCompras;
import Compras.Service.DetalleOrdenDeCompraService;
import Compras.Service.OrdenDeCompraService;
import MaestroHornos.Beans.HornoBean;
import MaestroHornos.Service.HornoService;
import UTIL.Beans.UsuarioBean;

/**
 * Servlet implementation class OrdenDeCompraServlet
 */
public class SistemaDeComprasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SistemaDeComprasServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion = request.getSession(false);
		if (sesion.getAttribute("beanUsuarioSes") == null){
			response.sendRedirect("login.html");
		}else{
		HornoService service = new HornoService();
		ArrayList<HornoBean> lista = null;
		lista = service.listarTodos();
		sesion.setAttribute("listaHornos", lista);
		
		getServletContext().getRequestDispatcher("/comprarHornos.jsp").forward(request, response);
	}}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion = request.getSession(false);
		if (sesion == null){
			response.sendRedirect("login.html");
		}else{
		String operacion = request.getParameter("operacion");
		
		ArrayList<SistemaDeCompras> compras = (ArrayList<SistemaDeCompras>)
		sesion.getAttribute("compras");
		if (compras == null)
			compras = new ArrayList<SistemaDeCompras>();
		
		if(operacion.equals("agregar")){
			String [] valores = request.getParameterValues("chkComprar");
			if(valores!=null){
				for (int i=0; i<valores.length; i++){
					int indiceCoincidencia = -1;
				//Se busca el producto en el carrito
				for (int a=0; a<compras.size(); a++){
					if (compras.get(a).getHorno().getCodigo() == Integer.parseInt(valores[i]))
						indiceCoincidencia = a;
					}
		
				if (indiceCoincidencia != -1){ //Si está, entonces se actualiza
					int cantidad = compras.get(indiceCoincidencia).getCantidad();
					compras.get(indiceCoincidencia).setCantidad(++cantidad);	
				}else {  //Si no está, entonces se agrega
					SistemaDeCompras sc = new SistemaDeCompras();
					HornoService service = new HornoService();
					HornoBean m = service.obtenerPorCodigo(Integer.parseInt(valores[i]));
					sc.setHorno(m);
					sc.setCantidad(1);		
					compras.add(sc);
				}
				}
				//Volvemos a poner en sesión el carrito
				sesion.setAttribute("compras", compras);
				getServletContext().getRequestDispatcher("/ordenDeCompra.jsp").forward(request, response);
			}else{
				getServletContext().getRequestDispatcher("/error.jsp").forward(request, response);
			}
		}else{			
			OrdenDeCompraService service = new OrdenDeCompraService();	
			HornoService sss = new HornoService();
			OrdenDeCompraBean compra = new OrdenDeCompraBean();
			ArrayList<OrdenDeCompraBean> lista = service.consultarTodos();
			int codigo=lista.size()+1;
			compra.setNro(codigo);
			compra.setEstado(0);
			GregorianCalendar fecha = new GregorianCalendar();
			String fec="";
			fec = fecha.DAY_OF_MONTH+"/"+fecha.MONTH+"/"+fecha.get(fecha.YEAR);
			compra.setFecha(fec);
			String priori = (String) request.getParameter("prioridad");
			compra.setPrioridad(priori);
			service.ingresar(compra);
			ArrayList<DetalleOrdenDeCompraBean> detalles = new ArrayList<DetalleOrdenDeCompraBean>();
			DetalleOrdenDeCompraBean detalle=null;
			for(int i1=0;i1<compras.size();i1++){
				detalle = new DetalleOrdenDeCompraBean();
				detalle.setNro(codigo);				
				detalle.setCodigo(compras.get(i1).getHorno().getCodigo());
				detalle.setCantidad(compras.get(i1).getCantidad());
				HornoBean hornito=sss.obtenerPorCodigo(compras.get(i1).getHorno().getCodigo());
				double subtotal = compras.get(i1).getCantidad()*hornito.getPrecio();
				detalle.setSubtotal(subtotal);
				detalles.add(detalle);
			}			
			DetalleOrdenDeCompraService serv = new DetalleOrdenDeCompraService();
			for(int j=0;j<detalles.size();j++){
				sss.actualizar(detalles.get(j).getCodigo(), detalles.get(j).getCantidad());
				serv.ingresar(detalles.get(j));
			}
			compras=null;
			//Volvemos a poner en sesión el carrito
			sesion.setAttribute("compras", compras);
			getServletContext().getRequestDispatcher("/respuesta.jsp").forward(request, response);
		}
	} }
}	

