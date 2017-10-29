package UTIL.BD;
import Compras.Interfaces.DetalleOrdenDeCompraDAO;
import Compras.Interfaces.FacturaDAO;
import Compras.Interfaces.OrdenDeCompraDAO;
import Empleado.Interfaces.EmpleadoDAO;
import MaestroHornos.Interfaces.HornoDAO;
import MaestroMateriales.DAO.MySqlMaterialDAO;
import MaestroMateriales.Interfaces.MaterialDAO;
import MaestroProveedores.Interfaces.ProveedorDAO;
import UTIL.Interfaces.UsuarioDAO;
public class OracleDAOFactory extends DAOFactory{
	@Override
	public MaterialDAO getMaterialDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UsuarioDAO getUsuarioDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmpleadoDAO getEmpleadoDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HornoDAO getHornoDAO() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public OrdenDeCompraDAO getOrdenDeCompraDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DetalleOrdenDeCompraDAO getDetalleOrdenDeCompraDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProveedorDAO getProveedorDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FacturaDAO getFacturaDAO() {
		// TODO Auto-generated method stub
		return null;
	} 
}
