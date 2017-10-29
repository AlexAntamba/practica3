package Empleado.Service;

import java.util.ArrayList;

import Empleado.Beans.EmpleadoBean;
import Empleado.Interfaces.EmpleadoDAO;
import UTIL.BD.DAOFactory;
import UTIL.Params.Parametros;


public class EmpleadoService {
	DAOFactory objDAOFactory = DAOFactory.getDAOFactory(Parametros.ORIGEN);
	EmpleadoDAO objEmpleadoDAO = objDAOFactory.getEmpleadoDAO();
	
	public ArrayList<EmpleadoBean> obtenerTodos(){
		return objEmpleadoDAO.consultarTodos();
	}
	public ArrayList<EmpleadoBean> codigo(){
		return objEmpleadoDAO.consultarCodigos();
	}
	
	public int ingresar(EmpleadoBean empleado){
		return objEmpleadoDAO.ingresarEmpleado(empleado);
	}
	
	public int eliminar(int codigo){
		return objEmpleadoDAO.eliminarEmpleado(codigo);
	}
	
	public EmpleadoBean obtenerPorCodigo(int codigo) {
		return objEmpleadoDAO.consultarPorCodigo(codigo);
	}
	
	public int modificar(EmpleadoBean empleado){
		return objEmpleadoDAO.modificarEmpleado(empleado);
	}
	
	public ArrayList<EmpleadoBean> buscarEmpleados(String nombre, String apellido){
		return objEmpleadoDAO.buscarEmpleados(nombre, apellido);
	}
}
