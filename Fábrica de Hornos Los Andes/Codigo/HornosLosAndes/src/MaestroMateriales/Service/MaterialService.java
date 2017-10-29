package MaestroMateriales.Service;

import java.util.ArrayList;

import MaestroMateriales.Beans.MaterialBean;
import MaestroMateriales.Interfaces.MaterialDAO;
import UTIL.BD.DAOFactory;
import UTIL.Params.Parametros;


public class MaterialService {
	DAOFactory objDAOFactory = DAOFactory.getDAOFactory(Parametros.ORIGEN);
	MaterialDAO objMaterialDAO = objDAOFactory.getMaterialDAO();
	
	public ArrayList<MaterialBean> obtenerTodos(){
		return objMaterialDAO.consultarTodos();
	}
	
	public ArrayList<MaterialBean> codigo(){
		return objMaterialDAO.consultarCodigos();
	}
	
	public int ingresar(MaterialBean material){
		return objMaterialDAO.ingresarMaterial(material);
	}
	
	public int eliminar(int codigo){
		return objMaterialDAO.eliminarMaterial(codigo);
	}
	
	public MaterialBean obtenerPorCodigo(int codigo) {
		return objMaterialDAO.consultarPorCodigo(codigo);
	}
	
	public int modificar(MaterialBean material){
		return objMaterialDAO.modificarMaterial(material);
	}
	
	public ArrayList<MaterialBean> buscarMateriales(String nombre, String tipo){
		return objMaterialDAO.buscarMateriales(nombre, tipo);
	}
}
