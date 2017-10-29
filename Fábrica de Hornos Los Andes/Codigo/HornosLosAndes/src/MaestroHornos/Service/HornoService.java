package MaestroHornos.Service;

import java.util.ArrayList;

import MaestroHornos.Beans.HornoBean;
import MaestroHornos.Interfaces.HornoDAO;
import UTIL.BD.DAOFactory;
import UTIL.Params.Parametros;


public class HornoService {
	DAOFactory objDAOFactory = DAOFactory.getDAOFactory(Parametros.ORIGEN);
	HornoDAO objHornoDAO = objDAOFactory.getHornoDAO();
	
	public ArrayList<HornoBean> obtenerTodos(){
		return objHornoDAO.consultarTodos();
	}
	public ArrayList<HornoBean> codigo(){
		return objHornoDAO.consultarCodigos();
	}
	
	public int ingresar(HornoBean horno){
		return objHornoDAO.ingresarHorno(horno);
	}
	
	public int eliminar(int codigo){
		return objHornoDAO.eliminarHorno(codigo);
	}
	
	public HornoBean obtenerPorCodigo(int codigo) {
		return objHornoDAO.consultarPorCodigo(codigo);
	}
	
	public int modificar(HornoBean horno){
		return objHornoDAO.modificarHorno(horno);
	}
	
	public ArrayList<HornoBean> buscarHornos(String modelo){
		return objHornoDAO.buscarHornos(modelo);
	}
	
	public int actualizar(int codigo,int cantidad){
		return objHornoDAO.actualizarStock(codigo, cantidad);
	}
	public ArrayList<HornoBean> listarTodos() {
		// TODO Auto-generated method stub
		return objHornoDAO.listarTodos();
	}
}
