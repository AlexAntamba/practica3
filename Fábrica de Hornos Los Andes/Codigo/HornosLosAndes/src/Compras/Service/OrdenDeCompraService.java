package Compras.Service;

import java.util.ArrayList;

import Compras.Beans.OrdenDeCompraBean;
import Compras.Interfaces.OrdenDeCompraDAO;
import UTIL.BD.DAOFactory;
import UTIL.Params.Parametros;


public class OrdenDeCompraService {
	DAOFactory objDAOFactory = DAOFactory.getDAOFactory(Parametros.ORIGEN);
	OrdenDeCompraDAO objOrdenDeCompraDAO = objDAOFactory.getOrdenDeCompraDAO();
			
		public int ingresar(OrdenDeCompraBean orden){
			return objOrdenDeCompraDAO.ingresarOrdenDeCompra(orden);
		}
		
		public OrdenDeCompraBean obtenerPorCodigo(int codigo) {
			return objOrdenDeCompraDAO.consultarPorCodigo(codigo);
		}
		
		public ArrayList<OrdenDeCompraBean> consultarTodos(){
			return objOrdenDeCompraDAO.consultarTodos();
		}
		public int actualizar(int nro){
			return objOrdenDeCompraDAO.actualizar(nro);
		}
		
		public ArrayList<OrdenDeCompraBean> listarOrdenes(){
			return objOrdenDeCompraDAO.listarOrdenes();
		}
		

}
