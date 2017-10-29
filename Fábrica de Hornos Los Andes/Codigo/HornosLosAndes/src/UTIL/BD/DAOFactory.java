package UTIL.BD;

import Compras.Interfaces.DetalleOrdenDeCompraDAO;
import Compras.Interfaces.FacturaDAO;
import Compras.Interfaces.OrdenDeCompraDAO;
import Empleado.Interfaces.EmpleadoDAO;
import MaestroHornos.Interfaces.HornoDAO;
import MaestroMateriales.Interfaces.MaterialDAO;
import MaestroProveedores.Interfaces.ProveedorDAO;
import UTIL.Interfaces.UsuarioDAO;

public abstract class DAOFactory {
	public static final int MYSQL = 1;
	public static final int SQLSERVER = 2;
	public static final int ORACLE = 3;
	public static final int POSTGRESQL = 4;	
	
	public static DAOFactory getDAOFactory(int tipoBD){
		DAOFactory daoFactory = null;
		switch(tipoBD){
			case MYSQL: daoFactory = new MySqlDAOFactory(); break;
			case SQLSERVER: daoFactory = new SqlServerDAOFactory(); break;
			case ORACLE: daoFactory = new OracleDAOFactory(); break;
			default: daoFactory = null;
		}
		return daoFactory;
	}
	public abstract MaterialDAO getMaterialDAO();
	public abstract UsuarioDAO getUsuarioDAO();
	public abstract EmpleadoDAO getEmpleadoDAO();
	public abstract HornoDAO getHornoDAO();
	public abstract ProveedorDAO getProveedorDAO();
	public abstract OrdenDeCompraDAO getOrdenDeCompraDAO(); 
	public abstract DetalleOrdenDeCompraDAO getDetalleOrdenDeCompraDAO();
	public abstract FacturaDAO getFacturaDAO();
}
