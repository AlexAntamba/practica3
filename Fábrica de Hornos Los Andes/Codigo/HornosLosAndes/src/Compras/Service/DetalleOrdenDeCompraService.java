package Compras.Service;

import java.util.ArrayList;

import Compras.Beans.DetalleOrdenDeCompraBean;
import Compras.Interfaces.DetalleOrdenDeCompraDAO;
import UTIL.BD.DAOFactory;
import UTIL.Params.Parametros;

public class DetalleOrdenDeCompraService {
	DAOFactory objDAOFactory = DAOFactory.getDAOFactory(Parametros.ORIGEN);
	DetalleOrdenDeCompraDAO objDetalleOrdenDeCompraDAO = objDAOFactory.getDetalleOrdenDeCompraDAO();

		public int ingresar(DetalleOrdenDeCompraBean orden){
			return objDetalleOrdenDeCompraDAO.ingresarDetalleOrdenDeCompra(orden);
		}
		public ArrayList<DetalleOrdenDeCompraBean> obtenerDetalles(int codigo){
			return objDetalleOrdenDeCompraDAO.obtenerDetalles(codigo);
		}
}
