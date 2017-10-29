package Empleado.Interfaces;

import java.util.ArrayList;

import Empleado.Beans.EmpleadoBean;


public interface EmpleadoDAO {
	int ingresarEmpleado(EmpleadoBean Empleado);
	int modificarEmpleado(EmpleadoBean Empleado);
	int eliminarEmpleado(int codigo);
	ArrayList<EmpleadoBean> consultarTodos();
	EmpleadoBean consultarPorCodigo(int codigo);
	ArrayList<EmpleadoBean> buscarEmpleados(String nombre, String apellido);
	ArrayList<EmpleadoBean> consultarCodigos();
}
