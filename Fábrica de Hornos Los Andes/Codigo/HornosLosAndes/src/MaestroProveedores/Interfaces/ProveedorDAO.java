package MaestroProveedores.Interfaces;

import java.util.ArrayList;

import MaestroProveedores.Beans.ProveedorBean;


public interface ProveedorDAO {
	int ingresarProveedor(ProveedorBean proveedor);
	int modificarProveedor(ProveedorBean proveedor);
	int eliminarProveedor(int codigo);
	ArrayList<ProveedorBean> consultarTodos();	
	ProveedorBean consultarPorCodigo(int codigo);
	ArrayList<ProveedorBean> buscarProveedores(String modelo);
	ArrayList<ProveedorBean> consultarCodigos();
}
