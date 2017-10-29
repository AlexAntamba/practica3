package MaestroProveedores.Service;

import java.util.ArrayList;

import MaestroProveedores.Beans.ProveedorBean;
import MaestroProveedores.Interfaces.ProveedorDAO;
import UTIL.BD.DAOFactory;
import UTIL.Params.Parametros;


public class ProveedorService {
	DAOFactory objDAOFactory = DAOFactory.getDAOFactory(Parametros.ORIGEN);
	ProveedorDAO objProveedorDAO = objDAOFactory.getProveedorDAO();
	
	public ArrayList<ProveedorBean> obtenerTodos(){
		return objProveedorDAO.consultarTodos();
	}
	
	public ArrayList<ProveedorBean> codigo(){
		return objProveedorDAO.consultarCodigos();
	}
	
	public int ingresar(ProveedorBean proveedor){
		return objProveedorDAO.ingresarProveedor(proveedor);
	}
	
	public int eliminar(int codigo){
		return objProveedorDAO.eliminarProveedor(codigo);
	}
	
	public ProveedorBean obtenerPorCodigo(int codigo) {
		return objProveedorDAO.consultarPorCodigo(codigo);
	}
	
	public int modificar(ProveedorBean proveedor){
		return objProveedorDAO.modificarProveedor(proveedor);
	}
	
	public ArrayList<ProveedorBean> buscarProveedores(String nombre){
		return objProveedorDAO.buscarProveedores(nombre);
	}
}
