package UTIL.BD;

import Compras.DAO.MySqlDetalleOrdenDeCompraDAO;
import Compras.DAO.MySqlOrdenDeCompraDAO;
import Compras.Interfaces.DetalleOrdenDeCompraDAO;
import Compras.Interfaces.FacturaDAO;
import Compras.Interfaces.OrdenDeCompraDAO;
import Empleado.DAO.MySqlEmpleadoDAO;
import Empleado.Interfaces.EmpleadoDAO;
import MaestroHornos.DAO.MySqlHornoDAO;
import MaestroHornos.Interfaces.HornoDAO;
import MaestroMateriales.DAO.MySqlMaterialDAO;
import MaestroMateriales.Interfaces.MaterialDAO;
import MaestroProveedores.DAO.MySqlProveedorDAO;
import MaestroProveedores.Interfaces.ProveedorDAO;
import UTIL.DAO.MySqlUsuarioDAO;
import UTIL.Interfaces.UsuarioDAO;

public class MySqlDAOFactory extends DAOFactory{
	public MaterialDAO getMaterialDAO() {
		// TODO Auto-generated method stub
		return new MySqlMaterialDAO();
	}

	public UsuarioDAO getUsuarioDAO() {
		// TODO Auto-generated method stub
		return new MySqlUsuarioDAO();
	}
	
	public EmpleadoDAO getEmpleadoDAO() {
		// TODO Auto-generated method stub
		return new MySqlEmpleadoDAO();
	}

	public HornoDAO getHornoDAO() {
		// TODO Auto-generated method stub
		return new MySqlHornoDAO(); 
	}

	public OrdenDeCompraDAO getOrdenDeCompraDAO() {
		// TODO Auto-generated method stub
		return new MySqlOrdenDeCompraDAO();
	} 
	
	public DetalleOrdenDeCompraDAO getDetalleOrdenDeCompraDAO() {
		// TODO Auto-generated method stub
		return new MySqlDetalleOrdenDeCompraDAO(); 
	}

	@Override
	public ProveedorDAO getProveedorDAO() {
		// TODO Auto-generated method stub
		return new MySqlProveedorDAO();
	}

	@Override
	public FacturaDAO getFacturaDAO() {
		// TODO Auto-generated method stub
		return null;
	} 
}
