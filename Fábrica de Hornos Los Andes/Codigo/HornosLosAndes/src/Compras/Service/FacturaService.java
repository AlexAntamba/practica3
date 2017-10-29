package Compras.Service;

import java.util.ArrayList;

import Compras.Beans.DetalleFacturaBean;
import Compras.Beans.FacturaBean;
import Compras.Interfaces.FacturaDAO;
import UTIL.BD.DAOFactory;
import UTIL.Params.Parametros;


public class FacturaService {
	DAOFactory objDAOFactory = DAOFactory.getDAOFactory(Parametros.ORIGEN);
	FacturaDAO objFacturaDAO = objDAOFactory.getFacturaDAO();
	
	public int consultarCodigo(){
		int cod=objFacturaDAO.codigos();
		return cod;
	}
	
	public int ingresarFactura(FacturaBean factura){
		return objFacturaDAO.ingresarFactura(factura);
	}
	
	public int ingresarDetalleFactura(DetalleFacturaBean detalle){
		return objFacturaDAO.ingresarDetalleFactura(detalle);
	}
	
}
