package Compras.Servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Compras.Beans.DetalleFacturaBean;
import Compras.Beans.DetalleOrdenDeCompraBean;
import Compras.Beans.FacturaBean;
import Compras.Beans.OrdenDeCompraBean;
import Compras.DAO.MySqlFacturaDAO;
import Compras.Service.DetalleOrdenDeCompraService;
import Compras.Service.OrdenDeCompraService;
import MaestroHornos.Beans.HornoBean;
import MaestroHornos.Service.HornoService;
import UTIL.Beans.UsuarioBean;

/**
 * Servlet implementation class FacturaServlet
 */
public class FacturaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FacturaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession sesion = request.getSession(false);
		if (sesion.getAttribute("beanUsuarioSes") == null){
			response.sendRedirect("login.html");
		}else{
		System.out.println("Entra al get");
		String operacion = request.getParameter("operacion");
		if(operacion !=null && operacion.equals("listar")){
			OrdenDeCompraService service = new OrdenDeCompraService();
			DetalleOrdenDeCompraService service2 = new DetalleOrdenDeCompraService();
			int codigo=Integer.parseInt(request.getParameter("codigo"));
			ArrayList<DetalleOrdenDeCompraBean> detalles = service2.obtenerDetalles(codigo);
			sesion.setAttribute("detalles", detalles);
			getServletContext().getRequestDispatcher("/registrarFactura.jsp").forward(request, response);
		}else{
			OrdenDeCompraService service = new OrdenDeCompraService();
			ArrayList<OrdenDeCompraBean> ordenes = null;
			ordenes = service.listarOrdenes();
			sesion.setAttribute("listaOrden", ordenes);
			getServletContext().getRequestDispatcher("/facturarOrden.jsp").forward(request, response);
		}}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession sesion = request.getSession(false);
		if (sesion.getAttribute("beanUsuarioSes") == null){
			response.sendRedirect("login.html");
		}else{
		String operacion = request.getParameter("operacion");
		 if(operacion !=null && operacion.equals("registrar")){
				MySqlFacturaDAO service = new MySqlFacturaDAO();
				HornoService horno = new HornoService();
				FacturaBean factura=new FacturaBean();
				ArrayList<DetalleOrdenDeCompraBean> detalles =(ArrayList<DetalleOrdenDeCompraBean>)sesion.getAttribute("detalles");
				int codigo = service.codigos();
				factura.setCodigo(codigo);
				UsuarioBean usuario = (UsuarioBean) sesion.getAttribute("beanUsuarioSes");
				factura.setNombre(usuario.getNombre());
				GregorianCalendar fecha = new GregorianCalendar();
				String fec="";
				fec = fecha.DAY_OF_MONTH+"/"+fecha.MONTH+"/"+fecha.get(fecha.YEAR);
				factura.setFecha(fec);
				double total=0;
				for(int i=0;i<detalles.size();i++){
					DetalleFacturaBean detalle = new DetalleFacturaBean();
					detalle.setCodigo(codigo);
					factura.setNroOrden(detalles.get(i).getNro());
					detalle.setCodHorno(detalles.get(i).getCodigo());
					detalle.setCantidad(detalles.get(i).getCantidad());
					HornoBean hornito=horno.obtenerPorCodigo(detalles.get(i).getCodigo());
					detalle.setPrecio(hornito.getPrecio());
					detalle.setSubtotal(detalles.get(i).getSubtotal());
					double m =detalle.getCantidad()*detalle.getPrecio();
					total+=m;
					service.ingresarDetalleFactura(detalle);
				}
				OrdenDeCompraService sss = new OrdenDeCompraService();
				sss.actualizar(factura.getNroOrden());
				factura.setTotal(total);
				service.ingresarFactura(factura);
				getServletContext().getRequestDispatcher("/rpta.jsp").forward(request, response);
			}
		
		}
		
	}

}
